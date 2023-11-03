package ksmart.ks48team01.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class PaymentController {

	@GetMapping("/payment")
	public String paymentPage() {
		return "user/payment/payment";
	}
}
