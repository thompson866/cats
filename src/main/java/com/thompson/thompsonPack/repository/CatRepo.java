package com.thompson.thompsonPack.repository;


import com.thompson.thompsonPack.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepo  extends JpaRepository<Cat, Integer> {
}
