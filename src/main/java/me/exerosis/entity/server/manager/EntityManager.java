package me.exerosis.entity.server.manager;

import me.exerosis.entity.Entity;
import me.exerosis.entity.server.Server;
import me.exerosis.entity.server.event.event.RemoveEntityEvent;
import me.exerosis.entity.server.event.event.SpawnEntityEvent;
import me.exerosis.entity.server.packets.out.entity.PacketOutRemoveEntity;
import me.exerosis.entity.server.packets.out.entity.PacketOutSpawnEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Exerosis on 8/4/2015.
 */
public class EntityManager {
    private List<Entity> entities = new ArrayList<>();

    public void spawnEntity(Entity entity){
        Server.getEventManager().callEvent(new SpawnEntityEvent(entity), event -> {
            if(event.isCancelled())
                return;
            PlayerManager.sendGlobalPacket(new PacketOutSpawnEntity(entity));
            entities.add(entity);
        });
    }

    public void removeEntity(Entity entity){
        Server.getEventManager().callEvent(new RemoveEntityEvent(entity), event -> {
            if(event.isCancelled())
                return;
            PlayerManager.sendGlobalPacket(new PacketOutRemoveEntity(entity));
            entities.remove(entity);
        });
    }

    public List<Entity> getEntities() {
        return entities;
    }
}