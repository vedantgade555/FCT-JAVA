package com.config.annotations;

import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import org.springframework.stereotype.Component;

@Component("inst")
public class Instructor {
	
	@Value("101")
	private int id;
	@Value("Vedant")
	private String name;
	
	@Value("#{topics}")
	private List<String> topics;
	
	private Profile profile;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
