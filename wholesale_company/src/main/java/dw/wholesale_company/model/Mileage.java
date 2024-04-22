package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "마일리지등급")
public class Mileage {  /*등급명	하한마일리지	상한마일리지*/
    @Id
    @Column(name = "등급")
    private String mileageGrade;
    @Column(name = "하한마일리지")
    private int lowLimit;
    @Column(name = "상한마일리지")
    private int highLimit;
}
