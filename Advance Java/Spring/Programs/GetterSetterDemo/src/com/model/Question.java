package com.model;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String qname;
	private List<String> answer;

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getQname() {
		return qname;
	}



	public void setQname(String qname) {
		this.qname = qname;
	}



	public List<String> getAnswer() {
		return answer;
	}



	public void setAnswer(List<String> answer) {
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
