package com.revature.TheGame;

import java.util.Random;

public class TheGame implements Comparable<TheGame> {

	private String name;
	private String question;
	@Override
	public String toString() {
		return "TheGame [name=" + name + ", question=" + question + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public TheGame(String name, String question) {
		super();
		this.name = name;
		this.question = question;
	}
	public TheGame() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int compareTo(TheGame o) {
		
		return (int) ((o.hashCode()* Math.random()) - (o.hashCode() * Math.random()));
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TheGame other = (TheGame) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	

	
}
