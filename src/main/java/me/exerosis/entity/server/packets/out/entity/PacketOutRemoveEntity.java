package me.exerosis.entity.server.packets.out.entity;

import me.exerosis.entity.Entity;

/**
 * Created by The Exerosis on 8/10/2015.
 */
public class PacketOutRemoveEntity extends EntityPacket {

    public PacketOutRemoveEntity(Entity entity) {
        super(entity);
    }
}