package com.comunity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.comunity.domain.UserDTO;
import com.comunity.mapper.UserMapper;

@Service("service")
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper usermapper;
	
// 회원가입	
	
	public int join(UserDTO dto) {
		
		int result = 0;		
		result = usermapper.join(dto);		
		return result;
	}

// id 중복 검사	
	
	public int idCheck(String id) {
		
		int result = 0;		
		result = usermapper.idCheck(id);		
		return result;
	}
	
//	닉네임 중복 검사
	@Override
	public int nicknameCheck(String nickname) {
		int result = usermapper.nicknameCheck(nickname);			
		return result;
	}
	
// 로그인
	
	public UserDTO login(UserDTO dto) {
		
		UserDTO dto2 = usermapper.login(dto);		
		return dto2;
	}
	
// 회원 정보 수정
	
	public int modify(UserDTO dto) {
		
		int result = 0;		
		result = usermapper.modify(dto);		
		return result;
	}

// 회원 정보 조회	
	
	public UserDTO info(String id) {
		
		UserDTO dto = null;		
		dto = usermapper.info(id);		
		return dto;
	}

//비밀번호 중복 체크
	@Override
	public int pwCheck(UserDTO dto) {
		int result = usermapper.pwCheck(dto);
		return result;
	}

// 회원 탈퇴 	
	public int delete(UserDTO dto) {
		int result = usermapper.delete(dto);
		return result;
	}	
	
//	회원검색 : ID
	@Override
	public UserDTO searchId(String name) {
		UserDTO dto =  usermapper.searchId(name);
		return dto;		
	}
//	회원검색 : ID를 찾기위한 중복문 검색
	@Override
	public UserDTO selectId(String name) {
		UserDTO dto = usermapper.selectId(name);
		return dto;
	}
	
//	회원검색 : pw
	@Override
	public UserDTO searchPw(UserDTO dto) {
		 return usermapper.searchPw(dto);
		
	}
	
//	회원검색 : pw를 찾기위한 중복문 검색
	@Override
	public UserDTO selectPw(UserDTO dto) {
		return usermapper.selectPw(dto);
		
	}
	
	@Override 	//reply 삭제시 해당 아이디인지 체크
	public Date ReplyCheck(String nickname) {
		Date date = usermapper.deleteforReply(nickname);
		return date;
	}

}
