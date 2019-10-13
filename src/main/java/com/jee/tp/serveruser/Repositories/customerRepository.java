package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@RepositoryRestResource
public interface customerRepository extends JpaRepository<Customer, Long>, PagingAndSortingRepository<Customer, Long>{
    //Example Pageable
    @Query(nativeQuery = true, value = "select * from Customer c order by Id \n-- #pageable\n",
    countQuery = "select count(*) from Customer")
    Page<Customer> findBirthDayBefore(@Param("birthday") LocalDate bithday, Pageable pageable);

}
