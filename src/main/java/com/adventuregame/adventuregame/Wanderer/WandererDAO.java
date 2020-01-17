package com.adventuregame.adventuregame.Wanderer;

public interface WandererDAO {

    public Wanderer assignNewPlayer(String playerName);
    public Wanderer getPlayerFromDatabase(String playerName);
}
