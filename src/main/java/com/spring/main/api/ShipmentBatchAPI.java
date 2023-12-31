package com.spring.main.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.spring.main.Service.ProductPosionService;
import com.spring.main.Service.ShipmentBacthDetailService;
import com.spring.main.Service.ShipmentBacthService;
import com.spring.main.model.ProductPositioning;
import com.spring.main.model.ShipmentBatch;
import com.spring.main.model.ShipmentBatchDetail;
import com.spring.main.model.Store;

@CrossOrigin("*")
@RestController
@RequestMapping("/bachhoa/api/shibat/")
public class ShipmentBatchAPI {
	/*
	 * Chu thich: Ban giao ca : Dot cham hang : ShipmentBatch
	 * 
	 */
	@Autowired
	ShipmentBacthService shipmentBacthService;

	@Autowired
	ShipmentBacthDetailService shipmentBacthDetailService;

	@Autowired
	ProductPosionService productPosionService;

	/*
	 * 1. Tao ban giao ca (dot cham hang) - Tham so: ShipmentBatch - Dung khi: Hoan
	 * tat tao ban giao ca
	 */
	@PostMapping("insert")
	private void insert(@RequestPart("ShipmentBatch") ShipmentBatch shipmentBatch,
			@RequestPart("ShipmentBacthDetail") List<ShipmentBatchDetail> list) {
		shipmentBacthService.insert(shipmentBatch);
		shipmentBacthDetailService.insert(list);
	}
	
	/*
	 * 2. Lay danh sach ban giao ca - Tham so: ma cua hang - Dung khi: Can lay danh
	 * sach ban giao ca
	 * 
	 */
	@GetMapping("findALL/{storeID}")
	private List<ShipmentBatch> findALL(@PathVariable("storeID") int storeID) {
		return shipmentBacthService.findByStoreID(storeID);
	}

	/*
	 * 2. Chuyen doi trang thai hoan tat cua ban giao ca - Tham so: ma so ban giao
	 * ca (shiBatID) - Dung khi: Ke cuoi cung trong danh sach cua "Ban giao ca" duoc
	 * hoan tat
	 */
	@PutMapping("setStatus/{shiBatID}")
	private void setStatus(@PathVariable("shiBatID") String shiBatID) {
		shipmentBacthService.setFinish(shiBatID);
	}


}
