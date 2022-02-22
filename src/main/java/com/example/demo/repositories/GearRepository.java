package com.example.demo.repositories;

import com.example.demo.entity.Gear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearRepository extends JpaRepository<Gear, Long> {

}