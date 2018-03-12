package test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.java.User;

public class UserTest {

    @Test
    public void userHashCodeTest()
    {
        User u1=new User();
        User u2=new User();
        int h1,h2;
        h1=u1.hashCode();
        h2=u2.hashCode();
        assertTrue(h1==h2);
    }
    @Test
    public void equalsUserTest() {
        User u1=new User();
        User u2=new User();
       assertTrue(u1.getId()==u2.getId());
           
    }
    @Test
    public void toStringTest()
    {
        User u1=new User();
        String str ="User [login=" + "null" + ", id=" + 0 + "]";
        assertEquals(str, u1.toString());
        
    }
}
