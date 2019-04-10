package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.service.PageService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootJpaApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private PageService pageService;

	@Autowired
	private ObjectMapper objectMapper;

//	@Ignore
	@Test
	public void test1() {
		User user=new User();
 		user.setUsername("gegege");
 		user.setPassword("14444");
		
 		userService.saveUser(user);
//        System.out.println(userService.findOneUser(3).toString());
//		userService.updateUser(2, "小花");
//       System.out.println(userService.findByPassword("111111").toString());
	}
	@Ignore
	@Test
	public void testPage() {
		String map = "{\"page\" : 1,\"pageSize\" : 3, \"filter\":{ \"filters\":[{ \"field\" : \"username\", \"value\":\"ge\"}]}}";
		Map searchParameters = new HashMap();
		try {
			searchParameters = objectMapper.readValue(map, new TypeReference<Map>() {
			});
		} catch (JsonParseException e) {
//			log.error("JsonParseException{}:", e.getMessage());
		} catch (JsonMappingException e) {
//			log.error("JsonMappingException{}:", e.getMessage());
		} catch (IOException e) {
//			log.error("IOException{}:", e.getMessage());
		}

		Map mapDept = pageService.getPage(searchParameters);

		System.out.println(mapDept.get("total"));

		System.out.println(mapDept.get("users"));
	}
}
