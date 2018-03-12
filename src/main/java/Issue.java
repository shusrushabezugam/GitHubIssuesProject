package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Issue implements Comparable<Issue>{
    long number;
    public int id;
    String state;
    String title;
    String body;
    Date createdAt;
    Date closedAt;
    User user;
    User assignee;

    public Issue() {
        
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(Date closedAt) {
        this.closedAt = closedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
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
        if (this != obj && this.getClass()==obj.getClass())
        {
            return true;
        }
        if (obj == null) {
            return false;
        }
 
        Issue other = (Issue) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Issue number=" + number + "\n id=" + id + "\n state=" + state
                + "\n title=" + title + "\n body=" + body + "\n createdAt="
                + createdAt + "\n closedAt=" + closedAt + "\n user=" + user
                + "\n assignee=" + assignee + "";
    }
    @Override
    public int compareTo(Issue i)
    {
        ArrayList<Issue> issues = new ArrayList<Issue>();
        Collections.sort(issues);
        if(this.id>i.id)
        {
            return 1;
        }
        else  if(this.id<i.id)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}
