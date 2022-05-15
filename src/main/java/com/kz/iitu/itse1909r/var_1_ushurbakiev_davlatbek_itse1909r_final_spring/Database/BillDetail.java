package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bill_details")
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "lab_cost")
    private Integer labCost;

    @Column(name = "doctor_cost")
    private Integer doctorCost;

    @Column(name = "insurance")
    private Integer insurance;


    @Column(name = "additional_pay")
    private Integer additionalPay;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "bills",
            joinColumns = @JoinColumn(name = "bill_detail_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> users;

    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_detail_id")
    private List<Bill> bills = new ArrayList<>();

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public Integer getAdditionalPay() {
        return additionalPay;
    }

    public void setAdditionalPay(Integer additionalPay) {
        this.additionalPay = additionalPay;
    }

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    public Integer getDoctorCost() {
        return doctorCost;
    }

    public void setDoctorCost(Integer doctorCost) {
        this.doctorCost = doctorCost;
    }

    public Integer getLabCost() {
        return labCost;
    }

    public void setLabCost(Integer labCost) {
        this.labCost = labCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BillDetail{" +
                "id=" + id +
                ", labCost=" + labCost +
                ", doctorCost=" + doctorCost +
                ", insurance=" + insurance +
                ", additionalPay=" + additionalPay +
                '}';
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}