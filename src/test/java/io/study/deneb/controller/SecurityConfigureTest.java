package io.study.deneb.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SecurityConfigureTest {

  @Autowired
  WebApplicationContext context;

  MockMvc mockMvc;

  @BeforeEach
  void init() {
    mockMvc = MockMvcBuilders
      .webAppContextSetup(context)
      .apply(SecurityMockMvcConfigurers.springSecurity())
      .build();
  }

  @Test
  void shouldBeUnauthorizedWhenNoAuth() throws Exception {
    mockMvc.perform(
      get("/user").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isUnauthorized());
  }

  @WithMockUser(username = "deneb", roles = {"USER"})
  @Test
  void shouldBeOkWhenUserAuth() throws Exception {
    mockMvc.perform(
        get("/user").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

  @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
  @Test
  void shouldBeOkWhenAdminAuth() throws Exception {
    mockMvc.perform(
        get("/admin").contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }


}