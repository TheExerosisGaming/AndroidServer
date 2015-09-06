package me.exerosis.entity.server.packets.in.player;

import me.exerosis.entity.server.packets.in.PacketIn;

import java.util.UUID;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class PacketInLeave extends PacketIn {
    private UUID uuid;

    public PacketInLeave(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUUID() {
        return uuid;
    }
}