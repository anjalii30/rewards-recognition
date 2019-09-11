package com.rar.controller;

import com.rar.model.Nominate;
import com.rar.model.Project;
import com.rar.repository.NominateRepository;
import com.rar.repository.ProjectRepository;
import com.rar.repository.UserRepository;
import com.rar.service.NominateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
   private NominateService nominateService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private NominateRepository sampleNominaterepository;

    @Autowired
    private CreaterewardController createrewardController;

    /**
     *
     * @param projectname (Project name)
     * @return list of employees assigned to given project
     */
    @ApiOperation(value = "get employees list for the particular project",response = List.class)
    @GetMapping(value = "/trail/load/{projectname}")
    public List<String> load(@PathVariable String projectname,@RequestHeader (value="Authorization") String token) {
        System.out.println(projectname);
        List<String> users = nominateService.getEmployeeByProject(projectname);
        return users;
    }

    /**
     *
     * @return projects list
     */
    @ApiOperation(value = "returns the list of projects",response = List.class)
    @GetMapping("/trail/projectlist")
    public List getProjectsList(@RequestHeader (value="Authorization") String token) {

        return (List) nominateService.getProjectsList();
    }

    /**
     *
     * @param samplenominate (Nominate object)
     * @return saved nomination data
     */
    @ApiOperation(value = "get the nomination data and disable it once nominated")
    @PostMapping("/trail/save")
    public Nominate save(@ApiParam(value="Nominations store in database table",required = true)
                             @RequestBody Nominate samplenominate,@RequestHeader (value="Authorization") String token) {
        nominateService.save(samplenominate);
       // createrewardController.findByRolled();
       // samplenominate.setDisable(true);
        return samplenominate;
    }

    /**
     *
     * @param projectModel (Project object)
     * @return created project and assigned employees
     */
    @ApiOperation(value = "create project and assign employees ")
    @PostMapping("/projects")
    public Project getProjects(@ApiParam(value="Project data store in database table",required=true)
                                   @RequestBody Project projectModel,@RequestHeader (value="Authorization") String token){
        //  String username=projectModelService.tokendecoder(token);
        System.out.println(projectModel);
        nominateService.saveProject(projectModel);
        return projectModel;

    }
}
