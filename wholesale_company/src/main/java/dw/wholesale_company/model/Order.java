package dw.wholesale_company.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "주문")
public class Order {  /*주문번호	고객번호	사원번호	주문일	요청일	발송일*/
    @Id
    @Column(name = "주문번호")
    private String orderId;
    @ManyToOne
    @JoinColumn(name = "고객번호")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "사원번호")
    private Employee employee;
    @Column(name = "주문일")
    private LocalDate orderDate;
    @Column(name = "요청일")
    private LocalDate requestDate;
    @Column(name = "발송일")
    private LocalDate shippingDate;

    public Order() {
    }

    public Order(String orderId, Customer customer, Employee employee, LocalDate orderDate, LocalDate requestDate,
                 LocalDate shippingDate) {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
