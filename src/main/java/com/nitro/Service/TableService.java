package com.nitro.Service;

import com.nitro.Entity.Users.ListlUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class TableService {

    @Autowired
    RepoServise repoServise;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;

    public Map<String, Map<String, ListlUser>> getTable(){
          return projectService.getProjectAllInfo();

}
    public void getPermissions(){
        Set<String> users = userService.getSortUsers();
        for (String user: users){
            userService.getPermissionUser(user);



        }


    }


}
