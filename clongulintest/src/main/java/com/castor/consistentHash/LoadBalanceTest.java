package com.castor.consistentHash;

import com.google.common.util.concurrent.AtomicLongMap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoadBalanceTest {

	static String[] ips = {"192.168.1.1","192.168.1.2","192.168.1.3","192.168.1.4","192.168.1.5","192.168.1.6","192.168.1.7","192.168.1.8","192.168.1.9","192.168.1.10","192.168.1.11","192.168.1.12","192.168.1.13","192.168.1.14"};

	public static void testDistribution(){
		List<Server> servers = new ArrayList<>();
		for (String ip: ips){
			servers.add(new Server(ip));
		}

		ConsistentHashLoadBalancer chloadBalance = new ConsistentHashLoadBalancer();
		List<Invocation> invocations = new ArrayList<>();
		for (int i = 0; i < 10000; i++){
			invocations.add(new Invocation(UUID.randomUUID().toString()));
		}

		AtomicLongMap<Server> atomicLongMap = AtomicLongMap.create();
		for (Invocation invocation: invocations){
			Server selectedServer = chloadBalance.select(servers, invocation);
			atomicLongMap.getAndIncrement(selectedServer);
		}

        System.out.println(atomicLongMap);
	}

  public static void main(String[] args) {
	  testDistribution();
  }
}
