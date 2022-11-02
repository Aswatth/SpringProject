package test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.SpringSecurityEmailApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@CucumberContextConfiguration
@SpringBootTest(
		classes = SpringSecurityEmailApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class config {
	protected RestTemplate rest = new RestTemplate();
	protected String URL = "http://localhost:8080/";

}
