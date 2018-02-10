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
public Issue()
{
	
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
@Override
public String toString() {
	return "Issue [number=" + number + ", id=" + id + ", state=" + state + ", title=" + title + ", body=" + body
			+ ", createdAt=" + createdAt + ", closedAt=" + closedAt + ", user=" + user + ", assignee=" + assignee + "]";
}

}
