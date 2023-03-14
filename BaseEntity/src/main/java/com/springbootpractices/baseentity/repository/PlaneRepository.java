package com.springbootpractices.baseentity.repository;

import com.springbootpractices.baseentity.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
