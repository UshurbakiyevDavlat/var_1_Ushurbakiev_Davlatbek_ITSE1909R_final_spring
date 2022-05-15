package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@NamedQueries(value = {
        @NamedQuery(name = "User.getUserById",
                query = "select s from User s " +
                        "inner join fetch s.role a " +
                        "where s.id = :id"
        )
})
public class User {

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 250)
    @Size(min = 4)
    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Size(max = 250)
    @Size(min = 4)
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;


    @JsonIgnore
    @Valid
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToMany(mappedBy = "users",cascade = CascadeType.ALL)
    Set<BillDetail> billDetails;

    @Column(name = "age")
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address", referencedColumnName = "id")
    private Address address;

    @Column(name = "status")
    private Integer status;


    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "doctor_id")
    private List<LabReport> labReports = new ArrayList<>();


    @JsonIgnore
    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<HealthHistory> healthHistories = new ArrayList<>();


    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Bill> bills = new ArrayList<>();

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Set<BillDetail> getBillDetails() {
        return billDetails;
    }

    public void setBillDetails(Set<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<HealthHistory> getHealthHistories() {
        return healthHistories;
    }

    public void setHealthHistories(List<HealthHistory> healthHistories) {
        this.healthHistories = healthHistories;
    }

    public List<LabReport> getLabReports() {
        return labReports;
    }

    public void setLabReports(List<LabReport> labReports) {
        this.labReports = labReports;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", deletedAt=" + deletedAt +
                ", role=" + role +
                ", age=" + age +
                ", status=" + status +
                '}';
    }
}