package me.exerosis.entity.server.connection;

import me.exerosis.entity.server.Server;
import me.exerosis.entity.server.event.player.JoinPlayerEvent;
import me.exerosis.entity.server.manager.PlayerManager;
import me.exerosis.entity.server.packets.in.player.PacketInJoin;
import me.exerosis.entity.server.packets.out.player.PacketOutAccept;
import me.exerosis.entity.server.util.TimeUtil;
import me.exerosis.entity.server.util.socket.SocketListener;

import java.net.Socket;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class AttemptConnection extends Thread {
    private Socket socket;
    private SocketListener socketListener;

    public AttemptConnection(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        socketListener = new SocketListener(socket, object -> {
            if(!(object instanceof PacketInJoin))
                return;

            PacketInJoin packet = (PacketInJoin) object;
            PlayerConnection player = new PlayerConnection(socketListener, packet.getUUID());
            PlayerManager manager = Server.getPlayerManager();

            if(manager.isBan(player.getUUID())) {
                player.kick(manager.getReason(player.getUUID()), true);
                return;
            }

            Server.getEventManager().callEvent(new JoinPlayerEvent(player), event -> {
                if (event.isDisallowed())
                    player.kick(event.getDisallowReason(), false);

                else {
                    player.sendPacket(new PacketOutAccept());
                    manager.getPlayers().add(player);
                }
            });
        });

        TimeUtil.runTaskLater(10000, socketListener::close);
    }
}
