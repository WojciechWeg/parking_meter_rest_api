package com.wojtek.parkingmeter.repositories;

import com.wojtek.parkingmeter.modelDAO.TicketDAO;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<TicketDAO,Long> {
}
