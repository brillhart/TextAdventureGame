package com.adventuregame.adventuregame.Wanderer;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.sql.rowset.JdbcRowSet;

public class JDBCWandererDAO implements WandererDAO{

    private JdbcTemplate jdbcTemplate;
    public JDBCWandererDAO(DataSource dataSource) {this.jdbcTemplate = new JdbcTemplate();}

    public void assignNewPlayer(String playerName) {
        //inserts new player row into database (player table)

    }

}
