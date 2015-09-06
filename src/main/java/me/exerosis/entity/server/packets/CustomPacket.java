package me.exerosis.entity.server.packets;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by The Exerosis on 8/5/2015.
 */
public class CustomPacket extends Packet {
    private Map<String, Object> data = new HashMap<>();
    private String name;

    public CustomPacket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setData(String key, Object object) {
        data.put(key, object);
    }

    public <T> T getData(String key, Class<T> clazz) {
        return (T) data.get(key);
    }

    public Map<String, Object> getAllData() {
        return data;
    }
}