package com.nitro.Service;

import com.nitro.Connection.Connection;
import com.nitro.Entity.Repo.Repo;
import com.nitro.Entity.Repo.ValueRepo;
import com.nitro.Entity.Users.ListlUser;
import com.nitro.Entity.Users.User;
import com.nitro.Entity.Users.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RepoServise {
    @Autowired
    ProjectService projectService;
    @Autowired
    Connection connection;

    public Map<String, List<Repo>> getProjectRepos() {
        Map<String, List<Repo>> listRepo= new HashMap<>();
        Map<String, String> projects = projectService.getProjects();
        Collection<String> keys = projects.values();
        for (String key:keys){
            ValueRepo valueRepo = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos"
                    , HttpMethod.GET, connection.getConnection(), ValueRepo.class, key).getBody();
            List<Repo> values = valueRepo.getValues();
            listRepo.put(key,values);

        }
        return listRepo;

    }

    public Map<String, ListlUser> getAllRepoProject(String key) {
        Map<String, ListlUser> allRepoProject= new HashMap<>();
        ValueRepo valueRepo = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos"
                , HttpMethod.GET, connection.getConnection(), ValueRepo.class, key).getBody();
        List<Repo> values = valueRepo.getValues();
        for (Repo repo: values){
            String slug = repo.getSlug();
            ListlUser users = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos/{slug}/permissions/users"
                    , HttpMethod.GET, connection.getConnection(), ListlUser.class, key, slug).getBody();
           if(users.getValues().isEmpty()){
               User user = new User(new UserDetail("none","none",0,"none"),"none");
               users.getValues().add(user);
            }
            allRepoProject.put(slug,users);
        }


        return allRepoProject;

    }
}

