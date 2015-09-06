package me.exerosis.entity.server.connection;

import me.exerosis.entity.server.Server;
import me.exerosis.entity.server.event.packet.ReceivePacketEvent;
import me.exerosis.entity.server.event.packet.SendPacketEvent;
import me.exerosis.entity.server.event.player.LeavePlayerEvent;
import me.exerosis.entity.server.packets.Packet;
import me.exerosis.entity.server.packets.in.player.PacketInLeave;
import me.exerosis.entity.server.packets.out.player.PacketOutKick;
import me.exerosis.entity.server.util.socket.SocketListener;

import java.util.UUID;

/**
 * Created by The Exerosis on 8/5/2015.
 */
public class PlayerConnection {
    private final UUID uuid;
    private SocketListener socketListener;

    public PlayerConnection(SocketListener socket, UUID uuid) {
        this.uuid = uuid;
        socket.setObjectReceiver(object -> {
            Server.getEventManager().callEvent(new ReceivePacketEvent(PlayerConnection.this, (Packet) object));

            if(object instanceof PacketInLeave)
                Server.getEventManager().callEvent(new LeavePlayerEvent(PlayerConnection.this), event -> Server.getPlayerManager().getPlayers().remove(PlayerConnection.this));
        });
    }


    public void kick(String reason, boolean ban){
        sendPacket(new PacketOutKick(reason, ban));
        if(ban)
            Server.getPlayerManager().banPlayer(this, reason);
        socketListener.close();
    }

    public void sendPacket(Packet packet){
        Server.getEventManager().callEvent(new SendPacketEvent(this, packet), event -> {
            if (!event.isCancelled())
                socketListener.sendObject(packet);
        });
    }

    public UUID getUUID() {
        return uuid;
    }

    public SocketListener getSocketListener() {
        return socketListener;
    }
}