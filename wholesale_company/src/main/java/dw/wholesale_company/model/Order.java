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

}
