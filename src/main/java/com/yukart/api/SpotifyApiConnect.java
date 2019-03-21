package com.yukart.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SpotifyApiConnect {

	private static final String SEARCH_URL = "https://api.spotify.com/v1/XX/ID" ;

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

	public String searchArtistByID(String ID) {

		String requestUrl = SEARCH_URL.replaceAll("XX", "artists")
		.replaceAll("ID", ID);

		return sendGetRequest(requestUrl);

	}
	public String searchTopTracksArtistByID(String ID) {

		String requestUrl = SEARCH_URL.replaceAll("XX", "artists")
		.replaceAll("ID", ID);

		return sendGetRequest(requestUrl+"/top-tracks");

	}
	public String searchAlbumArtistByID(String ID) {

		String requestUrl = SEARCH_URL.replaceAll("XX", "artists")
		.replaceAll("ID", ID);

		return sendGetRequest(requestUrl+"/albums");
	}
	public String searchAudioAnalysisByID(String ID) {

		String requestUrl = SEARCH_URL.replaceAll("XX", "audio-analysis")
		.replaceAll("ID", ID);

		return sendGetRequest(requestUrl);
	}

	public JSONObject parseToJson(String request) throws ParseException {
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(request);

		return json;
	}
}
