package test.java;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Issue;
import main.java.IssueParser;

public class IssueParserTest {
    String JSONAsString;
@Before
    public void setUp() throws IOException
    {
    InputStream is = new FileInputStream("A_Sample.txt");
    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
    String line = buf.readLine(); 
    StringBuilder sb = new StringBuilder(); 
    while(line != null)
    { 
        sb.append(line).append("\n");
        line = buf.readLine(); 
        } 
    JSONAsString = sb.toString(); 
    System.out.println("Contents : " + JSONAsString);
    buf.close();
    
    }
@Test 
public void parseIssues()
{
    IssueParser ip=new IssueParser();
    List<Issue> ls = new ArrayList<Issue>();
    ls =ip.parseIssues(JSONAsString); 
    assertEquals(JSONAsString,ls);
    
}


}
