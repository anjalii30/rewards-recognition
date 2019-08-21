package com.rewardsandrecognition.repository;

//import com.example.dropdown.Model.EmployeeModel;
import com.rewardsandrecognition.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Transactional
@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EmployeeModel> getEmployeeByProject(String projectname) {
        String sql = "select * from employee where projectname = ?";

        RowMapper<EmployeeModel> rowMapper = new EmployeeModelRowMapper();
        List<EmployeeModel> list = jdbcTemplate.query(sql, rowMapper, projectname);

        return list;
    }

    class EmployeeModelRowMapper implements RowMapper<EmployeeModel> {
        @Override
        public EmployeeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmployeeModel employee = new EmployeeModel();
            employee.setEmployeeid(rs.getInt("employeeid"));
            employee.setEmployeename(rs.getString("employeename"));
            return employee;
        }
    }
}
