package com.mvn.test.vo;

import lombok.Data;

@Data
//getter setter toString 자동으로 만들어줌
public class UserInfoVO {
	private Integer uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private String credat;
	private String cretim;
	private String moddat;
	private String modtim;
	private String active;
	
	
}
