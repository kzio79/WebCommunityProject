package com.comunity.mapper;

import java.util.Date;
import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.UserDTO;


@Mapper
public interface UserMapper {

	public int join(UserDTO dto);
	public int idCheck(String id);
	public int nicknameCheck(String nickname);
	public UserDTO login(UserDTO dto);
	public int modify(UserDTO dto);
	public UserDTO info(String id);
	public int delete(UserDTO dto);
	public int pwCheck(UserDTO dto);
	public UserDTO searchId(String name);	//id찾기
	public UserDTO selectId(String name);  //id찾기를 위해서 이름으로 중복값 찾기 위한 구문
	public UserDTO searchPw(UserDTO dto);  //pw찾기
	public UserDTO selectPw(UserDTO dto);  //pw찾기를 위해서 id와 email로 중복값 찾기 위한 구문
	public Date deleteforReply(String nickname);
}
