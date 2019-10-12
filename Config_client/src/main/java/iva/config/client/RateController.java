package iva.config.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {

	@Value("${rate}")
	String rate;
	@Value("${lanecount}")
	String lanecount;
	@Value("${tollstart}")
	String tollstart;
	
	@Value("${test.property}")
	String testProperty;
	@Value("${encryptedValue}")
	String encryptedValue;

	@RequestMapping("/rate")
	public String getRate(Model m) {
		m.addAttribute("rateamount", rate);
		m.addAttribute("lanes", lanecount);
		m.addAttribute("tollstart", tollstart);
		m.addAttribute("testProperty", testProperty);
		m.addAttribute("encryptedValue", encryptedValue);

		return "rateview";

	}
}
