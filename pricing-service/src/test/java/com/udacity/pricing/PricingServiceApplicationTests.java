package com.udacity.pricing;

import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingServiceApplicationTests {

    @Autowired
    private PricingController pricingController;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        assertThat(pricingController).isNotNull();
    }

    @Test
    public void greetingShouldReturnDefaultMessage() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/services/price?vehicleId=2",
                Price.class).getPrice()).isNotNull().isPositive();
    }
}
