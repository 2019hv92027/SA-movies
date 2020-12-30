package com.bits.getmoviedetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
@EnableAsync
public class scheduleJob {
	
	//@Autowired
	private GetDetails gd;
	
	@Scheduled(cron="0/10 * * * * ?")
	public void getDetails() {
		
		System.out.println("Job Started");
		gd = new GetDetails();
		gd.getDetails();
		
	}

}
