package me.exerosis.entity;

import me.exerosis.reflection.pool.InstancePool;

import java.io.Serializable;

/**
 * Created by The Exerosis on 8/2/2015.
 */
public abstract class Property implements Serializable {
    @InstancePool.Depend
    private Entity entity;

    public Property() {}

    public Entity getEntity() {
        return entity;
    }

    public abstract void onEnable();
    public abstract void onDisable();
}
