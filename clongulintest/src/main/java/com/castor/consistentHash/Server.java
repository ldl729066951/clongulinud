package com.castor.consistentHash;

public class Server {
	private String url;
	private String ip;


	public Server(String ip) {
		this.ip = ip;
		this.url = ip + ":8080";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
