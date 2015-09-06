package me.exerosis.entity.server.event.event;

import me.exerosis.entity.Entity;

/**
 * Created by The Exerosis on 8/6/2015.
 */
public class EntityEvent {
    private Entity entity;

    public EntityEvent(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
