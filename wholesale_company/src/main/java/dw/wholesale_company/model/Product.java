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

    public Product() {
    }

    public Product(long productId, String productName, String pkgUnit, int unitPrice, int inventory) {
        this.productId = productId;
        this.productName = productName;
        this.pkgUnit = pkgUnit;
        this.unitPrice = unitPrice;
        this.inventory = inventory;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPkgUnit() {
        return pkgUnit;
    }

    public void setPkgUnit(String pkgUnit) {
        this.pkgUnit = pkgUnit;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
