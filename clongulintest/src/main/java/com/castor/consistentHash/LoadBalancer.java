package com.castor.consistentHash;

import java.util.List;

public interface LoadBalancer {
	Server select(List<Server> servers, Invocation invocation);
}
