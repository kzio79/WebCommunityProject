package com.comunity.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDTO {
	
	private int qnum;  //QnA 게시판
	private int fnum;  //자유 게시판
	private int cnum;  //코드 공유 게시판
	private String writer;  
	private String title;
	private String content;
	private Timestamp regdate;
	private Timestamp newdate;
	private int hit;
	private int bindex;
	

	
}
