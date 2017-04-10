package com.nitro.Service;

import com.nitro.Connection.Connection;
import com.nitro.Entity.Repo.Repo;
import com.nitro.Entity.Repo.ValueRepo;
import com.nitro.Entity.Users.ListlUser;
import com.nitro.Entity.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    @Autowired
    Connection connection;
    @Autowired
    ProjectService projectService;
    @Autowired
    RepoServise repoServise;


    public Map<String, List<User>> getProjectUsers() {
        Map<String, List<User>> userProjectPermissions = new TreeMap<>();
        Map<String, String> projects = projectService.getProjects();
        Collection<String> keys = projects.values();
        for (String key : keys) {
            ListlUser users = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/permissions/users"
                    , HttpMethod.GET, connection.getConnection(), ListlUser.class, key).getBody();


            userProjectPermissions.put(key, users.getValues());
        }
        return userProjectPermissions;

    }

    public Map<String, ListlUser> getRepoUsers() {

        Map<String, ListlUser> allRepoUser = new HashMap<>();
        Map<String, String> projects = projectService.getProjects();
        Collection<String> keys = projects.values();
        for (String key : keys) {
            ValueRepo valueRepo = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos"
                    , HttpMethod.GET, connection.getConnection(), ValueRepo.class, key).getBody();
            List<Repo> values = valueRepo.getValues();
            for (Repo repo : values) {
                String slug = repo.getSlug();
                ListlUser users = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos/{repo}/permissions/users"
                        , HttpMethod.GET, connection.getConnection(), ListlUser.class, key, slug).getBody();
                allRepoUser.put(slug, users);
            }

        }
        return allRepoUser;
    }
    public Set<String> getSortUsers(){
        Set<String> nameusers= new TreeSet<>();
        Map<String, String> projects = projectService.getProjects();
        Collection<String> keys = projects.values();
        for (String key : keys) {
            ValueRepo valueRepo = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos"
                    , HttpMethod.GET, connection.getConnection(), ValueRepo.class, key).getBody();
            List<Repo> values = valueRepo.getValues();
            for (Repo repo : values) {
                String slug = repo.getSlug();
                ListlUser users = connection.getRestTemplate().exchange("http://stash.riversoft.biz:7990/projects/{key}/repos/{repo}/permissions/users"
                        , HttpMethod.GET, connection.getConnection(), ListlUser.class, key, slug).getBody();
                List<User> user = users.getValues();
                for (User username:user){
                    nameusers.add(username.getUser().getDisplayName());
                }
            }

        }
        return nameusers;
    }

    public void getPermissionUser(String user) {
    }
}
