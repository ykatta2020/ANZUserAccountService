package com.anz.account;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserAccountControllerTests {

	// bind the above RANDOM_PORT
	@LocalServerPort
	private int randomServerPort;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getUserAccountDetailsTest() throws Exception {

		String expected = "[" + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"accountType\": \"Saving\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"balanceDate\": \"18/12/2020\"," + 
				"    \"accountStatus\": \"ACTIVE\"," + 
				"    \"availableBalance\": 15000.78" + 
				"  }" + 
				"]";

		final String baseUrl = "http://localhost:" + randomServerPort + "/ANZ/accounts/yk13134";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}
	
	@Test
	public void backtoUserAccountDetailsTest() throws Exception {

		String expected = "[" + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"accountType\": \"Saving\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"balanceDate\": \"18/12/2020\"," + 
				"    \"accountStatus\": \"ACTIVE\"," + 
				"    \"availableBalance\": 15000.78" + 
				"  }" + 
				"]";

		final String baseUrl = "http://localhost:" + randomServerPort + "/ANZ/backToAccounts/yk13134";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}

	@Test
	public void userAccountDetailsNotAvailabelTest() throws Exception {

		String expected = "{" + "  \"message\": \"Account Details not available for user::wk24123\"" + "}";
		final String baseUrl = "http://localhost:" + randomServerPort + "/ANZ/accounts/wk24123";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}
	
	@Test
	public void accountTransactionDetailsNotAvailableTest() throws Exception {

		String expected = "{" + "  \"message\": \"Transaction Details not available for Account::ANZSGB9999\"" + "}";
		final String baseUrl = "http://localhost:" + randomServerPort + "/ANZ/transactions/ANZSGB9999";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}
	
	@Test
	public void getAccountTransactionDetailsTest() throws Exception {

		String expected = "[" + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Jun 02 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 2000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"May 02 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 3000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Jun 30 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 4000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Aug 12 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 5000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Sep 22 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 1000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Oct 12 2020\"," + 
				"    \"debitAmount\": 8000," + 
				"    \"creditAmount\": null," + 
				"    \"transactionType\": \"Debit\"," + 
				"    \"transactionNarrative\": \"pay to family\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Nov 27 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 6000," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Nov 29 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 500.5," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }," + 
				"  {" + 
				"    \"accountNumber\": \"ANZSGB2123\"," + 
				"    \"accountName\": \"SGSavingAccount\"," + 
				"    \"currency\": \"SGD\"," + 
				"    \"valueDate\": \"Dec 02 2020\"," + 
				"    \"debitAmount\": null," + 
				"    \"creditAmount\": 1500.28," + 
				"    \"transactionType\": \"Credit\"," + 
				"    \"transactionNarrative\": \"\"" + 
				"  }" + 
				"]";
		final String baseUrl = "http://localhost:" + randomServerPort + "/ANZ/transactions/ANZSGB2123";
		URI uri = new URI(baseUrl);
		ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
		JSONAssert.assertEquals(expected, response.getBody(), true);
	}

}
