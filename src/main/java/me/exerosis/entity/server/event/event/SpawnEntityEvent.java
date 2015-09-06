package me.exerosis.entity.server.event.event;

import me.exerosis.entity.Entity;
import me.exerosis.reflection.event.Cancellable;

/**
 * Created by The Exerosis on 8/10/2015.
 */
public class SpawnEntityEvent extends EntityEvent implements Cancellable {
    private boolean cancelled;

    public SpawnEntityEvent(Entity entity) {
        super(entity);
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