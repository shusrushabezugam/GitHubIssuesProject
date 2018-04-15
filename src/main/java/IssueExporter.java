
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IssueExporter {

    private static Scanner scanner;

    public void exportIssues() throws FileNotFoundException {
        // public String getCredentials(){
        System.out.println("Please enter GitHub username");
        scanner = new Scanner(System.in);
        String gn = scanner.next();
        System.out.println("Please enter GitHub password");
        String pwd = scanner.next();
        PrintStream out = null;
        try {
            out = new PrintStream(new FileOutputStream("issues.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if (out != null) {
                out.close();

            }
        }
        GitHubRestClient client = new GitHubRestClient();
        String openjson = client.requestIssues(gn, pwd, "open");
        String closedjson = client.requestIssues(gn, pwd, "closed");
        IssueParser openissuesparser = new IssueParser();
        List<Issue> openissues = openissuesparser.parseIssues(openjson);
        IssueParser closedissuesparser = new IssueParser();
        List<Issue> closedissues = closedissuesparser.parseIssues(closedjson);
        openissues.addAll(closedissues);
        Collections.sort(openissues);
        out.println(openissues);
        System.out.print("Total no of issues" + openissues.size());
        out.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        IssueExporter ie = new IssueExporter();
        ie.exportIssues();

    }
}
