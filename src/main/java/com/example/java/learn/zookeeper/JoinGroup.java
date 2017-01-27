package com.example.java.learn.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class JoinGroup extends ConnWatcher {

	public JoinGroup() throws IOException, InterruptedException {
		super();
	}

	void join(String groupName, String memberName) throws KeeperException, InterruptedException {
		String path = "/" + groupName + "/" + memberName;
		String createdPath = zk.create(path, null, Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
		System.out.println("Created " + createdPath);
	}

	public static void main(String[] args) throws Exception {
		try (JoinGroup obj = new JoinGroup()) {
			obj.join("zoo", "duck");
			Thread.sleep(10000);
		}
	}

}
