package com.example.demo.DTO;

public class UserData {

	private Integer id;
	private String userName;
	private String emai;
	
	public UserData() {	
	}
	
	public UserData(Integer id, String userName, String emai) {
		super();
		this.id = id;
		this.userName = userName;
		this.emai = emai;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmai() {
		return emai;
	}
	public void setEmai(String emai) {
		this.emai = emai;
	}
	
	
	
	
	
}
