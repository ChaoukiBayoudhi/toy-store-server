package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerLikesRepository extends JpaRepository<Customer,Long>{

}