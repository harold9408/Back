package co.com.soaint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.soaint.entity.Client;
import co.com.soaint.repository.ClientRepository;

@Service
public class ClientService {
	
	 @Autowired
	 private ClientRepository clientRepository;
	 
	 public Client saveClient(Client client) {
		 return clientRepository.save(client);
	 }

}
