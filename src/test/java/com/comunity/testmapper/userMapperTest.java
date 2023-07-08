package com.comunity.testmapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comunity.domain.UserDTO;
import com.comunity.mapper.UserMapper;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootTest
public class userMapperTest {
	
	@Autowired
	UserMapper userMapper;
	
	
	@Test
	public void testMyBatis() {
		log.info("userMapper객체 : "+userMapper);
	}
	
	@Test
	public void deleteforReply() {
		String nickname = "test";
	}

	
	
}
