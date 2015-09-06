package me.exerosis.entity.server.util.socket;

import java.io.*;
import java.net.Socket;

/**x
 * Created by The Exerosis on 8/5/2015.
 */
public class SocketListener {
    private Socket socket;
    private ObjectReceiver objectReceiver;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    public SocketListener(Socket socket, ObjectReceiver objectReceiver) {
        this.socket = socket;
        this.objectReceiver = objectReceiver;
        try {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            outputStream = new ObjectOutputStream(new BufferedOutputStream(out));
            inputStream = new ObjectInputStream(new BufferedInputStream(in));
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Thread(){
            @Override
            public void run() {
                Object object;
                while (!socket.isClosed()) {
                    try {
                        object = inputStream.readObject();

                        if (object != null)
                            objectReceiver.onObjectReceived(object);
                    }
                    catch (Exception ignored) {}
                    finally {
                        object = null;
                    }
                }
            }
        }.start();
    }

    public ObjectReceiver getObjectReceiver() {
        return objectReceiver;
    }

    public void setObjectReceiver(ObjectReceiver objectReceiver) {
        this.objectReceiver = objectReceiver;
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void close(){
        try {
            socket.close();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendObject(Object object){
        if(socket == null || socket.isClosed() || !socket.isConnected())
            return;
        try {
            outputStream.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}