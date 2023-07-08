package com.comunity.service;

import java.util.Date;
import java.util.List;

import com.comunity.domain.ReplyDTO;

public interface ReplyService {
	//코드게시판 Reply
	public void insertReplyCode(ReplyDTO replyer);
	public List<ReplyDTO> selectReplyCode(int board_number);
	public void deleteReplyCode(ReplyDTO reply);
	public ReplyDTO ReplyAndUserCheckCode(ReplyDTO reply);
	public void deleteReplyAllCode(String board_number);
	
	
	//자유게시판 Reply
	public void insertReplyFree(ReplyDTO replyer);
	public List<ReplyDTO> selectReplyFree(int board_number);
	public void deleteReplyFree(ReplyDTO reply);
	public ReplyDTO ReplyAndUserCheckFree(ReplyDTO reply);
	public void deleteReplyAllFree(String board_number);
	
	
	//Qna게시판 Reply
	public void insertReplyQna(ReplyDTO replyer);
	public List<ReplyDTO> selectReplyQna(int board_number);
	public void deleteReplyQna(ReplyDTO reply);
	public ReplyDTO ReplyAndUserCheckQna(ReplyDTO reply);
	public void deleteReplyAllQna(String board_number);
}
