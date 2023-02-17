package com.gusnvs.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gusnvs.dsmeta.entities.Sale;
import com.gusnvs.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;

	// para responder via web que é o http que é o protocolo da web
	@GetMapping
	public List<Sale> findSales(){
		return service.findSale();
	}
	
	//Funcionou, a aplicação Java liberou o endpoint (/sale)
	//Quando eu chamo o endpoint na web, ele chama no backend, vai no banco de dados
	//Trás os dados, transforma em objeto java, em objeto (List<Sale>)
	//Depois transforma em formato JSON, que é o formato para trafegar dados via web


	// agora vamos fazer teste pelo postman, testar as requisições

}
