package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "주문")
public class Order {  /*주문번호	고객번호	사원번호	주문일	요청일	발송일*/
    @Id
    @Column(name = "주문번호")
    private String orderId;
    @Column(name = "고객번호")
    private String customer;
    @Column(name = "사원번호")
    private String employee;
    @Column(name = "주문일")
    private LocalDateTime orderDate;
    @Column(name = "요청일")
    private LocalDateTime requestDate;
    @Column(name = "발송일")
    private LocalDateTime shippingDate;

    public Order() {
    }

    public Order(String orderId, String customer, String employee, LocalDateTime orderDate, LocalDateTime requestDate,
                 LocalDateTime shippingDate) {
        this.orderId = orderId;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.requestDate = requestDate;
        this.shippingDate = shippingDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }
}
