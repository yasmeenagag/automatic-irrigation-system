package com.banque.misr.irrigation.system.controller;

import com.banque.misr.irrigation.system.response.LandResponse;
import com.banque.misr.irrigation.system.service.LandService;
import com.banque.misr.irrigation.system.serviceimpl.LandServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes ={com.banque.misr.irrigation.system.service.LandService.class ,
        com.banque.misr.irrigation.system.controller.LandController.class})
public class LandRestControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    LandController landController ;
    @Autowired
    LandService landService;

    @Autowired
    LandServiceImpl landServiceImpl;

    @Test
    public void givenLands_whenGetLands_thenReturnJsonArray()
            throws Exception {

        mvc.perform(get("/api/land")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.businessResponse.content[0].id", is(1)));
    }

}
