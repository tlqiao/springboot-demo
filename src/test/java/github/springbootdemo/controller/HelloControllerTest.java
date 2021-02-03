package github.springbootdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getHello() throws Exception {
    MvcResult result =mockMvc.perform(MockMvcRequestBuilders.get("/")
            .accept(MediaType.APPLICATION_JSON))
            .andReturn();
    System.out.println(result.getResponse().getContentAsString());

    }
}
