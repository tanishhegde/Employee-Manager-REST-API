package Project.EmployeeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import jakarta.validation.Valid;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeManager employeeManager;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeManager.getAllEmployees());
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeManager.addEmployee(employee));
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeManager.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id, @Valid @RequestBody Employee updatedEmployee) {
        Employee employee = employeeManager.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeManager.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok("Employee with ID " + id + " updated successfully.");
    }
    
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) {
        Employee employee = employeeManager.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        employeeManager.deleteEmployee(id);
        return ResponseEntity.ok("Employee with ID " + id + " deleted successfully.");
    }
}