package com.empolyee.manage.repo;

import com.empolyee.manage.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Long> {
    List<Employee> findByName(String name);
    List<Employee> findByCity(String city);
    List<Employee> findByEmail(String email);
    List<Employee> findByContact(String contact);




}
