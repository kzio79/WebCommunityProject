package com.comunity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.ReplyDTO;

@Mapper
public interface QnaReplyMapper {
	public void insertReplyQna(ReplyDTO reply);
	public List<ReplyDTO> selectReplyQna(int board_number);
	public void deleteReplyQna(ReplyDTO reply);
	public ReplyDTO deleteReplyCheckQna(ReplyDTO reply);
	public void deleteReplyAllQna(String board_number);
}
