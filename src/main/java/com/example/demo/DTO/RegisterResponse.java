package com.example.demo.DTO;

public class RegisterResponse {
	
	
	 private String message;
	 private UserData user;
	 
	 public RegisterResponse() {
		 
	 }

	 public RegisterResponse(String message, UserData user) {
			super();
			this.message = message;
			this.user = user;
		 }
	 
	 public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	
	
	 @Override
		public String toString() {
			return "RegisterResponse [message=" + message + ", user=" + user + ", getMessage()=" + getMessage()
					+ ", getUser()=" + getUser() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
					+ ", toString()=" + super.toString() + "]";
		}
	 
	
	  
}
