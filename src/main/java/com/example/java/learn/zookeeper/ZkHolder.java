package com.example.java.learn.zookeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.ZooKeeper;

public class ZkHolder implements Watcher {

	private ZooKeeper zk;
	private CountDownLatch connectedSignal = new CountDownLatch(1);
	private AtomicBoolean connected = new AtomicBoolean(false);

	public ZkHolder(Config conf) throws IOException, InterruptedException {
		this.zk = new ZooKeeper(conf.getHosts(), conf.getSessionTimeoutMillis(), this);
	}
	
	public ZooKeeper get() throws InterruptedException {
		while (this.connected.get() == false) {
			this.connectedSignal.await();
		}
		return zk;
	}

	public void destroy() throws InterruptedException {
		this.zk.close();
		this.zk = null;
		this.connected = null;
		this.connectedSignal = null;
	}

	@Override
	public void process(WatchedEvent event) {
		if (event.getState() == KeeperState.SyncConnected) {
			this.connectedSignal.countDown();
			this.connected.set(true);
		}
	}

}
