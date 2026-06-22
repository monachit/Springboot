package com.example.tp3.dao;

import com.example.tp3.entity.CommandStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandStatusDao extends JpaRepository<CommandStatus, Long> {
     CommandStatus findByStatus(String status);
}
