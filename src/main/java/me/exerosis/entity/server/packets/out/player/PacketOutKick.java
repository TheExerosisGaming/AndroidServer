package me.exerosis.entity.server.packets.out.player;

import me.exerosis.entity.server.packets.out.PacketOut;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class PacketOutKick extends PacketOut {
    private final String reason;
    private final boolean ban;

    public PacketOutKick(String reason, boolean ban) {
        this.reason = reason;
        this.ban = ban;
    }

    public String getReason() {
        return reason;
    }

    public boolean isBan() {
        return ban;
    }
}