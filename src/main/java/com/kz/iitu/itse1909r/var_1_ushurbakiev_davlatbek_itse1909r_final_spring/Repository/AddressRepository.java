package com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Repository;

import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Address;
import com.kz.iitu.itse1909r.var_1_ushurbakiev_davlatbek_itse1909r_final_spring.Database.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Transactional(timeout = 10)
    @Query(value = "SELECT s from Address s")
    List<Address> getAll();

    @Transactional(timeout = 10)
    @Query("select u from #{#entityName} u  where u.id = ?1")
    Address getById(int id);
}
