package com.gusnvs.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gusnvs.dsmeta.entities.Sale;
import com.gusnvs.dsmeta.repositories.SaleRepository;

// com essa anotacion eu estou registrando o SaleService como um componente do sistema
@Service
public class SaleService {
	
	// uma anotacion que faz a importação automática, do spring
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSale() {
		return repository.findAll();
	}
}
