package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "사원")
public class Employee {  /*사원번호	이름	영문이름	직위	성별	생일	입사일	주소	도시	지역	집전화	상사번호	부서번호*/
    @Id
    @Column(name = "사원번호")
    private String employeeId;
    @Column(name = "이름")
    private String name;
    @Column(name = "영문이름")
    private String englishName;
    @Column(name = "직위")
    private String position;
    @Column(name = "성별")
    private String gender;
    @Column(name = "생일")
    private LocalDateTime birthDate;
    @Column(name = "입사일")
    private LocalDateTime hireDate;
    @Column(name = "주소")
    private String address;
    @Column(name = "도시")
    private String city;
    @Column(name = "지역")
    private String area;
    @Column(name = "집전화")
    private String telephoneNo;
    @Column(name = "상사번호")
    private String managerId;
    @Column(name = "부서번호")
    private String department;

    public Employee() {
    }

    public Employee(String employeeId, String name, String englishName, String position, String gender,
                    LocalDateTime birthDate, LocalDateTime hireDate, String address, String city, String area,
                    String telephoneNo, String managerId, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.englishName = englishName;
        this.position = position;
        this.gender = gender;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.area = area;
        this.telephoneNo = telephoneNo;
        this.managerId = managerId;
        this.department = department;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
