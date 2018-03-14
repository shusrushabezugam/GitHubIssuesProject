package main.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {

    private static Scanner scanner;

  /*  public void issueExporterFunction() throws FileNotFoundException {
        System.out.println("Please enter GitHub username");
        scanner = new Scanner(System.in);
        String gn = scanner.next();
        System.out.println("Please enter GitHub password");
        String pwd = scanner.next();
      
         * Issue i1 = new Issue(); Issue i2 = new Issue(); Issue i3 = new
         * Issue(); User u1 = new User(); User u2 = new User();
         * i1.setId(296059795); i1.setNumber(1);
         * i1.setTitle("Found a Bug test issue 1"); i1.setUser(u1);
         * u1.setLogin("shusrushabezugam"); u1.setId(29138698);
         * i1.setAssignee(u2); u2.setId(6319957); u2.setLogin("Ms-O");
         * i1.setState("open"); i1.setBody("Testing first issue 1");
         * i1.setCreatedAt(new Date()); i1.setClosedAt(null);
         * 
         * i2.setId(296060235); i2.setNumber(2);
         * i2.setTitle("problem to be solved issue2"); i2.setUser(u1);
         * u1.setLogin("shusrushabezugam"); u1.setId(29138698);
         * i2.setAssignee(u2); i2.setState("open");
         * i2.setBody("Bug not yet resolved."); i1.setCreatedAt(new Date(18, 10,
         * 10)); i1.setClosedAt(null);
         * 
         * i3.setId(296060285); i3.setNumber(3);
         * i3.setTitle("Bug Solved issue 3"); i3.setUser(u1);
         * u1.setLogin("shusrushabezugam"); u1.setId(29138698);
         * i3.setAssignee(u1); i3.setState("closed");
         * i3.setBody("Bug got resolved."); i3.setCreatedAt(new Date());
         * i3.setClosedAt(new Date()); ArrayList<Issue> issues = new
         * ArrayList<Issue>(); issues.add(i1); issues.add(i2); issues.add(i3);
         * 
         * int size = issues.size();
         * 
         * Iterator<Issue> iterator = issues.iterator(); if (issues.isEmpty()) {
         * System.out.println("There are no issues"); } else {
         * System.out.println("Number of issues: " + size); }
         * System.out.println(); PrintStream conout = System.out; // creating a
         * new file PrintStream out = new PrintStream(new
         * FileOutputStream("issue.txt")); System.setOut(out); while
         * (iterator.hasNext()) { System.out.print(iterator.next() + "\n"); }
         * System.out.println(); out.close();
         * 
         * System.setOut(out); System.setOut(conout);
         * 
         * }
        
    }
*/
    public static void main(String[] args) throws FileNotFoundException {
//        IssueExporter ie = new IssueExporter();
        PrintStream out = new PrintStream(new FileOutputStream("issues.txt"));
        System.out.println("Please enter GitHub username");
        scanner = new Scanner(System.in);
        String gn = scanner.next();
        System.out.println("Please enter GitHub password");
        String pwd = scanner.next();
       //out.println(gn);
        //out.println(pwd);
        GitHubRestClient client = new GitHubRestClient();
        String openjson = client.requestIssues(gn, pwd,"open");
        String closedjson = client.requestIssues(gn, pwd,"closed");
        IssueParser openissuesparser = new IssueParser();
        List<Issue> openissues = openissuesparser.parseIssues(openjson);

        IssueParser closedissuesparser = new IssueParser();
        List<Issue> closedissues = openissuesparser.parseIssues(closedjson);
        openissues.addAll(closedissues);
        //
        Collections.sort(openissues);
        out.println(openissues);
        System.out.print("Total no of issues" + openissues.size());
        // System.out.println("Total no of issues"+closedissues.size());
        out.close();
    }
}