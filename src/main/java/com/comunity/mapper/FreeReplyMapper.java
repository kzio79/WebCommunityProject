package com.comunity.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.ReplyDTO;

@Mapper
public interface FreeReplyMapper {
	public void insertReplyFree(ReplyDTO reply);
	public List<ReplyDTO> selectReplyFree(int board_number);
	public void deleteReplyFree(ReplyDTO reply);
	public ReplyDTO deleteReplyCheckFree(ReplyDTO reply);
	public void deleteReplyAllFree(String board_number);
	
}
