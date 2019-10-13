package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Toy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface toyRepository extends JpaRepository<Toy, Long>,toyCustomRepository, PagingAndSortingRepository<Toy, Long> {


   List<Toy> findByPriceLessThan(double price);
    @Query("FROM Toy WHERE name like ?1")
    List<Toy> findByNameSorted(String Name, Sort sort);


}