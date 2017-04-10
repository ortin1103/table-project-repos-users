package com.nitro.Controllers;


import com.nitro.Service.ProjectService;
import com.nitro.Service.RepoServise;
import com.nitro.Service.TableService;
import com.nitro.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Controllers {
@Autowired
    ProjectService projectService;
@Autowired
    RepoServise repoServise;
@Autowired
    UserService userService;
@Autowired
    TableService tableService;



    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)

    public String getForm(Model model) {

//        model.addAttribute("nameProjects", projectService.getProjects());
//        model.addAttribute("projectPermissions", userService.getProjectUsers());
//        model.addAttribute("userRepos", userService.getRepoUsers());
        model.addAttribute("allUsers", userService.getSortUsers());
        model.addAttribute("table", tableService.getTable() );
        return "form";

    }
}
