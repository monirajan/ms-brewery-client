package guru.springframework.msbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msbreweryclient.web.model.BeerDto;
import guru.springframework.msbreweryclient.web.model.CustomerDto;

@SpringBootTest
public class CustomerClientTest {
	
	@Autowired
	CustomerClient customerClient;
	CustomerDto custDto;

	@BeforeEach
	void setUp() throws Exception {
		custDto = CustomerDto.builder().customerName("Emma Watson").build();
	}

	@Test
	void testgetBeerByid() {
		CustomerDto Dto = customerClient.getCustById(UUID.randomUUID());
		assertNotNull(Dto);
	}
	
	@Test
	void testSaveNewBeer() {
		URI uri = customerClient.saveNewCust(custDto);
	    assertNotNull(uri);
	}

	@Test
	void testUpdateBeer() {
	    customerClient.updateCust(UUID.randomUUID(), custDto);
	}

	@Test
	void testDeleteBeer() {
	    customerClient.deleteCust(UUID.randomUUID());
	}

}
