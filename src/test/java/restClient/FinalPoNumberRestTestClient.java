package restClient;

import java.net.URI;
import org.springframework.web.client.RestTemplate;
import com.usel.app.dto.PoNumberDTO;
import com.usel.app.service.exception.ServiceException;
import com.usel.app.service.impl.FinalPoNumberServiceImpl;


public class FinalPoNumberRestTestClient {
	
	private static final String REST_SERVICE_URI = "http://localhost:8080/";
	
	/* POST */
	private static void finalPoNumber() {
        System.out.println("Testing create finalPoNumber----------");
        RestTemplate restTemplate = new RestTemplate();
        
        PoNumberDTO poNumberDto = new PoNumberDTO();
        FinalPoNumberServiceImpl finalPoNumberService = new FinalPoNumberServiceImpl();
        String poNumber;
        
        int user_id = 1;
        int customer_id = 1;
        int vessel_id = 1;
        int job_id = 1;
        int vendor_id = 1;
        
		try {
			poNumber = finalPoNumberService.generateSaveAndReturnFinalPoNumber( user_id, customer_id, vessel_id, job_id, vendor_id);
			poNumberDto.setPoNumber(poNumber);
			URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "api/finalponumber/", poNumber, PoNumberDTO.class);
			System.out.println("Location : " + uri.toASCIIString());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
