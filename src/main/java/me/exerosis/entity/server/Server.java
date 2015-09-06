package me.exerosis.entity.server;

import me.exerosis.entity.server.manager.ConnectionManager;
import me.exerosis.entity.server.connection.PlayerConnection;
import me.exerosis.entity.server.manager.PlayerManager;
import me.exerosis.reflection.event.EventManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Exerosis on 8/4/2015.
 */
public class Server {
    private static Server instance;
    private static Map<Integer, PlayerConnection> players = new HashMap<>();
    private static EventManager eventManager = new EventManager();
    private static ConnectionManager connectionManager = new ConnectionManager();
    private static PlayerManager playerManager = new PlayerManager();
    private static boolean online;

    private Server() {
        eventManager = new EventManager();
        eventManager.registerListener(this);
        connectionManager.start();
    }

    public void shutdown() {
        shutdown(false);
    }

    public void shutdown(boolean force) {
        shutdown(force, "The sever is stopping!");
    }

    public void shutdown(boolean force, String reason) {
        online = false;
        if(!force)
            for (PlayerConnection player : playerManager.getPlayers())
                player.kick(reason, false);
        connectionManager.close();
    }

    public static boolean isOnline() {
        return online;
    }

    public static void setOnline(boolean online) {
        Server.online = online;
    }

    public static EventManager getEventManager() {
        return eventManager;
    }

    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public static Map<Integer, PlayerConnection> getPlayers() {
        return players;
    }

    public static Server getInstance() {
        if(instance == null)
            instance = new Server();
        return instance;
    }
}