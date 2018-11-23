package restClient;

import java.net.URI;
import org.springframework.web.client.RestTemplate;
import com.usel.app.dto.PoNumberDTO;


public class FinalPoNumberRestTestClient {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/api/finalponumber";
	
	/* POST */
	private static void finalPoNumber() {
        System.out.println("Testing create finalPoNumber----------");
        RestTemplate restTemplate = new RestTemplate();
        
        int user_id = 1;
        int customer_id = 1;
        int vessel_id = 1;
        int job_id = 1;
        int vendor_id = 1;
        
        PoNumberDTO poNumberDto = new PoNumberDTO();
        String poNumber = "";
        PoNumberDTO fpons = new PoNumberDTO();
        
        poNumber = FinalPoNumberService.generateSaveAndReturnFinalPoNumber( user_id, 
				customer_id, 
				vessel_id, 
				job_id, 
				vendor_id);
        
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/api/finalponumber/", poNumberDto, User.class);
        System.out.println("Location : "+uri.toASCIIString());
    }
}
