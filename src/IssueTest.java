import static org.junit.Assert.*;

import org.junit.Test;

import main.java.Issue;
import main.java.User;

public class IssueTest {
    Issue i1=new Issue();
    Issue i2=new Issue();
    User u1 = new User();
    User u2 = new User();
    @Test
    public void equalsTest() {
      
       i1.setId(10);
       i2.setId(20);
       u1.setId(10);
       u2.setId(10);
       assertTrue(i1.getId()==i2.getId());
           
    }
    @Test
    public void hashCodeTest()
    {
        int y,z;
        y=i1.hashCode();
        z=i2.hashCode();
        assertTrue(y==z);
    }
    }

