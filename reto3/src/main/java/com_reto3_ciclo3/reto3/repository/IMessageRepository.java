package com_reto3_ciclo3.reto3.repository;

import com_reto3_ciclo3.reto3.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository<Message,Integer> {
}
