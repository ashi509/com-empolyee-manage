package com.empolyee.manage.service;

import com.empolyee.manage.entity.Employee;
import com.empolyee.manage.exception.GenericException;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<?> addEmployee(Employee employee)throws GenericException;
    ResponseEntity<?> getAllEmployee()throws GenericException;
    ResponseEntity<?> deleteEmployeeById(long id)throws GenericException;
    ResponseEntity<?> getByIdEmployee(long id)throws GenericException;
    ResponseEntity<?> updateEmployee(Employee employee, long id)throws GenericException;

    /**
     * custom finder methode
     * @param name
     * @return
     * @throws GenericException
     */
    ResponseEntity<?> findEmployeeByName(String name)throws GenericException;
    ResponseEntity<?> findEmployeeByCity(String city)throws GenericException;
    ResponseEntity<?> findEmployeeByContact(String contact)throws GenericException;
    ResponseEntity<?> findEmployeeByEmail(String email)throws GenericException;
    /**
     * sorting one by one Attribute
     */
    ResponseEntity<?>getByIdAsc()throws GenericException;
    ResponseEntity<?>getByIdDesc()throws GenericException;

    ResponseEntity<?> getByNameAscendingOrder()throws GenericException;
    ResponseEntity<?> getByNameDescendingOrder()throws GenericException;
    ResponseEntity<?> getByCityAscendingOrder()throws GenericException;
    ResponseEntity<?> getByCityDescendingOrder()throws GenericException;
    ResponseEntity<?> getByContactAscendingOrder()throws GenericException;
    ResponseEntity<?> getByContactDescendingOrder()throws GenericException;
    ResponseEntity<?> getBySalaryAscendingOrder()throws GenericException;
    ResponseEntity<?> getBySalaryDescendingOrder()throws GenericException;

    /**
     * Employee data filtering.....................
     */


    ResponseEntity<?> getByName(String name)throws GenericException;
    ResponseEntity<?> getByCity(String city)throws GenericException;
    ResponseEntity<?> getByContact(String contact)throws GenericException;
    ResponseEntity<?> getByEmail(String email)throws GenericException;
    ResponseEntity<?> getByState(String state)throws GenericException;





}
