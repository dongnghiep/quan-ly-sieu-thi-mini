package com.spring.main.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.main.model.Product;

public interface ProductJPA extends JpaRepository<Product, String> {
	@Query(value = "Select * from products where productID  = ?1 and storeID = ?2", nativeQuery = true)
	Product getByIDAndStoreID(String productID, int storeID);

	@Query("SELECT o.productID FROM Product o")
	List<String> getProductID();

	@Query("SELECT o.productName FROM Product o")
	List<String> getProductName();

	@Query("Select o from Product o where o.productID LIKE ?1 OR o.productName LIKE ?1")
	Product getByIDOrName(String value);

	@Query(value = "Select * from products where (productID like ?1 or price = ?1 or vat = ?1 or productName like ?1) and storeID = ?2", nativeQuery = true)
	List<Product> findByKeyword(String keyword, int storeId);

	@Query(value = "Select * from products where storeID = ?1", nativeQuery = true)
	List<Product> getByStoreId(int storeId);
}
