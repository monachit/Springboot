package com.example.tp3.dao;

import com.example.tp3.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandDao extends JpaRepository<Command, Long> {

    Command findByReference(String reference);

}
