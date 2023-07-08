package com.comunity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comunity.domain.ReplyDTO;
import com.comunity.mapper.CodeReplyMapper;
import com.comunity.mapper.FreeReplyMapper;
import com.comunity.mapper.QnaReplyMapper;
import com.comunity.mapper.UserMapper;


@Service("Replyservice")
public class ReplyServiceImpl implements ReplyService {
		
		@Autowired
		CodeReplyMapper codereplMapper;
		
		
		@Autowired
		FreeReplyMapper freereplMapper;
		
		
		@Autowired
		QnaReplyMapper qnareplMapper;
		
		
		
	//코드 reply
		@Override
		public void insertReplyCode(ReplyDTO reply) {
			codereplMapper.insertReplyCode(reply);
		}
		
		@Override
		public List<ReplyDTO> selectReplyCode(int board_number) {
			List<ReplyDTO> replylist = codereplMapper.selectReplyCode(board_number);
			return replylist; 
		}
		
		
		@Override
		public void deleteReplyCode(ReplyDTO reply) {
			codereplMapper.deleteReplyCode(reply);
		}
		
		@Override
		public ReplyDTO ReplyAndUserCheckCode(ReplyDTO reply) {
			return codereplMapper.deleteReplyCheckCode(reply);
		}
		
		@Override
		public void deleteReplyAllCode(String board_number) {
			codereplMapper.deleteReplyAllCode(board_number);
		
		}
		
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//자유게시판 reply
		@Override
		public void insertReplyFree(ReplyDTO replyer) {
			freereplMapper.insertReplyFree(replyer);
		}
		
		
		@Override
		public List<ReplyDTO> selectReplyFree(int board_number) {
			List<ReplyDTO> replylist = freereplMapper.selectReplyFree(board_number);
			return replylist;
		}
		
		@Override
		public void deleteReplyFree(ReplyDTO reply) {
			freereplMapper.deleteReplyFree(reply);
		}
		
		
		@Override
		public ReplyDTO ReplyAndUserCheckFree(ReplyDTO reply) {
			return freereplMapper.deleteReplyCheckFree(reply);
		}
		
		
		@Override
		public void deleteReplyAllFree(String board_number) {
			freereplMapper.deleteReplyAllFree(board_number);
		
		}
		
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		//Qna게시판 reply
		
		
		@Override
		public void insertReplyQna(ReplyDTO replyer) {
			qnareplMapper.insertReplyQna(replyer);
		}
		
		
		
		@Override
		public List<ReplyDTO> selectReplyQna(int board_number) {
			List<ReplyDTO> replylist = qnareplMapper.selectReplyQna(board_number);
			return replylist;
		}
		
		
		
		@Override
		public void deleteReplyQna(ReplyDTO reply) {
			qnareplMapper.deleteReplyQna(reply);
		}
		
		
		@Override
		public ReplyDTO ReplyAndUserCheckQna(ReplyDTO reply) {
			return qnareplMapper.deleteReplyCheckQna(reply);
		}
		
		@Override
		public void deleteReplyAllQna(String board_number) {
			qnareplMapper.deleteReplyAllQna(board_number);
		
		}
		
}
