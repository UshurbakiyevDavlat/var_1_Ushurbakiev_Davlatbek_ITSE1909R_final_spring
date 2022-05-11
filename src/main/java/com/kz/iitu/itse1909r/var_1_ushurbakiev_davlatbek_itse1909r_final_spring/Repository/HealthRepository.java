package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HealthRepository extends JpaRepository<HealthHistory,Long> {
    @Transactional(timeout = 10)
    @Query(value = "SELECT s from HealthHistory s inner join fetch s.user a inner join fetch s.doctor d")
    List<HealthHistory> getAll();

    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u  inner join fetch u.user a inner join fetch u.doctor d where u.id = ?1")
    List<HealthHistory> getById(int id);

    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u  inner join fetch u.user a inner join fetch u.doctor d where u.title = ?1")
    List<HealthHistory> getByTitle(String title);
}
