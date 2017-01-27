package com.example.java.learn.zookeeper;

import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.KeeperException;

public class ListGroup extends ConnWatcher {

	public ListGroup() throws IOException, InterruptedException {
		super();
	}

	void list(String groupName) throws KeeperException, InterruptedException {
		String path = "/" + groupName;
		try {
			List<String> children = zk.getChildren(path, false);
			if (children.isEmpty()) {
				System.out.printf("No members in group %s\n", groupName);
				return;
			}

			for (String child : children) {
				System.out.println(child);
			}
		} catch (KeeperException.NoNodeException e) {
			System.out.printf("Group %s does not exist\n", groupName);
		}
	}

	public static void main(String[] args) throws Exception {
		try (ListGroup obj = new ListGroup()) {
			obj.list("zoo");
		}
	}

}
