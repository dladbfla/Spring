package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "고객")
public class Customer {     /*고객번호	고객회사명	담당자명	담당자직위	주소	도시	지역	전화번호	마일리지*/
    @Id
    @Column(name = "고객번호")
    private String customerId;
    @Column(name = "고객회사명")
    private String customerName;
    @Column(name = "담당자명")
    private String customerEmployee;
    @Column(name = "담당자직위")
    private String employeeTitle;
    @Column(name = "주소")
    private String address;
    @Column(name = "도시")
    private String city;
    @Column(name = "지역")
    private String area;
    @Column(name = "전화번호")
    private String phoneNumber;
    @Column(name = "마일리지")
    private int mileage;
}
