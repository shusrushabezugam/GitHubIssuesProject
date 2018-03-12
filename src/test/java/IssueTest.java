package test.java;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
       i2.setId(10);
       i1.setAssignee(u1);
       i1.setBody("Bug");
       i1.setClosedAt(null);
       i1.setAssignee(u1);
       i1.setCreatedAt(null);
       i1.setNumber(123);
       i1.setTitle("First Bug");
       i1.setState("open");
   
       i2.setBody("Second Bug");
       u1.setId(10);
       u1.setLogin("shusrushabezugam");
       u2.setId(10);
       u2.setLogin("Ms-O");
       
       
   }
   
    @Test
    public void equalsIssueTest() {
      
       assertTrue(i1.equals(i2));
    }
    @Test
    public void issueHashCodeTest()
    {
        int y,z;
        y=i1.hashCode();
        z=i2.hashCode();
       assertEquals(y,z);
    }
    @Test
    public void equalsTest()
    {
        i1.setId(10);
        i2.setId(10);
        assertEquals(0,i1.compareTo(i2));
    }
    @Test
    public void equalsGreater()
    {
        i1.setId(20);
        i2.setId(10);
        assertEquals(1,i1.compareTo(i2));
    }
    @Test
    public void equalsSmaller()
    {
        i1.setId(5);
        i2.setId(10);
        assertEquals(-1,i1.compareTo(i2));
    }
    
    @Test
    public void toStringTest()
    {
        String str = "Issue number=" + 123 + "\n id=" + 10 + "\n state=" + "open"
                + "\n title=" + "First Bug" + "\n body=" + "Bug" + "\n createdAt="
                + null + "\n closedAt=" + null + "\n user=" + null
                + "\n assignee=User [login=" + "shusrushabezugam"+", id="+10 +"]";
        assertEquals(str, i1.toString());
        
    }
}
// test for exceptions
//@Test(expeccted=npe.class)