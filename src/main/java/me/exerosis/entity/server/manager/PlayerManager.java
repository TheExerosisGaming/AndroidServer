package me.exerosis.entity.server.manager;

import me.exerosis.entity.server.Server;
import me.exerosis.entity.server.connection.PlayerConnection;
import me.exerosis.entity.server.packets.Packet;

import java.util.*;

/**
 * Created by The Exerosis on 8/7/2015.
 */
public class PlayerManager {
    private Map<UUID, String> banPlayers = new HashMap<>();
    private Set<PlayerConnection> players = new HashSet<>();

    public PlayerManager() {}

    public static void sendGlobalPacket(Packet packet){
        for(PlayerConnection player : Server.getPlayerManager().getPlayers())
            player.sendPacket(packet);
    }

    public void banPlayer(PlayerConnection player, String reason){
        banPlayers.put(player.getUUID(), reason);
    }

    public String getReason(UUID player){
        return banPlayers.get(player);
    }

    public boolean isBan(UUID player){
        return banPlayers.containsKey(player);
    }

    public Set<PlayerConnection> getPlayers() {
        return players;
    }

    public Map<UUID, String> getBanPlayers() {
        return banPlayers;
    }
}