package com.example.hobbyist.hobbyist;

import com.example.hobbyist.hobbyist.models.ApplicationUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationUserController applicationUserController;

	@Test
	void contextLoads() {

	}
//Code Review
// More Tests are needed, such as testing getters and integration testing
	@Test
	public void shouldHaveAGoodHomePage() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Welcome to Our Page, [[${username}]] please sign up to have access</h1>")))
				.andExpect(content().string(containsString("<h1>Welcome to Our Page, [[${username}]] please sign up to have access</h1>")))
				.andExpect(content().string(containsString("<form action=\"/signup\" method=\"POST\">")));
	}

}