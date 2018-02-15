package main.java;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import main.java.Issue;
import main.java.User;

public class IssueTest {
    Issue i1=new Issue();
    Issue i2=new Issue();
    User u1 = new User();
    User u2 = new User();
   
   @Before
   public void setUp()
   {
       i1.setId(10);
       /*
       i1.setAssignee(u1);
       i1.setBody("Bug to be solved");
       i1.setClosedAt(new Date());
       i1.setAssignee(u1);
       i1.setCreatedAt(new Date());
       i1.setNumber(123);
       i1.setTitle("First Bug");
       i1.setState("open");
       */
       i2.setBody("Second Bug");
       u1.setId(10);
       u1.setLogin("shusrushabezugam");
       u2.setId(10);
       u2.setLogin("Ms-O");
       
       
   }
   
    @Test
    public void equalsIssueTest() {
      
       assertTrue(i1.getId()==i2.getId());
           
    }
    @Test
    public void issueHashCodeTest()
    {
        int y,z;
        y=i1.hashCode();
        z=i2.hashCode();
        assertTrue(y==z);
    }
    
    @Test
    public void userHashCodeTest()
    {
        int h1,h2;
        h1=u1.hashCode();
        h2=u2.hashCode();
        assertTrue(h1==h2);
    }
    @Test
    public void equalsUserTest() {
      
       assertTrue(u1.getId()==u2.getId());
           
    }
    @Test
    public void toStringTest()
    {
        assertEquals("Second Bug",i2.getBody().toString());
    }
}
// test for exceptions
//@Test(expeccted=npe.class)