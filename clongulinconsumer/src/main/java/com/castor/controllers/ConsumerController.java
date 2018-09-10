package com.castor.controllers;

import com.castor.api.interfaces.DemoController;
import com.castor.dtos.DemoLombok;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;

	@Value("${active}")
	private String active;

	@Autowired
	DemoController demoController;

	@GetMapping("/consume")
	public Object consume(){
		return restTemplate.getForObject("http://clongulin/demo/hello",DemoLombok.class);
	}

	@GetMapping("/registered")
	public String getRegistered(){
		List<ServiceInstance> list = discoveryClient.getInstances("clongulin");
		//System.out.println(discoveryClient.getLocalServiceInstance());
		System.out.println("discoveryClient.getServices().size() = " + discoveryClient.getServices().size());

		for( String s :  discoveryClient.getServices()){
			System.out.println("services " + s);
			List<ServiceInstance> serviceInstances =  discoveryClient.getInstances(s);
			for(ServiceInstance si : serviceInstances){
				System.out.println("    services:" + s + ":getHost()=" + si.getHost());
				System.out.println("    services:" + s + ":getPort()=" + si.getPort());
				System.out.println("    services:" + s + ":getServiceId()=" + si.getServiceId());
				System.out.println("    services:" + s + ":getUri()=" + si.getUri());
				System.out.println("    services:" + s + ":getMetadata()=" + si.getMetadata());
			}

		}

		System.out.println(list.size());
		if (list != null && list.size() > 0 ) {
			System.out.println( list.get(0).getUri()  );
		}
		return null;
	}

	@GetMapping("/config")
	public Object getConfig(){
		return "active:"+active;
	}



}
