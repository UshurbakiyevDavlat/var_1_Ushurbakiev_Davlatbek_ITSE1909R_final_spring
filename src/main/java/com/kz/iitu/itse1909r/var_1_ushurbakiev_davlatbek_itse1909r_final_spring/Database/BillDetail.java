package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database;

import javax.persistence.*;

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

    //TODO Reverse Engineering! Migrate other columns to the entity
}