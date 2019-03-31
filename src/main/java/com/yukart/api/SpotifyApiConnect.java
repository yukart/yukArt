package com.yukart.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SpotifyApiConnect {
	
	static String URL_ArtistID;


	public String sendGetRequest(String requestUrl) {

		StringBuffer response = new StringBuffer();

		URL url;
		try {
			url = new URL(requestUrl);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "*/*");
			connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			String line;

			while ((line = buffer.readLine()) != null) {
				response.append(line);
			}
			buffer.close();
			connection.disconnect();
		} catch (Exception e) {
		}

		return response.toString();

	}

	public void APIArtistURL(String firstName, String lastName) {
		String URL = "https://api.spotify.com/v1/search?"
					+firstName
					+"%20"+lastName
					+"&type=artist";
		URL_ArtistID = sendGetRequest(URL); 
	}
	public String searchTopTracksArtistByID(String ID) {

		return sendGetRequest(URL_ArtistID+"/top-tracks");

	}
	public String searchAlbumArtistByID(String ID) {

		return sendGetRequest(URL_ArtistID+"/albums");
	}
	public String searchAudioAnalysisByID(String ID) {

		String requestUrl = URL_ArtistID.replaceAll("XX", "audio-analysis")
		.replaceAll("ID", ID);

		return sendGetRequest(requestUrl);
	}
}
