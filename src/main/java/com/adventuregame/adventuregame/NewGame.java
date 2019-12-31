package com.adventuregame.adventuregame;

import com.adventuregame.adventuregame.Wanderer.Wanderer;
import com.adventuregame.adventuregame.Wanderer.WandererDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class NewGame {

    Menu gameMenu = new Menu(System.in, System.out);
    JdbcTemplate jdbcTemplate = new JdbcTemplate();


    public void displayNewGameMenu() {
        System.out.println("What is your name, wanderer?");
        String playerName = gameMenu.getPlayerNameFromInput();

    }

    public void assignNewPlayer(String playerName) {
        LocalDateTime now = LocalDateTime.now();
        String sqlInsertNewPlayer = "INSERT into players(name, health, location, save_date, play_time, score) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsertNewPlayer, playerName, 100, 1, now, "00:00:00", 0);
    }
}
