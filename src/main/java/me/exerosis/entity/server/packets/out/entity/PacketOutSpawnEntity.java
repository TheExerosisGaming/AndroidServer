package me.exerosis.entity.server.packets.out.entity;

import me.exerosis.entity.Entity;

/**
 * Created by The Exerosis on 8/10/2015.
 */
public class PacketOutSpawnEntity extends EntityPacket {

    public PacketOutSpawnEntity(Entity entity) {
        super(entity);
    }
}