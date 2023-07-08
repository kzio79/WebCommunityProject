package com.comunity.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplyDTO {
	private int reply_number;
	private int board_number;
	private String replytext;
	private String replyer;
	private Date create_date;
	
}
