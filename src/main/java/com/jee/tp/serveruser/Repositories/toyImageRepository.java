package com.jee.tp.serveruser.Repositories;

import com.jee.tp.serveruser.Models.toyImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface toyImageRepository extends JpaRepository<toyImage, String> {
}
