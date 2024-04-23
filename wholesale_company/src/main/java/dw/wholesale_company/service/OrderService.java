package dw.wholesale_company.service;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrderAll(){
        return orderRepository.findAll();
    }

    //1. 주문일이 2021년 5월 1일 이후인 주문 정보 얻기
    public List<Order> getOrderDate20210501(){
        List<Order> orders = orderRepository.findAll();
        List<Order> newOrders = new ArrayList<>();
        for (int i = 0; i<orders.size(); i++){
            if (orders.get(i).getOrderDate().compareTo(LocalDate.of(2021,05,01)
                    .atStartOfDay()) > 0){
                newOrders.add(orders.get(i));
            }
        }
        return newOrders;
    }

}
