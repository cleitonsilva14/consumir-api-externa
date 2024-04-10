package consumir.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import consumir.api.dto.CepResultDTO;

@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepAPI {

	
	
	
	@GetMapping("{cep}")
	public CepResultDTO consultaCep(@PathVariable("cep") String cep) {
		String templateCEP = String.format("https://viacep.com.br/ws/%s/json/",cep);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CepResultDTO> resp = restTemplate.getForEntity(templateCEP, CepResultDTO.class);
		
		return resp.getBody();
		
		
	}
	
}
