package me.exerosis.entity;

import me.exerosis.reflection.pool.InstancePool;

import java.io.Serializable;

/**
 * Created by The Exerosis on 8/2/2015.
 */
public class Entity implements Serializable {
    private static int globalID;
    private final int id;
    private final int x;
    private final int y;
    private InstancePool instancePool;

    public Entity(int x, int y) {
        this.id = globalID++;
        this.x = x;
        this.y = y;
        instancePool = new InstancePool();
        instancePool.add(this);
    }

    public void addProperty(Property property){
        instancePool.add(property);
    }

    public void finalizeEntity(){
        instancePool.setAllFields();
        for (Object object : instancePool)
            if (object instanceof Property)
                ((Property) object).onEnable();
    }

    public void nullifyEntity(){
        for (Object object : instancePool)
            if (object instanceof Property)
                ((Property) object).onDisable();
        instancePool = null;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public InstancePool getInstancePool() {
        return instancePool;
    }
}