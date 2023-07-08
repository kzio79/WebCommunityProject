package com.comunity.testmapper;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.comunity.domain.ReplyDTO;
import com.comunity.mapper.FreeReplyMapper;
import com.comunity.mapper.UserMapper;

@SpringBootTest
public class ReplyMapperTest {
	@Autowired
	FreeReplyMapper freeReplyMapper;
	
	@Autowired
	UserMapper userMapper;
	@Test
	public void DeleteReplyTest() {
		String nickname = "test";
		
	}
}
