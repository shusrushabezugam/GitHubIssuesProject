package test.java;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.Issue;
import main.java.IssueParser;

public class IssueParserTest {
    String JSONAsString=" ";
@Before
 
 public void setUp() throws IOException
    {
    InputStream is = new FileInputStream("sample-output.txt");
    BufferedReader buf = new BufferedReader(new InputStreamReader(is));
    String line = buf.readLine(); 
    StringBuilder sb = new StringBuilder(); 
    while(line != null)
    { 
        sb.append(line).append("\n");
        line = buf.readLine(); 
        } 
    JSONAsString += sb.toString(); 
    System.out.println("Contents : " + JSONAsString);
    
    
    }

 
@Test 
public void parseIssuesSizeTest()
{
    IssueParser ip=new IssueParser();
    List<Issue> ls = new ArrayList<Issue>();
    ls =ip.parseIssues(JSONAsString); 
    assertEquals(3,ls.size());
    
}
@Test 
public void parseIssuesPropertiesTest()
{
    IssueParser ip=new IssueParser();
    List<Issue> ls = new ArrayList<Issue>();
    ls =ip.parseIssues(JSONAsString); 
    Iterator<Issue> iterator = ls.iterator();
    while (iterator.hasNext()) {
        System.out.print(iterator.next() + "\n");
    }
    System.out.println(ls.get(1));
    assertEquals(4,ls.get(0).getNumber());
    
}

}
