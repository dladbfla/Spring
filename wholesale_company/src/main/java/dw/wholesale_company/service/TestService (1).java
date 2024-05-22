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
    
    // 교사코멘트 : 2번에서 작은 실수를 하셨지만 전반적으로 아주 잘하셨습니다. 

    //1. 도시이름(city)을 매개변수로 받아 그 도시출신의 사원 정보를 보이시오.
    public List<Employee> getEmployeeByCity(String city) {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter(employee -> employee.getCity().equals(city)).collect(Collectors.toList());
    }

    //2. 주문번호를 매개변수(orderId)로 받아 주문한 고객의 정보를 보이시오.
    public Customer getCustomerByOrderId(String orderId) {
        Order orders = (Order) orderRepository.findAllById(Collections.singleton(orderId));
        // 교사코멘트 : findAllById는 정의를 찾아보시면 기본키 여러개를 매개변수로 전달하여 여러 정보를 리스트 형태로 리턴하는데 사용하는 메서드입니다. 이 경우에 적합한 메서드가 아닌데 사용하셨기 때문에 Collections.singleton같은 배열의 형태로 넣어주셔야 했을거에요. 이 코드를 만들어내느라 고생하셨을 것으로 생각됩니다. ^^ 만약 findById를 사용하셨다면 쉽게 해결하셨을 것 같습니다.
        Customer customers = (Customer) customerRepository.findAllById(Collections.singleton(orders.getCustomer()
                .getCustomerId()));
        return customers;

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
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().filter(employee -> employee.getPosition().equals(position)).collect(Collectors.toList());
        /*return employees.stream().filter(employee -> employee.getPosition().equals(position))
                .filter(employee -> employee.getBirthDate().getYear() <= year)
                .filter(employee -> employee.getBirthDate().getYear() >= year).collect(Collectors.toList());*/
        // 교사코멘트 : year를 이용하여 범위로 만들어내는 부분과 두개의 조건을 AND 연산자로 처리하는 부분을 미처 생각지못하신것 같습니다.
    }
}
