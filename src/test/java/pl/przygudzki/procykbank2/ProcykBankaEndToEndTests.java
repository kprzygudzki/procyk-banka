package pl.przygudzki.procykbank2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProcykBankaEndToEndTests {

	@Autowired
	private MockMvc mvc;

//	@Autowired
//	private DbCleaner dbCleaner;

//	@Autowired
//	private ObjectMapper objectMapper;

//	@Before
//	public void cleanDb() {
//		dbCleaner.clean();
//	}

	@Test
	public void transactionHandlingTest() throws Exception {
		mvc.perform(post("/transactions")
				.param("who", "zaargh")
				.param("amount", "15")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		mvc.perform(get("/account/zaargh"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.balance").value(15.0));

		mvc.perform(post("/transactions")
				.param("who", "zaargh")
				.param("amount", "10")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		mvc.perform(get("/account/zaargh"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.balance").value(25.0));

		mvc.perform(post("/transactions")
				.param("who", "zaargh")
				.param("amount", "-5")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		mvc.perform(get("/account/zaargh"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.balance").value(20.0));

		fail("Finish the test, mothafucka");
	}

}
