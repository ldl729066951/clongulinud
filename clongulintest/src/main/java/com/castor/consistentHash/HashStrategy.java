package com.castor.consistentHash;

public interface HashStrategy {
	int getHashCode(String origin);
}
