package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reg_details")
public class RegistrationDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)// automatically create it for person_id
	@Column(name = "person_id")
	private Integer personID;
	@Column(name = "person_age")
	private Integer personAge;
	@Column(name = "contact")
	private Integer contact;
	@Column(name = "person_name")
	private String personName;
	@Column(name = "person_email")
	private String email;

	public RegistrationDetails() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationDetails(Integer personID, Integer personAge, Integer contact, String personName, String email) {
		super();
		this.personID = personID;
		this.personAge = personAge;
		this.contact = contact;
		this.personName = personName;
		this.email = email;
	}

	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

	public Integer getContact() {
		return contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegistrationDetails [personID=" + personID + ", personAge=" + personAge + ", contact=" + contact
				+ ", personName=" + personName + ", email=" + email + "]";
	}

}
