package com_reto3_ciclo3.reto3.controller;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Client;
import com_reto3_ciclo3.reto3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/all")
    public ResponseEntity<?> findAllClients(){
        return ResponseEntity.ok(clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findClientById(@PathVariable Integer id) throws ResourceNotFound {
        Client client = clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(client);
    }

    //POST REQUEST
    @PostMapping("/save")
    public ResponseEntity<Client> registrerClient(@RequestBody Client c){
        Client client = clientService.saveClient(c);
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }
}
