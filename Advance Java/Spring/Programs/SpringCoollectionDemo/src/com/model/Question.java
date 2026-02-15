package com.model;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String qname;
	private List<String> answer;

	public Question() {

	}

	public Question(int id, String qname, List<String> answer) {
		super();
		this.id = id;
		this.qname = qname;
		this.answer = answer;
	}

	public void display() {
		System.out.println(id + " " + qname);
		System.out.println("Ansers are : ");
		Iterator<String> itr = answer.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
