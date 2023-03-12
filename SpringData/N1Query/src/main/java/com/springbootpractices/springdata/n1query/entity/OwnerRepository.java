package com.springbootpractices.springdata.n1query.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o LEFT JOIN FETCH o.cars")
    List<Owner> findAllWithOneQuery();
}
