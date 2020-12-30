package com.bits.subscriber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

public class InsertDetails {

private final String url = "jdbc:mysql://localhost:3306/movies";
private final String user = "root";
private final String password = "sharan316316";

public Connection connect() {
    Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to the MySQL server successfully.");

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return conn;
}

public void createItem(String title, String cast, String dir) {
    try {
        Statement stmnt = null;
        stmnt = connect().createStatement();
        String sql = "INSERT INTO movies.movies_table( title, actornames, director) VALUES " + "('" + title + "', '" + cast + "', '" + dir + "')";
        
        System.out.println(sql);
        stmnt.executeUpdate(sql);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

	}
}

