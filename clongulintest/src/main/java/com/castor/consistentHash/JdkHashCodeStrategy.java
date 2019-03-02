package com.castor.consistentHash;

public class JdkHashCodeStrategy implements HashStrategy {
	@Override
	public int getHashCode(String origin) {
		return origin.hashCode();
	}
}
