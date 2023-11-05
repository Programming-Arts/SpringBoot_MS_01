package com.sit;

public class PersonDetails {
	private Integer personID;
	private Integer personAge;
	private Integer contact;
	private String personName;
	private String email;

	public PersonDetails() {
		// TODO Auto-generated constructor stub
	}
	
	

	public PersonDetails(Integer personID, Integer personAge, Integer contact, String personName, String email) {
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
		return "PersonDetails [personID=" + personID + ", personAge=" + personAge + ", contact=" + contact
				+ ", personName=" + personName + ", email=" + email + "]";
	}

}
