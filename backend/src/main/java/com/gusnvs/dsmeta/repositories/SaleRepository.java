package com.gusnvs.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gusnvs.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	// componente do sistema responsável por acessar o banco de dados
	// salvar uma venda, atualizar, buscar, deletar...
	
	// como o JPA Repository não tem uma função que recebe 3 parâmetros, vou criar, por causa do mindate e maxdate

	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}