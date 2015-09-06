package me.exerosis.entity.server.event.packet;

import me.exerosis.entity.server.connection.PlayerConnection;
import me.exerosis.entity.server.packets.Packet;

/**
 * Created by The Exerosis on 8/6/2015.
 */
public class ReceivePacketEvent extends PacketEvent {
    public ReceivePacketEvent(PlayerConnection player, Packet packet) {
        super(player, packet);
    }
}
