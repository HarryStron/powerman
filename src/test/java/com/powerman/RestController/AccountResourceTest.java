package com.powerman.RestController;

import static org.mockito.BDDMockito.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(AccountResource.class)
public class AccountResourceTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountResource accountResourceMock;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void canPOST() throws Exception {
        given(accountResourceMock.createAccount(123)).willReturn(Response.created(UriBuilder.fromPath("/123").build()).build());

        mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, "/account")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content("{\t\"accountId\": \"123\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
