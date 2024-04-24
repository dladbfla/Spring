package dw.wholesale_company.service;

import dw.wholesale_company.exception.ResourceNotFoundException;
import dw.wholesale_company.model.Employee;
import dw.wholesale_company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeAll(){
        return employeeRepository.findAll();
    }

    //3. 사원의 직위가 '사원'인 사람들 중에서 가장 최근에 입사한 사원의 정보
    public Employee getEmployeeRecentlyHired(){
        List<Employee> employees = employeeRepository.findAll();
        List<Employee> newemployees = new ArrayList<>();
        for(int i = 0; i<employees.size(); i++){
            if(employees.get(i).getPosition().equals("사원")){
                newemployees.add(employees.get(i));
            }
        }
        Employee Min = newemployees.get(0);
        for (int j = 0; j<newemployees.size(); j++){
            if (Min.getHireDate().compareTo(newemployees.get(j).getHireDate()) <0){
                Min = newemployees.get(j);
            }
        }
        return Min;
    }

    //선생님코드. 사원의 직위가 '사원'인 사람들 중에서 가장 최근에 입사한 사원의 정보
    public Employee getEmployeeByHireLatest() {
        return employeeRepository.findAll()
                .stream().filter(e -> e.getPosition().equals("사원"))
                .sorted(Comparator.comparing(Employee::getHireDate).reversed())
                .findFirst().get();
    }

}
