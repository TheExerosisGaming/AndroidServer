package me.exerosis.entity.server.event.packet;

import me.exerosis.entity.server.connection.PlayerConnection;
import me.exerosis.entity.server.packets.Packet;
import me.exerosis.reflection.event.Cancellable;

/**
 * Created by The Exerosis on 8/6/2015.
 */
public class SendPacketEvent extends PacketEvent implements Cancellable {
    private boolean cancelled;

    public SendPacketEvent(PlayerConnection player, Packet packet) {
        super(player, packet);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}