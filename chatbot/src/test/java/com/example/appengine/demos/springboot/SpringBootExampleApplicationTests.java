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

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootExampleApplicationTests {

	@Test
	public void contextLoads() throws UnsupportedEncodingException {
		String json = "{\"username\":\"Credit Department\",\"icon_emoji\":\":credit_card:\",\"text\":\"Request 123 waiting for your approval?\",\"attachments\":[{\"text\":\"What would to like to do\",\"fallback\":\"You are unable to choose a game\",\"callback_id\":\"wopr_game\",\"color\":\"#3AA3E3\",\"attachment_type\":\"default\",\"actions\":[{\"name\":\"game\",\"text\":\"Approve\",\"type\":\"button\",\"value\":\"approve\"},{\"name\":\"game\",\"text\":\"Defer\",\"type\":\"button\",\"value\":\"defer\"},{\"name\":\"game\",\"text\":\"Reject request\",\"style\":\"danger\",\"type\":\"button\",\"value\":\"reject\",\"confirm\":{\"title\":\"Are you sure?\",\"text\":\"Please confirm that this request be rejected.?\",\"ok_text\":\"Yes\",\"dismiss_text\":\"No\"}}]}]}";
		String jsonified = encodeValue(json);
		jsonified = encodeValue(json);
	}

	private String encodeValue(String value) throws UnsupportedEncodingException {
	  return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
  }

}
