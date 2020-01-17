package com.adventuregame.adventuregame.Wanderer;

import com.adventuregame.adventuregame.AdventureGameCli;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class JDBCWandererDAO implements WandererDAO{

    private JdbcTemplate jdbcTemplate;
    private PrintWriter out;
    private Scanner in;

    public JDBCWandererDAO(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate(dataSource);}


    @Override
    public Wanderer assignNewPlayer(String playerName) {        //TODO check database for duplicate playernames before storing new player in database
        Wanderer newWanderer = new Wanderer(playerName);        //uses the default constructor with initial stats, user name
        LocalDateTime now = LocalDateTime.now();
        String sqlInsertNewPlayer = "INSERT into players(player_name, health, damage, experience, level, player_location, save_date, play_time, score) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        newWanderer.setName(playerName);
        jdbcTemplate.update(sqlInsertNewPlayer, newWanderer.getName(), newWanderer.getHealth(), newWanderer.getDamage(), newWanderer.getExperience(), newWanderer.getLevel(), newWanderer.getLocation(), newWanderer.getSaveDate(), newWanderer.getPlayTime(), newWanderer.getScore());
        return newWanderer;
    }

    @Override
    public Wanderer getPlayerFromDatabase(String playerName) {
        String sqlPlayerSearch = "Select * from players where player_name = ?";
        SqlRowSet resultPlayer = jdbcTemplate.queryForRowSet(sqlPlayerSearch, playerName);
        Wanderer thePlayer = new Wanderer();
        if(resultPlayer.next()) {
            thePlayer = mapRowToWanderer(resultPlayer);
            System.out.println("Welcome back, " + thePlayer.getName() + "!");
            return thePlayer;
        } else {
            System.out.println("That player was not found! Would you like to create a new player? Type \"Y\" or \"N\"");
            String response = getPlayerInput();
            if (response.equals("Y")) {
                AdventureGameCli.displayNewGameMenu();
            } else if (response.equals("N")) {
                AdventureGameCli.runGame();
            }
        }
        return thePlayer;
    }

    public Wanderer mapRowToWanderer(SqlRowSet results) {
        Wanderer thePlayer = new Wanderer();
        thePlayer.setName(results.getString("player_name"));
        thePlayer.setDamage(results.getInt("damage"));
        thePlayer.setHealth(results.getInt("health"));
        thePlayer.setExperience(results.getInt("experience"));
        thePlayer.setLevel(results.getInt("level"));
        thePlayer.setLocation(results.getInt("player_location"));
        thePlayer.setPlayTime(results.getString("play_time"));
        thePlayer.setSaveDate(results.getDate("save_date"));
        thePlayer.setScore(results.getInt("score"));
        return thePlayer;
    }

    public String getPlayerInput() {
        String playerInput = in.nextLine();
        return playerInput;
    }


}
