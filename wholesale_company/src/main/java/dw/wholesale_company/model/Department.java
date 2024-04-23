package dw.wholesale_company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "부서")
public class Department {  /*부서번호	부서명*/
    @Id
    @Column(name = "부서번호")
    private String departId;
    @Column(name = "부서명")
    private String departName;

    public Department() {
    }

    public Department(String departId, String departName) {
        this.departId = departId;
        this.departName = departName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
}
