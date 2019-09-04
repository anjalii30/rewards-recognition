package com.rar.controller;

import com.rar.model.ProjectModel;
import com.rar.model.Samplenominate;
import com.rar.repository.DAOUserRepository;
import com.rar.repository.ProjectRepository;
import com.rar.repository.SampleNominaterepository;
import com.rar.service.SampleNominateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@EnableAutoConfiguration
@RequestMapping
@Api(value="Rewards And Recognition", description="Nomination Controller")
public class NominateController {


    @Autowired
    SampleNominateService snservice;

    @Autowired
    DAOUserRepository daoUserRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    SampleNominaterepository sampleNominaterepository;

    @Autowired
    CreaterewardController createrewardController;

    @ApiOperation(value = "get employees list for the particular project")
    @GetMapping(value = "/trail/load/{projectname}")
    public List<String> load(@PathVariable String projectname) {
        System.out.println(projectname);
        List<String> users = daoUserRepository.getEmployeeByProject(projectname);
        return users;
    }

    @ApiOperation(value = "returns the list of projects")
    @GetMapping("/trail/projectlist")
    public List getProjectsList() {
        return (List) projectRepository.getProjectsList();
    }

    @ApiOperation(value = "get the nomination data and disable it once nominated")
    @PostMapping("/trail/save")
    public Samplenominate save(@RequestBody Samplenominate samplenominate) {
        sampleNominaterepository.save(samplenominate);
       // createrewardController.findByRolled();
       // samplenominate.setDisable(true);
        return samplenominate;
    }

    @ApiOperation(value = "create project and assign employees ")
    @PostMapping("/projects")
    public ProjectModel getProjects(@RequestBody ProjectModel projectModel){
        //  String username=projectModelService.tokendecoder(token);
        System.out.println(projectModel);
        projectRepository.save(projectModel);
        return projectModel;

    }
}
