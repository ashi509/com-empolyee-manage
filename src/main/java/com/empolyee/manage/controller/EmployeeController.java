package com.empolyee.manage.controller;

import com.empolyee.manage.entity.Employee;
import com.empolyee.manage.exception.GenericException;
import com.empolyee.manage.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
private EmployeeService employeeService;


    @PostMapping("/post")
    ResponseEntity<?> addEmployee(@Valid @RequestBody  Employee employee)throws GenericException {
        return employeeService.addEmployee(employee);
    }
    @GetMapping("/all")
    ResponseEntity<?> getAllEmployee()throws GenericException{
        return  employeeService.getAllEmployee();
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteEmployeeById(@PathVariable long id)throws GenericException{
    return employeeService.deleteEmployeeById(id);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> getByIdEmployee(@PathVariable long id)throws GenericException{
        return employeeService.getByIdEmployee(id);
    }
    @PutMapping("/{id}")
    ResponseEntity<?> updateEmployee(@Valid @RequestBody Employee employee, @PathVariable long id)throws GenericException {
        return employeeService.updateEmployee(employee, id);
    }

    /**
     * custom finder method
     * @param city
     * @return
     * @throws GenericException
     */
    @GetMapping("/city/{city}")
    ResponseEntity<?> findEmployeeByCity(@PathVariable String city)throws GenericException{
        return employeeService.findEmployeeByCity(city);
    }
    @GetMapping("/contact/{contact}")
    ResponseEntity<?> findEmployeeByContact(@PathVariable String contact)throws GenericException{
        return employeeService.findEmployeeByContact(contact);
    }
    @GetMapping("/email/{email}")
    ResponseEntity<?> findEmployeeByEmail(@PathVariable String email)throws GenericException{
        return employeeService.findEmployeeByEmail(email);
    }
    @GetMapping("/name/{name}")
    ResponseEntity<?> findEmployeeByName(@PathVariable String name)throws GenericException{
        return employeeService.findEmployeeByName(name);
    }

    /**
     * Sorting methode
     * @return
     * @throws GenericException
     *
     */
    @GetMapping("/id/asc")
    ResponseEntity<?>getByIdAsc()throws GenericException{
        return employeeService.getByIdAsc();
    }
    @GetMapping("/id/desc")
    ResponseEntity<?>getByIdDesc()throws GenericException{
        return employeeService.getByIdDesc();
    }
    @GetMapping("/name/asc")
    ResponseEntity<?> getByNameAscendingOrder()throws GenericException{
        return employeeService.getByNameAscendingOrder();
    }
    @GetMapping("/name/desc")
    ResponseEntity<?> getByNameDescendingOrder()throws GenericException{
        return employeeService.getByNameDescendingOrder();
    }
    @GetMapping("/city/asc")
    ResponseEntity<?> getByCityAscendingOrder()throws GenericException{
        return employeeService.getByCityAscendingOrder();
    }
    @GetMapping("/city/desc")
    ResponseEntity<?> getByCityDescendingOrder()throws GenericException{
        return employeeService.getByCityDescendingOrder();
    }
    @GetMapping("/contact/asc")
    ResponseEntity<?> getByContactAscendingOrder()throws GenericException{
        return employeeService.getByContactAscendingOrder();
    }
    @GetMapping("/contact/desc")
    ResponseEntity<?> getByContactDescendingOrder()throws GenericException{
        return employeeService.getByContactDescendingOrder();
    }
    @GetMapping("/salary/asc")
    ResponseEntity<?> getBySalaryAscendingOrder()throws GenericException{
        return employeeService.getBySalaryAscendingOrder();
    }
    @GetMapping("/salary/desc")
    ResponseEntity<?> getBySalaryDescendingOrder()throws GenericException{
        return employeeService.getBySalaryDescendingOrder();
    }

    /**
     * Employee data filtering.....................
     *  There is optional methode of data filtering
     *  use only one for  data filter
     *  1... custom finder methode
     *  2... filter methode
     *
     */
/*
   @GetMapping("/name/{name}")
    ResponseEntity<?> getByName(@PathVariable  String name)throws GenericException{
       return employeeService.getByName(name);
   }
   @GetMapping("/city/{city}")
    ResponseEntity<?> getByCity(@PathVariable String city)throws GenericException{
       return employeeService.getByCity(city);
   }
   @GetMapping("/contact/{contact}")
    ResponseEntity<?> getByContact(@PathVariable String contact)throws GenericException{
       return employeeService.getByContact(contact);
   }
   @GetMapping("/email/{email}")
    ResponseEntity<?> getByEmail(@PathVariable String email)throws GenericException{
       return employeeService.getByEmail(email);
   }*/
   @GetMapping("/state/{state}")
    ResponseEntity<?> getByState(String state)throws GenericException{
       return employeeService.getByState(state);
   }

}
