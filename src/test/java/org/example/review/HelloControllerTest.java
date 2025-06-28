package org.example.review;

import org.junit.jupiter.api.Test;
import server.Server;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {
    @Test
    void serverShouldNotBeNull() {
        Server server = new Server();
        assertNotNull(server);
    }

}