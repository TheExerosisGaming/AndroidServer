package me.exerosis.entity.server.event.player;

import me.exerosis.entity.server.connection.PlayerConnection;

/**
 * Created by The Exerosis on 8/10/2015.
 */
public class LeavePlayerEvent extends PlayerEvent {
    public LeavePlayerEvent(PlayerConnection player) {
        super(player);
    }
}