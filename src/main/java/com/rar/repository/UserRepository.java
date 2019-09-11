package com.rar.repository;

import com.rar.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {



    User findByUsername(String username);

    @Query(value = "select u.username from users u where u.id in (Select emp_id from projects where projectname=?1)",nativeQuery = true)
    public List<String> getEmployeeByProject(String projectname);


    @Query(value = "select role from users where username=?1", nativeQuery = true)
    String findRoleByUserName(String username);
}
