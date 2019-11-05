package com.iscc.store.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private String uid;
	private String username;
	private String password;
	private String name;
	private String gender;
	private Date birthday;
	private String phone;
	private String email;
	private String address;
	private String code;
	private int state;

	public User() {

	}

	/**
	 * 有参构造:uid,username,password,email,code<br>
	 * 用于用户注册时使用
	 */
	public User(String uid, String username, String password, String email, String code) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.email = email;
		this.code = code;
	}

	/**
	 * 有参构造,用户用户完善个人信息
	 * 
	 * @param name     :姓名
	 * @param gender   :性别
	 * @param birthday :生日
	 * @param phone    :电话
	 * @param address  :住址
	 * @param code     :激活码
	 */
	public User(String name, String gender, Date birthday, String phone, String email, String address, String code) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.code = code;
	}

	/**
	 * 完整的用户
	 */
	public User(String uid, String username, String password, String name, String gender, Date birthday, String phone,
			String email, String address, String code, int state) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.code = code;
		this.state = state;
	}

	public User(String uid) {
		this.uid = uid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

}
