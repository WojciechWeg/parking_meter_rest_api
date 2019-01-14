package com.wojtek.parkingmeter.mapper;

import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.model.TicketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO ticketToTicketDTO(Ticket ticket);

    Ticket ticketDTOToTocket(TicketDTO ticketDTO);

}
