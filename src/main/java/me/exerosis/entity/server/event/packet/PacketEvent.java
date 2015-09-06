package me.exerosis.entity.server.event.packet;

import me.exerosis.entity.server.connection.PlayerConnection;
import me.exerosis.entity.server.event.player.PlayerEvent;
import me.exerosis.entity.server.packets.Packet;

/**
 * Created by The Exerosis on 8/6/2015.
 */
public class PacketEvent extends PlayerEvent {
    private PlayerConnection player;
    private Packet packet;

    public PacketEvent(PlayerConnection player, Packet packet) {
        super(player);
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }
}
