package guru.springframework.msbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import guru.springframework.msbreweryclient.web.model.BeerDto;
import guru.springframework.msbreweryclient.web.model.CustomerDto;

@Component
@ConfigurationProperties(prefix = "sfg.client", ignoreUnknownFields = false)
public class CustomerClient {
	
	public final String CUST_PATH_V1 = "/api/v1/customer/";
    private String apihost;
    
    private final RestTemplate restTemplate;

	public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public CustomerDto getCustById(UUID id)
	{
		return restTemplate.getForObject(apihost + CUST_PATH_V1 + id.toString(), CustomerDto.class);
	}
	
	public URI saveNewCust(CustomerDto custDto)
	{
		return restTemplate.postForLocation(apihost + CUST_PATH_V1, custDto);
	}
	
	public void updateCust(UUID id, CustomerDto custDto)
	{
		restTemplate.put(apihost + CUST_PATH_V1 + id.toString(), custDto);
	}
	
	public void deleteCust(UUID id)
	{
		restTemplate.delete(apihost + CUST_PATH_V1 + id.toString());
	}
	
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
    
}
