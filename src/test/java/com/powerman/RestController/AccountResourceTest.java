package com.powerman.RestController;

import static org.assertj.core.api.Assertions.assertThat;

import com.powerman.model.MainPowerProvider;
import com.powerman.model.UserAccount;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountResourceTest {
    @LocalServerPort
    private int port;

    private Client client = ClientBuilder.newClient();

    @Before
    public void setup() {
        URI resourceUri = UriBuilder.fromUri("http://localhost").port(port).path("account").build();
        client.target(resourceUri).request().post(Entity.json(333));
    }

    @Test
    public void canGetMainProviderAccount() {
        URI resourceUri = UriBuilder.fromUri("http://localhost").port(port).path("masterAccount").build();
        Response response = client.target(resourceUri).request().get();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(response.readEntity(UserAccount.class)).isEqualTo(new MainPowerProvider(100));
    }

    @Test
    public void canGetUserAccount() {
        URI resourceUri = UriBuilder.fromUri("http://localhost").port(port).path("account").path("333").build();
        Response response = client.target(resourceUri).request().get();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        assertThat(response.readEntity(UserAccount.class)).isEqualTo(new UserAccount(333));
    }

    @Test
    public void canPostNewUserAccount() {
        URI resourceUri = UriBuilder.fromUri("http://localhost").port(port).path("account").build();
        Response response = client.target(resourceUri).request().post(Entity.json(123));

        assertThat(response.getStatus()).isEqualTo(Response.Status.CREATED.getStatusCode());
        assertThat(response.getHeaderString(HttpHeaders.LOCATION))
                .isEqualTo(UriBuilder.fromUri(resourceUri).path("123").build().toString());
    }
}
