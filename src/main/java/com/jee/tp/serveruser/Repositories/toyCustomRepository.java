package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Toy;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;
@Repository
public interface toyCustomRepository {
    @Query("select t from Toy t where t.name = :name and t.type = :type")
   Stream<Toy> findByNameAndTypeAsStream(@Param("name") String name, @Param("type") String type);


    Optional<Toy> findByNameOrType(String name, String type);

}
