package com.example.java.learn.sedse;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class User implements Serializable {

	public static final String CLASS_INFO = User.class.getName();

	/**
	 * 
	 */
	private static final long serialVersionUID = 3767918320131668640L;

	private Long id;
	private String name;
	private String password;
	private String[] array;
	private List<String> list;
	private transient String transientStr = "this field should not be serialized";

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", array=" + Arrays.toString(array)
				+ ", list=" + list + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTransientStr() {
		return transientStr;
	}

	public void setTransientStr(String transientStr) {
		this.transientStr = transientStr;
	}

}
