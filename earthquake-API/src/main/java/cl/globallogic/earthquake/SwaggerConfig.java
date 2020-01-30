package cl.globallogic.earthquake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("Angel Gonzalez", "www.https://www.globallogic.com", "angel.gonzalez@globallogic.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Earthquake API", "API Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	
	private static final Set<String> DEFAULT_PRODUCES = new HashSet<String>(Arrays.asList("aplication/json"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DEFAULT_API_INFO)
				.produces(DEFAULT_PRODUCES)
				.consumes(DEFAULT_PRODUCES);
		
	}
}


