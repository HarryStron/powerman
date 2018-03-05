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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


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
        mockMvc.perform(post("/clients").contentType(MediaType.APPLICATION_JSON)); //TODO need to move to another PC fix that after pull
    }
}
