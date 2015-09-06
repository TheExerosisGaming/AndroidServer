package me.exerosis.entity.server.packets.out.entity;

import me.exerosis.entity.Entity;
import me.exerosis.entity.server.packets.out.PacketOut;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class EntityPacket extends PacketOut {
    private Entity entity;

    public EntityPacket(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}