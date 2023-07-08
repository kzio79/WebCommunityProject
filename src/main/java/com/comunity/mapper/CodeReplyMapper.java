package com.comunity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.comunity.domain.ReplyDTO;

@Mapper
public interface CodeReplyMapper {
	public void insertReplyCode(ReplyDTO reply);
	public List<ReplyDTO> selectReplyCode(int board_number);
	public void deleteReplyCode(ReplyDTO reply);
	public ReplyDTO deleteReplyCheckCode(ReplyDTO reply);
	public void deleteReplyAllCode(String board_number);
}
