package com.gusnvs.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gusnvs.dsmeta.entities.Sale;
import com.gusnvs.dsmeta.repositories.SaleRepository;

// com essa anotacion eu estou registrando o SaleService como um componente do sistema
@Service
public class SaleService {
	
	// uma anotacion que faz a importação automática, do spring
	@Autowired
	private SaleRepository repository;
	
	public Page<Sale> findSale(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
		
		// o problema é que o JPA Repository não tem uma função que recebe 3 parâmetros, então vou ter que criar
		return repository.findSales(min, max, pageable);
	}
}
