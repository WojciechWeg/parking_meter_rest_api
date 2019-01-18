package com.wojtek.parkingmeter.controllers;


import com.wojtek.parkingmeter.bootstrap.Bootstrap;
import com.wojtek.parkingmeter.helpers.enums.TicketType;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.model.TicketDTO;
import com.wojtek.parkingmeter.repositories.CarRepository;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import com.wojtek.parkingmeter.services.TicketService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketControllerStopTest {

    @Mock
    private TicketService ticketService;

    @InjectMocks
    private TicketController ticketController;

    @Mock
    private TicketRepository ticketRepository;

    private MockMvc mockMvc;

    @Before
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(ticketController).build();

    }

    // zrób test gdy nie ma biletu o takim id

    @Test
    public void shouldReturn200Status() throws Exception {

        // tutaj tworzysz ticket który nie ważny jaki by miał id to i tak nie ma znaczenia
        Ticket ticket1 = new Ticket();
        ticket1.setTicketType(TicketType.REGULAR);
        ticket1.setCharge(10.0);
        ticket1.setStampStart(LocalDateTime.now());
        ticket1.setStampStop(LocalDateTime.now());
        ticket1.setCar(null);
        Ticket ticket2 = ticketRepository.save(ticket1);

        // jaki byś id nie podał w /stop/xyz to zawsze dostanie status OK i TicketStopped
        // mimo że w postmanie dostaję status 204 i brak "Ticket stopped"

        this.mockMvc.perform(get("/stop/666"))
                .andExpect(status().is(200));
    }


}
