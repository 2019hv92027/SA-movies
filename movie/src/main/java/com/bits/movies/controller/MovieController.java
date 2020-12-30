package com.bits.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bits.movies.postMsg.Producer;

@RestController
public class MovieController {
	@Autowired
	Producer producer;
	
	@RequestMapping(value="/MovieMQ", method = RequestMethod.POST,consumes= {MediaType.ALL_VALUE})
	public String getMovie(@RequestBody String iput) {
		producer.produceMsg(iput);
		return "Successfully Posted the Movie Information";
		
	}

}

