package com.adventuregame.adventuregame;

import com.adventuregame.adventuregame.Wanderer.JDBCWandererDAO;
import com.adventuregame.adventuregame.Wanderer.Wanderer;
import com.adventuregame.adventuregame.Wanderer.WandererDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDateTime;

public class NewGame {

    Menu gameMenu = new Menu(System.in, System.out);
    JdbcTemplate jdbcTemplate = new JdbcTemplate();



//    public void displayNewGameMenu() {
//        System.out.println("What is your name, wanderer?");
//        String playerName = gameMenu.getPlayerNameFromInput();
//        Wanderer newPlayer = wandererDAO.assignNewPlayer(playerName);    //call this method to store new player in database
//        System.out.println("Welcome, " + newPlayer.getName());
//    }


}
