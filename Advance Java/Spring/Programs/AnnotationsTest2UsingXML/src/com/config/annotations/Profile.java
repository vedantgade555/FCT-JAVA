package com.config.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Profile {
	@Value("Vedant Gade")
	private String title;
	
	
	@Value("Java Developer")
	private String position;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "Profile [title=" + title + ", position=" + position + "]";
	}
	
	
	
}
