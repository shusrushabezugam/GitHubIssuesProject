package main.java;

import java.util.Date;

public class Issue {
long number;
int id;
String state;
String title;
String body;
Date createdAt;
Date closedAt;
User user;
User assignee;
public Issue(long number, int id, String state, String title, String body, Date createdAt, Date closedAt, User user,
		User assignee) {
	super();
	this.number = number;
	this.id = id;
	this.state = state;
	this.title = title;
	this.body = body;
	this.createdAt = createdAt;
	this.closedAt = closedAt;
	this.user = user;
	this.assignee = assignee;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
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
	Issue other = (Issue) obj;
	if (id != other.id)
		return false;
	return true;
}

}
