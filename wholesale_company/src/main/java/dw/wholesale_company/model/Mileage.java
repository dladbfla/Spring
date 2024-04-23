package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "마일리지등급")
public class Mileage {  /*등급명	하한마일리지	상한마일리지*/
    @Id
    @Column(name = "등급명")
    private String mileageGrade;
    @Column(name = "하한마일리지")
    private int lowLimit;
    @Column(name = "상한마일리지")
    private int highLimit;

    public Mileage() {
    }

    public Mileage(String mileageGrade, int lowLimit, int highLimit) {
        this.mileageGrade = mileageGrade;
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    public String getMileageGrade() {
        return mileageGrade;
    }

    public void setMileageGrade(String mileageGrade) {
        this.mileageGrade = mileageGrade;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(int lowLimit) {
        this.lowLimit = lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }

    public void setHighLimit(int highLimit) {
        this.highLimit = highLimit;
    }
}
