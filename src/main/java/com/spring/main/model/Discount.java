package com.spring.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discounts")
public class Discount {
	@Id
	@Column(name = "disID")
	private String disID;

	@Column(name = "discountType")
	private String discountType;
	//
	// @OneToMany(mappedBy = "discount")
	// private List<DiscountDetails> discountDetails;

	public String getDisID() {
		return disID;
	}

	public void setDisID(String disID) {
		this.disID = disID;
	}

	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

}
