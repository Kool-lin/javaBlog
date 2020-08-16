package com.blog.entity;

/**
 * 
 * 博主类
 *
 */
public class Blogger {
	private Integer id;							//主键
	private String userName;			//登录名
	private String password;			//密码
	private String nickName;			//昵称
	private String sign;						//个性签名
	private String proFile;					//个人简介
	private String imageName;		//头像地址

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSign() {
		return this.sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getProFile() {
		return this.proFile;
	}

	public void setProFile(String proFile) {
		this.proFile = proFile;
	}

	public String getImageName() {
		return this.imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
}
