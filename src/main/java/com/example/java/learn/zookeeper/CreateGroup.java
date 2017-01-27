package com.example.java.learn.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;

public class CreateGroup extends ConnWatcher {

	public CreateGroup() throws IOException, InterruptedException {
		super();
	}

	void createGroup(String groupName) throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		String createdPath = zk.create(path, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		System.out.println("Created " + createdPath);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		CreateGroup obj = new CreateGroup();
		try {
			obj.createGroup("zoo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			obj.destroy();
		}
	}

}
