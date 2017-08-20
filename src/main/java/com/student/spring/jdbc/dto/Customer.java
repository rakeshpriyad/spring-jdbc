package com.student.spring.jdbc.dto;
public class Customer {
	private Long custId;
	private String name;
	private Long age;

	public Customer(){
		
	}
	public Customer(Long custId, String name, Long age) {
		super();
		this.custId = custId;
		this.name = name;
		this.age = age;
	}
	public Customer(String name, Long age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", age=" + age + "]";
	}

}