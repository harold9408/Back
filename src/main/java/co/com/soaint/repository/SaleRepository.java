package co.com.soaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import co.com.soaint.entity.Sale;

public interface SaleRepository  extends JpaRepository<Sale, Integer>{
	Sale FindByName(String name);
}
