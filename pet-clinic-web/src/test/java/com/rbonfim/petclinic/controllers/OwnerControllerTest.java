package com.rbonfim.petclinic.controllers;

import com.rbonfim.petclinic.model.Owner;
import com.rbonfim.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.HashSet;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void index() throws Exception {
        when(ownerService.findAll()).thenReturn(new HashSet<Owner>());

        mockMvc.perform(get("/owners")).
                andExpect(status().is2xxSuccessful())
                .andExpect(view().name("owners/index"));

        mockMvc.perform(get("/owners/index")).
                andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attributeExists("owners"))
                .andExpect(model().attribute("owners", hasSize(0)));

    }

    @Test
    void find() throws Exception {

        mockMvc.perform(get("/owners/find")).
                andExpect(status().is2xxSuccessful())
                .andExpect(view().name("notimplemented"));
    }

    @Test
    public void showOwner() throws Exception {
        when(ownerService.findById(22L)).thenReturn(Owner.builder().id(33L).build());

        mockMvc.perform(get("/owners/22"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", hasProperty("id", is(33L))))
        ;

    }

    @Test
    void processFindFormReturnMany() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(
                Arrays.asList(Owner.builder().id(10L).build(),
                        Owner.builder().id(20L).build(),
                        Owner.builder().id(30L).build()));


        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("selections"))
                .andExpect(view().name("owners/ownersList"))
        ;
    }

    @Test
    void processFindFormReturnOne() throws Exception {
        when(ownerService.findAllByLastNameLike(anyString())).thenReturn(
                Arrays.asList(Owner.builder().id(10L).build()));

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/10"))
        ;
    }
}