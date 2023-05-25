package com.empolyee.manage.service.impl;

import com.empolyee.manage.entity.Employee;
import com.empolyee.manage.exception.GenericException;
import com.empolyee.manage.repo.EmployeeRepo;
import com.empolyee.manage.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public ResponseEntity<?> addEmployee(Employee employee)throws GenericException {
        employee.setId(0);
        employee.setCreatedDate(new Date());
        var employees=employeeRepo.save(employee);
        if(employees==null)
            throw new GenericException(HttpStatus.NO_CONTENT.value(),"Employee not save something went wrong");
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<?> getAllEmployee()throws GenericException{
        var employees=employeeRepo.findAll();
        if(employees.isEmpty())
            throw new GenericException(HttpStatus.NO_CONTENT.value(),"Employee not find something went wrong");
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<?> deleteEmployeeById(long id)throws GenericException {
        var employees = employeeRepo.findById(id).orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),"Given id not found with id "+id));
         employeeRepo.deleteById(id);
       return ResponseEntity.ok(employees);
    }
    @Override
    public ResponseEntity<?> getByIdEmployee(long id)throws GenericException {
            var employees = employeeRepo.findById(id).orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),"Given id not found with id "+id));
            return ResponseEntity.ok(employees);
    }
    @Override
    public ResponseEntity<?> updateEmployee(Employee employee, long id)throws GenericException {
        var employees = employeeRepo.findById(id).orElseThrow(()->new GenericException(HttpStatus.NOT_FOUND.value(),"Given id not found with id "+id));
        employee.setId(id);
       employee.getAddress().setId(employees.getId());
        employee.setCreatedDate(new Date());
        employees=employeeRepo.save(employee);
        if(employees==null)
            throw new GenericException(HttpStatus.NO_CONTENT.value(),"Employee not save something went wrong");
        return ResponseEntity.ok(employees);

    }

    /**
     * Line no 71 to 98 for custom query method.........................................
     * @param name
     * @return
     * @throws GenericException
     */
    @Override
    public ResponseEntity<?> findEmployeeByName(String name)throws GenericException {
        var em= employeeRepo.findByName(name);
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Given name is not math with database name"+name);
        return ResponseEntity.status(HttpStatus.OK).body(em);
    }
    @Override
    public ResponseEntity<?> findEmployeeByCity(String city)throws GenericException {
       var em=employeeRepo.findByCity(city);
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Given city is not math with database name"+city);
        return ResponseEntity.status(HttpStatus.OK).body(em);
    }
    @Override
    public ResponseEntity<?> findEmployeeByContact(String contact)throws GenericException {
        var em=employeeRepo.findByContact(contact);
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Given contact is not math with database name"+contact);
        return ResponseEntity.status(HttpStatus.OK).body(em);
    }
    @Override
    public ResponseEntity<?> findEmployeeByEmail(String email)throws GenericException {
        var em=employeeRepo.findByEmail(email);
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Given email is not math with database name"+email);
        return ResponseEntity.status(HttpStatus.OK).body(em);
    }




    /**
     * Sorting one by one Attribute.............................................
     */
    @Override
    public ResponseEntity<?> getByIdAsc() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"employee data not found");
        em=em.stream().sorted(Comparator.comparing(Employee::getId)).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByIdDesc() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"employee data not found");
        em=em.stream().sorted(Comparator.comparing(Employee::getId).reversed()).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }
    @Override
    public ResponseEntity<?> getByNameAscendingOrder() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByNameDescendingOrder() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByCityAscendingOrder() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getCity)).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByCityDescendingOrder() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getCity).reversed()).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByContactAscendingOrder() throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getContact)).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getByContactDescendingOrder() throws GenericException{
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getContact).reversed()).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getBySalaryAscendingOrder()throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }

    @Override
    public ResponseEntity<?> getBySalaryDescendingOrder() throws GenericException{
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found");
        em=em.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
        return ResponseEntity.ok(em);
    }


    /**
     * Employee data filtering.....................
     */

    @Override
    public ResponseEntity<?> getByName(String name) throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found with given name "+name);
        List<Employee> employees=em.stream().filter(employee -> employee.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);

    }

    @Override
    public ResponseEntity<?> getByCity(String city) throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found with given name "+city);
        List<Employee> employees=em.stream().filter(employee -> employee.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<?> getByContact(String contact) throws GenericException {
          var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found with given name "+contact);
        List<Employee> employees=em.stream().filter(employee -> employee.getContact().equalsIgnoreCase(contact)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<?> getByEmail(String email) throws GenericException {
          var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found with given name "+email);
        List<Employee> employees=em.stream().filter(employee -> employee.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }

    @Override
    public ResponseEntity<?> getByState(String state) throws GenericException {
        var em=employeeRepo.findAll();
        if(em.isEmpty())
            throw new GenericException(HttpStatus.NOT_FOUND.value(),"Employee Not Found with given name "+state);
        List<Employee> employees=em.stream().filter(employee -> employee.getAddress().getState().equalsIgnoreCase(state)).collect(Collectors.toList());
        return ResponseEntity.ok(employees);
    }


}




