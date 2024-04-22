package dw.wholesale_company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "주문세부")
public class OrderDetail {  /*주문번호	제품번호	단가	주문수량	할인율*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="주문세부번호")
    private long orderDetailId;
    @ManyToOne
    @JoinColumn(name = "주문번호",nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "제품번호",nullable = false)
    private Product product;
    @Column(name = "단가")
    private int unitPrice;
    @Column(name = "주문수량")
    private int orderQuantity;
    @Column(name = "할인율")
    private int discountRate;
}
