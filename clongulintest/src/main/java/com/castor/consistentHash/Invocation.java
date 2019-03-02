package com.castor.consistentHash;

public class Invocation {
	private String hashKey;

	public Invocation(String hashKey) {
		this.hashKey = hashKey;
	}

	public String getHashKey() {
		return hashKey;
	}

	public void setHashKey(String hashKey) {
		this.hashKey = hashKey;
	}
}
