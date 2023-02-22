package EmployeesCVS.model;

import lombok.Data;


import javax.persistence.*;



@Data
@Entity
@Table(name="Employees" )
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer phoneNumber;

    public Employees() {
    }

    public Employees(String name, String email, int phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }


    public Employees(Integer id, String name, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
