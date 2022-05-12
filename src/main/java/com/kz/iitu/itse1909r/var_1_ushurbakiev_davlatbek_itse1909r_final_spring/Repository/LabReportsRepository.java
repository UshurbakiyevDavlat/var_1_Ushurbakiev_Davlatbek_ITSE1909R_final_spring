package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.LabReport;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LabReportsRepository extends JpaRepository<LabReport,Long> {
    @Transactional(timeout = 10)
    @Query(value = "SELECT s from LabReport s inner join fetch s.doctor a inner join fetch s.health h")
    List<LabReport> getAll();


    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u inner join fetch u.doctor a inner join fetch u.health h where u.id = ?1")
    LabReport getById(int id);
}
