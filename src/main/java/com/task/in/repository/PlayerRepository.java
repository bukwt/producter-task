package com.task.in.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.in.model.Player;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {



}
