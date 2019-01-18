package com.wojtek.parkingmeter.controllers;

import com.wojtek.parkingmeter.helpers.enums.TicketType;
import com.wojtek.parkingmeter.model.Ticket;
import com.wojtek.parkingmeter.repositories.TicketRepository;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketControllerHasStartedTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnNO() throws Exception {
        this.mockMvc.perform(get("/hasStarted/WN321"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"hasStarted\": \"NO\"\n" +
                        "}"));
    }

    @Test
    public void shouldReturnYES() throws Exception {

        this.mockMvc.perform(get("/start/REGULAR/WN321"));

        this.mockMvc.perform(get("/hasStarted/WN321"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"hasStarted\": \"YES\"\n" +
                        "}"));
    }

    @Test
    public void shouldReturnINVALID_NR_PLATE() throws Exception {
        this.mockMvc.perform(get("/hasStarted/WN32144"))
                .andExpect(status().is(400))
                .andExpect(content().json("{\n" +
                        "    \"hasStarted\": \"INVALID_NR_PLATE\"\n" +
                        "}"));

    }


    //gdy tablica rejestracyjna jest ok, ale nie ma takiej w db

}
