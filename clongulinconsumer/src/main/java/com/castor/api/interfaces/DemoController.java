package com.castor.api.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface DemoController {

	//@RequestMapping(method = RequestMethod.GET, value = "/demo/get")
	@GetMapping("/demo/get")
	Object demoGet();

}
