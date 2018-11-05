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

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

public class PayLoadTests {

	@Test
	public void processPayLoad() throws JSONException, UnsupportedEncodingException {
		String json1 = "{\"type\":\"interactive_message\",\"actions\":[{\"name\":\"game\",\"type\":\"button\",\"value\":\"approve\"}],\"callback_id\":\"checkers\",\"team\":{\"id\":\"TDPDEFKJM\",\"domain\":\"interceptor-chatbot\"},\"channel\":{\"id\":\"DDR484ZDM\",\"name\":\"directmessage\"},\"user\":{\"id\":\"UDR3D3U3H\",\"name\":\"maxbot\"},\"action_ts\":\"1541408923.983337\",\"message_ts\":\"1541408921.000300\",\"attachment_id\":\"1\",\"token\":\"AQZiorCLLAaqTPbpFiA4IeV6\",\"is_app_unfurl\":false,\"response_url\":\"https://hooks.slack.com/actions/TDPDEFKJM/473135124390/fQLvNYhHaw9KJ5uVQIRxSRn7\",\"trigger_id\":\"471563947716.465456529633.89f3a001767f5b117db2df02b7cb39bf\"}";
		String json ="payload=%7B%22type%22%3A%22interactive_message%22%2C%22actions%22%3A%5B%7B%22name%22%3A%22game%22%2C%22type%22%3A%22button%22%2C%22value%22%3A%22defer%22%7D%5D%2C%22callback_id%22%3A%22checkers%22%2C%22team%22%3A%7B%22id%22%3A%22TDPDEFKJM%22%2C%22domain%22%3A%22interceptor-chatbot%22%7D%2C%22channel%22%3A%7B%22id%22%3A%22DDR484ZDM%22%2C%22name%22%3A%22directmessage%22%7D%2C%22user%22%3A%7B%22id%22%3A%22UDR3D3U3H%22%2C%22name%22%3A%22maxbot%22%7D%2C%22action_ts%22%3A%221541414329.042635%22%2C%22message_ts%22%3A%221541414326.000600%22%2C%22attachment_id%22%3A%221%22%2C%22token%22%3A%22AQZiorCLLAaqTPbpFiA4IeV6%22%2C%22is_app_unfurl%22%3Afalse%2C%22response_url%22%3A%22https%3A%5C%2F%5C%2Fhooks.slack.com%5C%2Factions%5C%2FTDPDEFKJM%5C%2F473193559222%5C%2FvNkgE8Y6pw40ZqtlRU9HJBWT%22%2C%22trigger_id%22%3A%22471993518565.465456529633.31ae4e5b415e3e6eb626a9622732938f%22%7D";
		String decoded =  java.net.URLDecoder.decode(json, "UTF-8");
		String response = getResponse(json);
		assertEquals("User request sent [username -> maxbot, action -> defer] - thank you.", response);
	}

	private String getResponse(String json) throws JSONException, UnsupportedEncodingException {
		String decoded =  java.net.URLDecoder.decode(json, "UTF-8");
		decoded = decoded.replace("payload=", "");
		JSONObject jObject = new JSONObject(decoded);
		String callback_id = jObject.getString("callback_id");
		String name = "";
		String value = "";
		JSONArray actions = jObject.getJSONArray("actions");
		for (int i = 0; i < actions.length(); ++i) {
			JSONObject rec = actions.getJSONObject(i);
			name = rec.getString("name");
			value = rec.getString("value");
			String type = rec.getString("type");
		}
		JSONObject user = jObject.getJSONObject("user");
		String username = user.getString("name");
		assertEquals("checkers", callback_id);
		assertEquals("game", name);
		assertEquals("defer", value);
		assertEquals("maxbot", username);
		String response = "User request sent " ;
		response =  response + "[username -> " + username + ",";
		response =  response + " action -> " + value + "]";
		response =  response + " - thank you.";
		return response;
	}

}
