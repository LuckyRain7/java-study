package com.example.java.learn.zookeeper;

import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class CreateGroup {

	private static ZooKeeper zk;

	public static void main(String[] args) throws InterruptedException {
		Config conf = new Config();
		ZkHolder holder = null;
		try {
			holder = new ZkHolder(conf);
			zk = holder.get();
			createGroup("zoo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (holder != null) {
				holder.destroy();
			}
		}
	}

	private static void createGroup(String groupName) throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		byte data[] = null;
		List<ACL> acl = Ids.OPEN_ACL_UNSAFE;
		CreateMode createMode = CreateMode.PERSISTENT;
		String createdPath = zk.create(path, data, acl, createMode);
		System.out.println("Created " + createdPath);
	}

}
