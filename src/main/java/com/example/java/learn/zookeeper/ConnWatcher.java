package com.example.java.learn.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ConnWatcher implements Watcher, AutoCloseable {

	protected ZooKeeper zk;
	private CountDownLatch connectedSignal = new CountDownLatch(1);
	
	public ConnWatcher() throws IOException, InterruptedException {
		this(new Config());
	}

	public ConnWatcher(Config conf) throws IOException, InterruptedException {
		this.zk = new ZooKeeper(conf.getHosts(), conf.getSessionTimeoutMillis(), this);
		this.connectedSignal.await();
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == KeeperState.SyncConnected) {
			this.connectedSignal.countDown();
		}
	}

	@Override
	public void close() throws Exception {
		this.zk.close();
		this.zk = null;
		this.connectedSignal = null;
	}

}
