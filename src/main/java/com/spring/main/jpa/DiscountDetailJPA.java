package com.spring.main.jpa;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.spring.main.model.DiscountDetails;

public interface DiscountDetailJPA extends JpaRepository<DiscountDetails, String> {
	@Query("SELECT o FROM DiscountDetails o WHERE (o.productID LIKE ?1 AND o.storeID LIKE ?2) AND o.activity = 1")
	DiscountDetails findDiscountIsActive(String productID, Integer storeID);

	@Query("SELECT o FROM DiscountDetails o WHERE o.storeID LIKE ?1")
	List<DiscountDetails> findByStoreID(Integer storeID);
	
	@Query("SELECT o FROM DiscountDetails o WHERE o.storeID LIKE ?1 AND o.startTime <= ?2 AND o.endTime >= ?3")
	List<DiscountDetails> findByDate(Integer storeID, Date startTime, Date endTime);
	
	@Query("SELECT o FROM DiscountDetails o WHERE o.storeID LIKE ?1 AND o.productID LIKE ?2")
	List<DiscountDetails> findByStoreIDAndProductID(Integer storeID, String productID);

	@Transactional
	@Modifying
	@Query(value = "UPDATE discount_details SET disID = ?1, activity = 1, startTime = ?2, endTime = ?3 WHERE productID = ?4 AND storeID = ?5", nativeQuery = true)
	void update(String disID, Date startTime, Date endTime, String productID, Integer storeID);

}
