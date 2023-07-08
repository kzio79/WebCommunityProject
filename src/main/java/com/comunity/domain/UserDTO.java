package com.comunity.domain;

import java.sql.Timestamp;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
	
	private int unum;
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String email;
	private String addr1;
	private String address;
	private String address2;
	private String gender;
	private Timestamp regdate;
	private String adminid;

}
