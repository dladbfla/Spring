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
}
