package com.nitro.Service;


import com.nitro.Connection.Connection;
import com.nitro.Entity.Project.Project;
import com.nitro.Entity.Project.ValueProject;
import com.nitro.Entity.Users.ListlUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ProjectService {


    @Autowired
    Connection connection;

    @Autowired
    RepoServise repoServise;

    public Map<String, String> getProjects(){
        Map<String,String> listProject=new TreeMap<>();

        ValueProject valueProject = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects?limit=3"
                , HttpMethod.GET, connection.getConnection(), ValueProject.class).getBody();
        List<Project> values = valueProject.getValues();
        for(Project project : values){
            String name = project.getName();
            String key = project.getKey();
            listProject.put(name,key);
        }

        return listProject;

    }

    public Map<String, Map<String, ListlUser>> getProjectAllInfo() {
        Map<String, Map<String, ListlUser>> allProject= new HashMap<>();
        ValueProject valueProject = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects?limit=3"
                , HttpMethod.GET, connection.getConnection(), ValueProject.class).getBody();
        List<Project> values = valueProject.getValues();
        for (Project project:values){
            String name = project.getName();
            String key = project.getKey();
            allProject.put(name, repoServise.getAllRepoProject(key));
        }



        return allProject;
    }
}
