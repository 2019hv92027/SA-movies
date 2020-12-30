package com.bits.subscriber;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class Reciever {
    private final static String QUEUE_NAME = "movie";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            Object obj = null;
            String year="";
            String movie="";
      
            try {
				
            	obj = new JSONParser().parse(message);
				JSONObject ob = (JSONObject) obj;
				
				System.out.println(ob.toString());
				//System.out.println(ob.e);
				
				Iterator itr = ob.entrySet().iterator();
				while(itr.hasNext()) {
					
					//System.out.println(itr.next());
					Map.Entry me = (Map.Entry) itr.next();
					
					if (me.getKey().equals("year")) {
						
						year = me.getValue().toString();
						System.out.println(year);
					}			
					
					if (me.getKey().equals("title")) {
						
						movie = me.getValue().toString();
						System.out.println(movie);
					}	
				}
				
				
				//for(Map.Entry<String,String> me = (Entry<String, String>) ob.entrySet()) {
					
				//String movie = me.
				//}
				
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            
            		
            /*String delims = "[:]";
			String[] tokens = message.split(delims);
			String title = tokens[0];
			String year = tokens[1];
			
			System.out.println(title);
			System.out.println(year);*/
			
            String cast = MovieDetails.getCast(movie, year);
            String dir = MovieDetails.getDir(movie, year);
            InsertDetails indata = new InsertDetails();
            indata.connect();
            indata.createItem(message, cast, dir);
            System.out.println("Actors from the movie : " + movie + " are " + cast);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {});
    }
}