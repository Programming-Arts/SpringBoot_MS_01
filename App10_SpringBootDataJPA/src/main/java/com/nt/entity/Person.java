package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Component //this annotation is used to tell spring container to create object

@Entity
@Table(name = "person_details")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "person_id")
	private int personId;
	@Column(name = "person_name")
	private String personName;
	@Column(name = "person_age")
	private int age;
	@Column(name = "person_gender")
	private String gender;
	@Column(name = "addr")
	private String address;
	@Column(name = "mob_no")
	private long contact;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", contact=" + contact + "]";
	}

}
