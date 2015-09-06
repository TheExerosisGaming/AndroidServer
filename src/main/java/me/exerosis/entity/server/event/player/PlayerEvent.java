package me.exerosis.entity.server.event.player;

import me.exerosis.entity.server.connection.PlayerConnection;

/**
 * Created by The Exerosis on 8/6/2015.
 */
public class PlayerEvent {
    private PlayerConnection player;

    public PlayerEvent(PlayerConnection player) {
        this.player = player;
    }

    public PlayerConnection getPlayer() {
        return player;
    }
}
