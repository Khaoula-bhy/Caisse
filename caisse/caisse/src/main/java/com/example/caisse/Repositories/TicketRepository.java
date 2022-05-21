package com.example.caisse.Repositories;

import com.example.caisse.Models.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel,Long> {
}
