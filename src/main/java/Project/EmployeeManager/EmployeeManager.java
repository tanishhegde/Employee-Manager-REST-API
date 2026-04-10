package Project.EmployeeManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeManager 
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(String id, Employee updatedEmployee) {
        updatedEmployee.setEmployee_id(id);
        return employeeRepository.save(updatedEmployee);
    }


    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElse(null);
    }
}

    
