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
    private float discountRate;

    public OrderDetail() {
    }

    public OrderDetail(long orderDetailId, Order order, Product product, int unitPrice, int orderQuantity,
                       float discountRate) {
        this.orderDetailId = orderDetailId;
        this.order = order;
        this.product = product;
        this.unitPrice = unitPrice;
        this.orderQuantity = orderQuantity;
        this.discountRate = discountRate;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }
}
