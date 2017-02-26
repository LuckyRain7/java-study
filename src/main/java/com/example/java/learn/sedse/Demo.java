package com.example.java.learn.sedse;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.example.java.learn.consts.Consts;
import com.google.common.collect.Lists;

public class Demo {

	private static final String ALICE = "alice";

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		sedseByMemory();
		//sedseByFile();
	}
	
	static void sedseByMemory() throws IOException, ClassNotFoundException {
		// create a user
		final User origin = newUser();
		System.out.println("original: " + origin);

		// serialize to file
		final ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(origin);
		}

		// deserialize from file
		final ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		final User deserialized;
		try (ObjectInputStream ois = new ObjectInputStream(bais)) {
			deserialized = (User) ois.readObject();
		}
		System.out.println("deserilized: " + deserialized);
	}

	static void sedseByFile() throws IOException, ClassNotFoundException {
		final String path = Consts.VAR + File.separator + ALICE;

		// create a user
		final User origin = newUser();
		System.out.println("original: " + origin);

		// serialize to file
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
			oos.writeObject(origin);
		}

		// deserialize from file
		final User deserialized;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
			deserialized = (User) ois.readObject();
		}
		System.out.println("deserilized: " + deserialized);
	}

	private static User newUser() {
		User ret = new User();
		ret.setId(1L);
		ret.setName(ALICE);
		ret.setPassword("changeme");
		ret.setTransientStr("this field should be se/dse");
		ret.setArray(new String[]{"array_member_1"});
		ret.setList(Lists.newArrayList("list_member_1"));
		return ret;
	}

}
