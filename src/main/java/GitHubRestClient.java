
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GitHubRestClient {

    public static void main(String[] args) {
        GitHubRestClient prototype = new GitHubRestClient();
        String json = prototype.requestIssues("", "", "open");
        System.out.println(json);
    }

    public String requestIssues(String username, String password,
            String state) {
        String jsonContent = null;
        String x = null;

        if (("open").equals(state)) {
            x = "https://api.github.com/repos/SoftwareStudioSpring2018/githubapi-issues-shusrushabezugam/issues?state=open";
        }
        else {
            x = "https://api.github.com/repos/SoftwareStudioSpring2018/githubapi-issues-shusrushabezugam/issues?state=closed";
        }
        HttpHost target = new HttpHost("api.github.com", 443, "https");
        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(target.getHostName(), target.getPort()),
                new UsernamePasswordCredentials(username, password));

        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider).build();

        AuthCache authCache = new BasicAuthCache();
        BasicScheme basicAuth = new BasicScheme();
        authCache.put(target, basicAuth);

        HttpClientContext localContext = HttpClientContext.create();
        localContext.setAuthCache(authCache);
        HttpGet httpget = new HttpGet(x);
        BufferedReader reader = null;
        try {
            CloseableHttpResponse response = httpclient.execute(target, httpget,
                    localContext);
            System.out.println(response.getStatusLine());

            HttpEntity entity = response.getEntity();

            reader = new BufferedReader(
                    new InputStreamReader(entity.getContent()));

            jsonContent = reader.readLine();

            EntityUtils.consume(entity);
        }
        catch (ClientProtocolException e) {
            
            e.printStackTrace();
        }
        catch (IOException e) {
           
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e) {
                   
                    e.printStackTrace();
                }
            }
        }
        return jsonContent;
    }

}
