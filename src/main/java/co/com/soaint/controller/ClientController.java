package co.com.soaint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.soaint.entity.Client;
import co.com.soaint.service.ClientService;

@RestController
public class ClientController {
	
    @Autowired
    private ClientService service;

    @PostMapping("/addProduct")
    public Client addClient(@RequestBody Client client) {
        return service.saveClient(client);
    }
	
}
