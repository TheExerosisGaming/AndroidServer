package me.exerosis.entity.server.event.player;

import me.exerosis.entity.server.connection.PlayerConnection;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class JoinPlayerEvent extends PlayerEvent {
    private boolean disallowed;
    private String reason;

    public JoinPlayerEvent(PlayerConnection player) {
        super(player);
    }

    public boolean isDisallowed(){
        return disallowed;
    }

    public void disallow(String reason){
        disallowed = true;
        this.reason = reason;
    }

    public String getDisallowReason() {
        return reason;
    }
}
