package com.bits.subscriber;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class MovieDetails {

	public static String getCast(String title, String year) {
		String cast = "";
		try {
			HttpResponse<String> response = Unirest
					.post("http://www.omdbapi.com/?apikey=b252c90e&t=" + title + "&y=" + year).asString();
			System.out.println(response.getBody());
			String delims = "[:]";
			String[] tokens = response.getBody().split(delims);

			for (int i = 0; i <= tokens.length - 1; i++) {

				if (tokens[i].contains("Actors")) {
					cast = tokens[i + 1];
				}
			}

			System.out.println(cast);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cast;
	}

	public static String getDir(String title, String year) {
		// TODO Auto-generated method stub
		String dir = "";
		try {
			HttpResponse<String> response = Unirest
					.post("http://www.omdbapi.com/?apikey=b252c90e&t=" + title + "&y=" + year).asString();
			System.out.println(response.getBody());
			String delims = "[:]";
			String[] tokens = response.getBody().split(delims);

			for (int i = 0; i <= tokens.length - 1; i++) {
				if (tokens[i].contains("Director")) {
					dir = tokens[i + 1];
				}

			}

			System.out.println(dir);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return dir;
	}

}
