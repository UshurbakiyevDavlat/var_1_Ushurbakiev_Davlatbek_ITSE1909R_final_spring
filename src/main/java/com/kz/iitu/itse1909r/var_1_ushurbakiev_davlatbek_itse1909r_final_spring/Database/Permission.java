package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    @Column(name = "perm_interact_patients")
    private Integer permInteractPatients;

    @Column(name = "perm_access_health_history")
    private Integer permAccessHealthHistory;

    @Column(name = "perm_redact")
    private Integer permRedact;

    @Column(name = "perm_delete")
    private Integer permDelete;

    @Column(name = "perm_view")
    private Integer permView;

    public Integer getPermView() {
        return permView;
    }

    public void setPermView(Integer permView) {
        this.permView = permView;
    }

    public Integer getPermDelete() {
        return permDelete;
    }

    public void setPermDelete(Integer permDelete) {
        this.permDelete = permDelete;
    }

    public Integer getPermRedact() {
        return permRedact;
    }

    public void setPermRedact(Integer permRedact) {
        this.permRedact = permRedact;
    }

    public Integer getPermAccessHealthHistory() {
        return permAccessHealthHistory;
    }

    public void setPermAccessHealthHistory(Integer permAccessHealthHistory) {
        this.permAccessHealthHistory = permAccessHealthHistory;
    }

    public Integer getPermInteractPatients() {
        return permInteractPatients;
    }

    public void setPermInteractPatients(Integer permInteractPatients) {
        this.permInteractPatients = permInteractPatients;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}