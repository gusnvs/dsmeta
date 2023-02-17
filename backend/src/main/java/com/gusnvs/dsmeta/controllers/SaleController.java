package com.gusnvs.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gusnvs.dsmeta.entities.Sale;
import com.gusnvs.dsmeta.services.SaleService;
import com.gusnvs.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	@Autowired
	private SmsService smsService;
	
	// para responder via web que é o http que é o protocolo da web
	@GetMapping
	public Page<Sale> findSales(
			@RequestParam(value="minDate", defaultValue="") String minDate, 
			@RequestParam(value="maxDate", defaultValue="")String maxDate, 
			Pageable pageable){
		return service.findSale(minDate, maxDate, pageable);
	}
	
	//Funcionou, a aplicação Java liberou o endpoint (/sale)
	//Quando eu chamo o endpoint na web, ele chama no backend, vai no banco de dados
	//Trás os dados, transforma em objeto java, em objeto (List<Sale>)
	//Depois transforma em formato JSON, que é o formato para trafegar dados via web
	
	// agora vamos fazer teste pelo postman, testar as requisições

	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
