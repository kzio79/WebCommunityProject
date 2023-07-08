package com.comunity.service;

import java.util.Date;

import com.comunity.domain.UserDTO;

public interface UserService {

	public int join(UserDTO dto);
	public int idCheck(String id);
	public int nicknameCheck(String nickname);
	public UserDTO login(UserDTO dto);
	public int modify(UserDTO dto);
	public UserDTO info(String id);
	public int delete(UserDTO dto);
	public int pwCheck(UserDTO dto);
	public UserDTO searchId(String name);
	public UserDTO selectId(String name);  //id찾기를 위해서 이름으로 중복값 찾기 위한 메서드
	public UserDTO searchPw(UserDTO dto);  //pw찾기
	public UserDTO selectPw(UserDTO dto);  //pw찾기를 위해서 id와 email로 중복값 찾기 위한 구문
	public Date ReplyCheck(String nickname);   	//reply 삭제시 해당 아이디인지 체크
	
}
