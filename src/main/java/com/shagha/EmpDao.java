package com.shagha;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpDao {
    private JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int save(Emp em) {
        String sql = "insert into emp0 (name, age, salary) values('" + em.getName() + "','" + em.getAge() + "','" + em.getSalary() + "') ";
        return jdbcTemplate.update(sql);
    }

    public List<Emp> showAllEmployeeswithRowMapper(){
        return jdbcTemplate.query("select * from emp0", new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp RmEmp= new Emp();
                RmEmp.setId(resultSet.getInt(1));
                RmEmp.setName(resultSet.getString(2));
                RmEmp.setAge(resultSet.getInt(3));
                RmEmp.setSalary(resultSet.getInt(4));
                return RmEmp;
            }
        });

    }

public int delete(int id){
        String sql = "delete from emp0 where id ="+id;
        return jdbcTemplate.update(sql);
 }
 public int update(Emp p){
     String  sql = "update emp0 set name = '"+p.getName()+"',salary = '"+p.getSalary()+"',age = '"+p.getAge()+"' where id = '"+p.getId()+"'";
     return jdbcTemplate.update(sql);
 }
public Emp getEmpById(final int id){
        String sql = "select * from emp0 where id ="+id;


    Emp emp = (Emp) jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper(Emp.class));
    return emp;
}

}
