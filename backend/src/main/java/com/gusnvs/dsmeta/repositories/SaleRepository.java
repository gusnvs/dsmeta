package com.gusnvs.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gusnvs.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	// componente do sistema responsável por acessar o banco de dados
	// salvar uma venda, atualizar, buscar, deletar...
}
