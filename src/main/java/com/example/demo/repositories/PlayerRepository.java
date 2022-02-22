package com.example.demo.repositories;

import com.example.demo.entity.Guild;
import com.example.demo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findByName(String name);
    boolean existsPlayerByName(String name);
}