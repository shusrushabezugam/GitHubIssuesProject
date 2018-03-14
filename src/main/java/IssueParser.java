package main.java;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class IssueParser {
public List<Issue> parseIssues(String s)
{
    List<Issue> i=new ArrayList<Issue>();
   /* Gson gson = new Gson();
    
       List<Issue> issues = new ArrayList<Issue>();
       Type collectionType = new TypeToken<List<Issue>>(){}.getType();
       i = gson.fromJson(s, collectionType);

   */
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
       
       Type collectionType = new TypeToken<List<Issue>>(){}.getType();
       i = gson.fromJson(s, collectionType);

  
    return i;
}
}
