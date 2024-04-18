package dw.firstapp.controller;

import dw.firstapp.model.Employee;
import dw.firstapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    // @Autowired //필드 주입
    EmployeeService employeeService;

    // 매개변수를 사용한 생성자
    @Autowired //생성자 의존성주입(권장하는 방법!! @Autowired를 생략해도 의존성주입 됨)
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/api/employee") //직원 생성
    public Employee saveEmployee(@RequestBody Employee employee){
        // Service   //service로 던짐
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/api/employees")  // 직원 전체 조회
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/api/employee/{id}")  // 아이디로 직원 한명 조회
    public Employee getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/api/employee/{id}") // 업데이트
    public Employee updateEmployeeById(@PathVariable long id, @RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping("/api/employee/{id}")  //삭제
    public Employee deleteEmployeeById(@PathVariable long id){
        return employeeService.deleteEmployeeById(id);
    }
}
