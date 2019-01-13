package com.wojtek.parkingmeter.repositories;

import com.wojtek.parkingmeter.model.Ticket;
import org.springframework.data.repository.CrudRepository;


public interface TicketRepository extends CrudRepository<Ticket,Long> {
}
