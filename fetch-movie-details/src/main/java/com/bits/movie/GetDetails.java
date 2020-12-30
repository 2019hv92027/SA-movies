package com.bits.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.sql.ResultSet;

public class GetDetails {

	private final static String url = "jdbc:postgresql://localhost/postgres";
	private final static String user = "postgres";
	private final static String password = "admin";

	//public static void main(String[] argv) throws Exception {
	public static void getDetails() 
	{		
	Connection conn = null;
    try {
        conn = DriverManager.getConnection(url, user, password);
		String sql = "SELECT * FROM public.\"IMDB\"";
		Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql); 

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String cast = resultSet.getString("cast");
                String director = resultSet.getString("director");
                
               System.out.println(title +" " + cast + " " + " " + director) ;
            }
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
     

}
}
