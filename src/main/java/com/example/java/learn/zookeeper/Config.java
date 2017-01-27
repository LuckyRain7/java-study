package com.example.java.learn.zookeeper;

public class Config {

	private String hosts;
	private int sessionTimeoutMillis;

	public Config() {
		this("127.0.0.1", 5000);
	}

	public Config(String hosts, int sessionTimeoutMillis) {
		this.hosts = hosts;
		this.sessionTimeoutMillis = sessionTimeoutMillis;
	}

	public String getHosts() {
		return hosts;
	}

	public int getSessionTimeoutMillis() {
		return sessionTimeoutMillis;
	}

}
