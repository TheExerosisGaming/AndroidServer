package me.exerosis.entity.server.manager;

import me.exerosis.entity.server.Server;
import me.exerosis.entity.server.connection.AttemptConnection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Exerosis on 8/4/2015.
 */
public class ConnectionManager extends Thread {
    private static ConnectionManager instance;
    private static int id;

    private ServerSocket listeningSocket;
    private String hostname;
    private int port;

    public ConnectionManager() {}

    @Override
    public void run() {
        try {
            listeningSocket = new ServerSocket(port);
        }   catch (IOException e) {
            System.err.println("Could not listen on port: " + port);
            System.exit(-1);
        }

        while(Server.isOnline() && listeningSocket != null && !listeningSocket.isClosed()){
            Socket socket = null;
            try {
                socket = listeningSocket.accept();
            } catch (IOException e) {
                System.err.println("Could not accept an incoming connection!");
            }

            if(socket != null)
                new AttemptConnection(socket).start();
        }
    }

    public void close(){
        try {
            listeningSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance() {
        if(instance == null)
            instance = new ConnectionManager();
        return instance;
    }
}
