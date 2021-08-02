package academy.everyonecodes.java.controller;

import academy.everyonecodes.java.data.ProfileDTO;
import academy.everyonecodes.java.data.User;
import academy.everyonecodes.java.service.ProfileDTOService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProfileDTOEndpointTest
{
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProfileDTOService profileDTOService;

    @Test
    void get()
    {
        restTemplate.getForObject("/profile", ProfileDTO.class, new User());
        Mockito.verify(profileDTOService.get(new User()));
    }
}