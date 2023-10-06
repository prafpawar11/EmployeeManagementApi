package com.restapi.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	private int id;

	private String Customer_name;

	private String customer_gender;

	private String customer_state;

	private String customer_currentAddress;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
	}

	public String getCustomer_state() {
		return customer_state;
	}

	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}

	public String getCustomer_currentAddress() {
		return customer_currentAddress;
	}

	public void setCustomer_currentAddress(String customer_currentAddress) {
		this.customer_currentAddress = customer_currentAddress;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Customer_name == null) ? 0 : Customer_name.hashCode());
		result = prime * result + ((customer_currentAddress == null) ? 0 : customer_currentAddress.hashCode());
		result = prime * result + ((customer_gender == null) ? 0 : customer_gender.hashCode());
		result = prime * result + ((customer_state == null) ? 0 : customer_state.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (Customer_name == null) {
			if (other.Customer_name != null)
				return false;
		} else if (!Customer_name.equals(other.Customer_name))
			return false;
		if (customer_currentAddress == null) {
			if (other.customer_currentAddress != null)
				return false;
		} else if (!customer_currentAddress.equals(other.customer_currentAddress))
			return false;
		if (customer_gender == null) {
			if (other.customer_gender != null)
				return false;
		} else if (!customer_gender.equals(other.customer_gender))
			return false;
		if (customer_state == null) {
			if (other.customer_state != null)
				return false;
		} else if (!customer_state.equals(other.customer_state))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", Customer_name=" + Customer_name + ", customer_gender=" + customer_gender
				+ ", customer_state=" + customer_state + ", customer_currentAddress=" + customer_currentAddress + "]";
	}

}
