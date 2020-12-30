package com.bits.getmoviedetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class GetDetails {

	private final static String url = "jdbc:mysql://localhost:3306/movies";
	private final static String user = "root";
	private final static String password = "sharan316316";

	//public static void main(String[] argv) throws Exception {
	public void getDetails() 
	{
		System.out.println("Cron is running");
	Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM movies.movies_table";
		Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql); 

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String cast = resultSet.getString("actornames");
                String director = resultSet.getString("director");
                
               System.out.println(title +" " + cast + " " + " " + director) ;
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     

}
}
