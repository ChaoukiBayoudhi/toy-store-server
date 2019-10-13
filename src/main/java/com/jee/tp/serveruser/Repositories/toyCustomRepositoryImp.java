package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.Toy;

import java.util.Optional;
import java.util.stream.Stream;

public class toyCustomRepositoryImp implements toyCustomRepository {
    @Override
    public Stream<Toy> findByNameAndTypeAsStream(String name, String type) {
        return Stream.empty();
   }

    @Override
    public Optional<Toy> findByNameOrType(String name, String type) {
        return Optional.empty();
    }
}
