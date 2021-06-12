package guru.springframework.msbreweryclient.web.client;


import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;
	BeerDto beerDto;

	@BeforeEach
	void setUp() throws Exception {
		beerDto = BeerDto.builder().beerName("New Beer").build();
	}

	@Test
	void testgetBeerByid() {
		BeerDto Dto = breweryClient.getBeerById(UUID.randomUUID());
		assertNotNull(Dto);
	}
	
	 	@Test
	    void testSaveNewBeer() {
	        URI uri = breweryClient.saveNewBeer(beerDto);
	        assertNotNull(uri);
	    }

	    @Test
	    void testUpdateBeer() {
	    	breweryClient.updateBeer(UUID.randomUUID(), beerDto);
	    }

	    @Test
	    void testDeleteBeer() {
	    	breweryClient.deleteBeer(UUID.randomUUID());
	    }

}
