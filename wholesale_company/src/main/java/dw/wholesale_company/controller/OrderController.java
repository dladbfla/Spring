package dw.wholesale_company.controller;

import dw.wholesale_company.model.Order;
import dw.wholesale_company.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrderAll(){
        return new ResponseEntity<>(orderService.getOrderAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/date20210501")
    public ResponseEntity<List<Order>> getOrderDate20210501(){
        return new ResponseEntity<>(orderService.getOrderDate20210501(), HttpStatus.OK);
    }
}
