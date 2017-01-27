package com.example.java.learn.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;

public class DeleteGroup extends ConnWatcher {

	public DeleteGroup() throws IOException, InterruptedException {
		super();
	}

	void delete(String groupName) throws KeeperException, InterruptedException  {
		String path = "/" + groupName;
		try {
			List<String> children = zk.getChildren(path, false);
			for (String child : children) {
				zk.delete(path + "/" + child, -1);
			}
			zk.delete(path, -1);
		} catch (KeeperException.NoNodeException e) {
			System.out.printf("Group %s does not exist\n", groupName);
		}
	}

	public static void main(String[] args) throws Exception {
		try (DeleteGroup obj = new DeleteGroup()) {
			obj.delete("zoo");
		}
	}

}
