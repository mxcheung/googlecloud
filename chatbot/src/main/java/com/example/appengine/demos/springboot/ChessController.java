/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.demos.springboot;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

@RestController
public class ChessController {
	@PostMapping(path = "/chess", produces = "application/json")
	public String hello() {
		String json = "{\"username\":\"Credit Department\",\"icon_emoji\":\":credit_card:\",\"text\":\"Request 123 waiting for your approval?\",\"attachments\":[{\"text\":\"What would to like to do\",\"fallback\":\"You are unable to choose a game\",\"callback_id\":\"checkers\",\"color\":\"#3AA3E3\",\"attachment_type\":\"default\",\"actions\":[{\"name\":\"game\",\"text\":\"Approve\",\"type\":\"button\",\"value\":\"approve\"},{\"name\":\"game\",\"text\":\"Defer\",\"type\":\"button\",\"value\":\"defer\"},{\"name\":\"game\",\"text\":\"Reject request\",\"style\":\"danger\",\"type\":\"button\",\"value\":\"reject\",\"confirm\":{\"title\":\"Are you sure?\",\"text\":\"Please confirm that this request be rejected.?\",\"ok_text\":\"Yes\",\"dismiss_text\":\"No\"}}]}]}";

		// Gson gson = new Gson();
		// String jsonified = gson.toJson(json);
		return json;
	}

	@PostMapping("/wopr_game")
	public String wopr_game() {
		String json = "thank";
		return json;
	}

	@PostMapping("/action")
	public String action(@RequestBody String body) {
		String response = getResponse(body);
		return response;
	}

	private String getResponse(String json) {
		String decoded = json;
		try {
			decoded =  java.net.URLDecoder.decode(json, "UTF-8");
			decoded = decoded.replace("payload=", "");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String response = "User request sent ";
		JSONObject jObject = null;
		String name = "unknown_Name";
		String value = "unknown_Value";
		String username = "unknown_username";
		String callback_id = "unknown_callback_id";
			try {
				jObject = new JSONObject(decoded);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				callback_id = jObject.getString("callback_id");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONArray actions;
			try {
				actions = jObject.getJSONArray("actions");
				for (int i = 0; i < actions.length(); ++i) {
					JSONObject rec = actions.getJSONObject(i);
					name = rec.getString("name");
					value = rec.getString("value");
					String type = rec.getString("type");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JSONObject user;
			try {
				user = jObject.getJSONObject("user");
				username = user.getString("name");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response = response + "[username -> " + username + ",";
		response = response + " action -> " + value + "]";
		response = response + " - thank you.";
		return response;
	}

}
