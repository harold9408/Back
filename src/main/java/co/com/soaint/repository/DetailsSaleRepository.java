package co.com.soaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.soaint.entity.DetailSale;

public interface DetailsSaleRepository extends JpaRepository<DetailSale, Integer> {
	DetailSale FindByName(String name);
}
