package pl.przygudzki.procykbank2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

//	@Test
//	public void transaction() throws Exception {
//		mvc.perform(post())
//	}

	@Test
	public void transactionHandlingTest() throws Exception {

		/*
		 * Psotnick wants to order a burrito.
		 * Psotnick is nice enough to order a burrito for his friend, Zaargh, as well.
		 * Psotnick payed 15 zlotys for Zaargh's burrito.
		 * Psotnick wants to register Zaargh's transaction with ProcykBanka.
		 * Psotnick sends a POST request to /transactions endpoint.
		 */
		mvc.perform(post("/transactions")
				.param("who", "zaargh")
				.param("amount", "-15")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		/*
		 * Psotnick wants to ensure that his transaction was registered.
		 * Psotnick checks the balance of Zaargh's account.
		 * Psotnick sends a GET request to /account/zaargh endpoint.
		 */
		mvc.perform(get("/account/zaargh"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.balance").value(BigDecimal.valueOf(-15.0)));

		/*
		 * Psotnick bought Zaargh a burrito and burrito is 15 zł behind.
		 * But Psotnick should also be 15 zł ahead.
		 * Psotnick wants to register his transaction with ProcykBanka.
		 * Psotnick sends a POST request to /transactions endpoint.
		 */
		mvc.perform(post("/transactions")
				.param("who", "psotnick")
				.param("amount", "15")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

		/*
		 * Psotnick wants to ensure that his transaction was registered as well.
		 * Psotnick checks the balance on his own account.
		 * Psotnick sends a GET request to /account/psotnick endpoint.
		 */
		mvc.perform(get("/account/posotnick"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.balance").value(BigDecimal.valueOf(15.0)));

//		mvc.perform(post("/transactions")
//				.param("who", "zaargh")
//				.param("amount", "20")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//
//		mvc.perform(get("/account/zaargh"))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.balance").value(20.0));

		fail("Finish the test, you cocky basterd");
	}

}
