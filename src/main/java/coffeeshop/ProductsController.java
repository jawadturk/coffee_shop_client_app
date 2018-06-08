package coffeeshop;

import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Controller
public class ProductsController {


	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/products";
	}
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public String getAll() {
		String getUrl = "http://localhost:8080/products/all";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<String> result = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		if(result.getBody() != null){
			System.out.println("Response for Get Request: " + result.getBody().toString());
		}else{
			System.out.println("Response for Get Request: NULL");
		}
		return "addProduct";
	}

	@RequestMapping(value="/products/addProduct", method=RequestMethod.POST)
	public String add(@RequestParam("productName") String productName ,
					  @RequestParam("description") String description ,
					  @RequestParam("price") double price ,
					  @RequestParam("productType") ProductType productType ) {


		String postUrl = "http://localhost:8080/products/save";
		RestTemplate restTemplate = new RestTemplate();


		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		try {
			JSONObject jsonCredentials = new JSONObject();
			jsonCredentials.put("productName", productName);
			jsonCredentials.put("description", description);
			jsonCredentials.put("price", Double.toString(price));
			jsonCredentials.put("productType", productType.toString());

			System.out.print( ">>>>>>>>>>>>>>>> JSON credentials " + jsonCredentials.toString());
			HttpEntity<String> entityCredentials = new HttpEntity<String>(jsonCredentials.toString(), httpHeaders);
			ResponseEntity<String > responseEntity = restTemplate.exchange(postUrl,
					HttpMethod.POST, entityCredentials, String.class);
			if (responseEntity != null) {
				System.out.println( responseEntity.getBody());
			}

		} catch (Exception e) {
			System.out.print( ">>>>>>>>>>>>>>>> " + e.getLocalizedMessage());
		}



		return "/successAdded";
	}
}
