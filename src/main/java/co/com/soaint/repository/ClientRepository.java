package co.com.soaint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.soaint.entity.Client;

public interface ClientRepository  extends JpaRepository<Client, Integer>{
	Client FindByName(String name);
}
