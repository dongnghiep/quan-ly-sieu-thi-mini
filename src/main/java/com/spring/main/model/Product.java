package com.spring.main.model;

import java.sql.Date;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@Column(name = "productID")
	private String productID;

	@ManyToOne
	@JoinColumn(name = "categoriesID")
	private Categories categories;

	@Column(name = "price")
	private float price;

	@Column(name = "vat")
	private int vat;

	@Column(name = "nearestExpDate")
	private Date nearestExpDate;

	@Column(name = "productName")
	private String productName;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "image")
	private String image;

	@Column(name = "importPrice")
	private float importPrice;

	@ManyToOne()
	@JoinColumn(name = "storeID")
	private Store store;
	@Column(name = "inventory")
	private Integer inventory;

	public Product(String productID) {

		this.productID = productID;
	}

	public Product() {

	}

	public Product(String productID, Categories categories, float price, int vat, Date nearestExpDate,
			String productName, Boolean status, String image, float importPrice, Store store, Integer inventory) {

		this.productID = productID;
		this.categories = categories;
		this.price = price;
		this.vat = vat;
		this.nearestExpDate = nearestExpDate;
		this.productName = productName;
		this.status = status;
		this.image = image;
		this.importPrice = importPrice;
		this.store = store;
		this.inventory = inventory;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getVat() {
		return vat;
	}

	public void setVat(int vat) {
		this.vat = vat;
	}

	public Date getNearestExpDate() {
		return nearestExpDate;
	}

	public void setNearestExpDate(Date nearestExpDate) {
		this.nearestExpDate = nearestExpDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(float importPrice) {
		this.importPrice = importPrice;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	// @OneToMany(mappedBy = "product")
	// private List<Warehouse> warehouses;
	//
	// @OneToMany(mappedBy = "product")
	// private List<BillDetail> billDetails;
	//
	// @OneToMany(mappedBy = "product")
	// private List<ProductPositioning> productPositionings;
	//
	// @OneToMany(mappedBy = "product")
	// private List<DiscountDetails> discountDetails;

}
