package com.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.main.util.SessionAttr;

@Controller
public class HomeController {
	// Custom Toast
	static void callToast(String name) {
		// Tự gọi icon hiển thị
		SessionAttr.Toast = name;
		SessionAttr.Icon = name + "__icon";
		SessionAttr.Title = name + "__title";
		SessionAttr.Close = name + "__close";
	}

	@RequestMapping("/sell")
	public String home(Model model) {
		model.addAttribute("message", SessionAttr.CURRENT_MESSAGE);
		callToast("success");
		// Toast - Thông báo
		model.addAttribute("Toast", SessionAttr.Toast);
		model.addAttribute("Toast_icon", SessionAttr.Icon);
		model.addAttribute("Toast_show_icon", SessionAttr.Show_Icon);
		model.addAttribute("Toast_title", SessionAttr.Title);
		model.addAttribute("Toast_close", SessionAttr.Close);
		SessionAttr.Show_Icon = SessionAttr.Success_Show_Icon;
		return "pages/sell/sell";
	}

	@RequestMapping("/sell/billsHistory")
	public String bills() {
		return "pages/sell/bills_History";
	}

	@RequestMapping("/sell/productInfomation")
	public String ktGia() {
		return "pages/sell/productDetail";
	}

	@RequestMapping("/admin/endOfShift")
	public String endShift() {
		return "pages/admin/pay/pay";
	}

	@RequestMapping("/admin/inventoryHistory")
	public String kiemke() {
		return "pages/admin/inventory_history/inventory_history";
	}

	@RequestMapping("/admin/discountManagement")
	public String discountManagement() {
		return "pages/admin/discount/discountManagement";
	}
}
