package dw.wholesale_company.service;

import dw.wholesale_company.model.Customer;
import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    @Autowired
    OrderRepository orderRepository;


    public List<Order> getOrderAll(){
        return orderRepository.findAll();
    }

    //1. 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOrderDate20210501(){
        List<Order> orders = orderRepository.findAll();
        List<Order> newOrders = new ArrayList<>();
        for (int i = 0; i<orders.size(); i++){
            if (orders.get(i).getOrderDate().compareTo(LocalDate.of(2021,05,01)) > 0){
                newOrders.add(orders.get(i));
            }
        }
        return newOrders;
    }
    //선생님 코드. 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOrderByDateAfter(LocalDate date) {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().filter(a -> a.getOrderDate().compareTo(date) > 0)
                .collect(Collectors.toList());
    }

    // 2020년 4월 9일에 주문한 고객의 모든 정보를 보이시오
    // 날짜를 매개변수로 처리
    public List<Customer> getCustomerByOrderDate(LocalDate orderDate) {
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        return orders.stream().map(order -> order.getCustomer()).collect(Collectors.toList());
    }

    //도시별로 주문금액합을 보이되 주문금액합이 많은 상위 5개의 도시에 대한 결과만 보이시오.
    public List<Object[]> getTopCitiesByTotalOrderAmount(int limit) {
        List<Object[]> cities = orderRepository.getTopCitiesByTotalOrderAmount();
        return cities.stream().limit(limit).collect(Collectors.toList());
//        return entityManager.createQuery(
//                        "SELECT c.city, SUM(od.orderQuantity * od.unitPrice) " +
//                                "FROM OrderDetail od " +
//                                "JOIN od.order o " +
//                                "JOIN o.customer c " +
//                                "GROUP BY c.city " +
//                                "ORDER BY SUM(od.orderQuantity * od.unitPrice) DESC")
//                .setMaxResults(limit)
//                .getResultList();
    }

    //‘서울특별시’ 고객들에 대해 주문년도별 주문건수를 보이시오
    public List<Object[]> getOrderCountByYearForCity(String city) {
        return orderRepository.getOrderCountByYearForCity(city);
    }
}
