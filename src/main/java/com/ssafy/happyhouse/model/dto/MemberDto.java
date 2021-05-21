package com.ssafy.happyhouse.model.dto;

public class MemberDto {

	String id;
	String pw;
	String name;
	String address_sido;
	String address_gugun;
	String address_dong;
	String phone;
	String email;
	String interest_sido;
	String interest_gugun;
	String interest_dong;


	public MemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MemberDto(String id, String pw, String name, String address_sido, String address_gugun, String address_dong,
			String phone, String email, String interest_sido, String interest_gugun, String interest_dong) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.address_sido = address_sido;
		this.address_gugun = address_gugun;
		this.address_dong = address_dong;
		this.phone = phone;
		this.email = email;
		this.interest_sido = interest_sido;
		this.interest_gugun = interest_gugun;
		this.interest_dong = interest_dong;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress_sido() {
		return address_sido;
	}


	public void setAddress_sido(String address_sido) {
		this.address_sido = address_sido;
	}


	public String getAddress_gugun() {
		return address_gugun;
	}


	public void setAddress_gugun(String address_gugun) {
		this.address_gugun = address_gugun;
	}


	public String getAddress_dong() {
		return address_dong;
	}


	public void setAddress_dong(String address_dong) {
		this.address_dong = address_dong;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getInterest_sido() {
		return interest_sido;
	}


	public void setInterest_sido(String interest_sido) {
		this.interest_sido = interest_sido;
	}


	public String getInterest_gugun() {
		return interest_gugun;
	}


	public void setInterest_gugun(String interest_gugun) {
		this.interest_gugun = interest_gugun;
	}


	public String getInterest_dong() {
		return interest_dong;
	}


	public void setInterest_dong(String interest_dong) {
		this.interest_dong = interest_dong;
	}

	
	
	
	
	
	
	
	
}
