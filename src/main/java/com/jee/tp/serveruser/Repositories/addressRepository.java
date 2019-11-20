package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface addressRepository extends JpaRepository<Address, Long> {
}
