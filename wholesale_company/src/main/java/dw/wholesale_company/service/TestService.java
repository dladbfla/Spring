package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Employee;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.CustomerRepository;
import dw.wholesale_company.repository.EmployeeRepository;
import dw.wholesale_company.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;

    //1. 도시이름(city)을 매개변수로 받아 그 도시출신의 사원 정보를 보이시오.
    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter(employee -> employee.getCity().equals(city)).collect(Collectors.toList());
    }

    //2. 주문번호를 매개변수(orderId)로 받아 주문한 고객의 정보를 보이시오.
    public Customer getCustomerByOrderId(String orderId) {
        return orderRepository.findById(orderId).get().getCustomer();
    }

    //3. 주문년도(orderYear)를 매개변수로 받아 그 해의 주문건수(int)를 보이시오.
    public int getOrderNumByOrderYear(int orderYear) {
        List<Order> orders = orderRepository.findAll();
        List<Order> newOrders = new ArrayList<>();
        for (int i = 0; i < orders.size(); i++){
            if (orders.get(i).getOrderDate().getYear() == orderYear){
                newOrders.add(orders.get(i));
            }
        }
        return newOrders.size();
    }

    //4. 직위(position)와 나이대(year)를 매개변수로 받아 해당정보에 맞는 사원들의 정보를 보이시오.
    // 예를 들어 20대는 매개변수 year=20 이고 나이가 20살이상 30살미만을 의미함.
    // 나이계산은 (올해 - 태어난해)로 계산.
    public List<Employee> getEmployeeByPositionAndYear(String position, int year) {
        return employeeRepository.findAll().stream()
                .filter((Employee e)->e.getPosition().equals(position)
                        && LocalDate.now().getYear() - e.getBirthDate().getYear() >= year
                        && LocalDate.now().getYear() - e.getBirthDate().getYear() < year+10)
                .collect(Collectors.toList());
    }
}
