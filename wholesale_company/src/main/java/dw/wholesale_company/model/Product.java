package dw.wholesale_company.model;

import jakarta.persistence.*;

@Entity
@Table(name = "제품")
public class Product {  /*제품번호	제품명	포장단위	단가	재고*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "제품번호")
    private long productId;
    @Column(name = "제품명")
    private String productName;
    @Column(name = "포장단위")
    private String pkgUnit;
    @Column(name = "단가")
    private int unitPrice;
    @Column(name = "재고")
    private int inventory;
}
