package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.BillDetail;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BillDetailsRepository extends JpaRepository<BillDetail,Long> {
    @Transactional(timeout = 10)
    @Query(value = "SELECT s from BillDetail s")
    List<BillDetail> getAll();

    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u  where u.id = ?1")
    BillDetail getById(int id);
}
