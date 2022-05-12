package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.HealthHistory;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BillsRepository extends JpaRepository<Bill,Long> {
    @Transactional(timeout = 10)
    @Query(value = "SELECT s from Bill s inner join fetch s.billDetail inner join fetch s.user")
    List<Bill> getAll();

    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u  inner join fetch u.billDetail a inner join fetch u.user d where u.id = ?1")
    Bill getById(int id);

}
