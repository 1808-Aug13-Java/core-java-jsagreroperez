package com.revature.TheGame;

public class questions implements Comparable<questions> {

	private String question;

	@Override
	public String toString() {
		return "questions [question=" + question + "]";
	}

	public questions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public questions(String question) {
		super();
		this.question = question;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		questions other = (questions) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public int compareTo(questions o) {
		return (int) ((o.hashCode()* Math.random()) - (o.hashCode() * Math.random()));
	}
}
