package com_reto3_ciclo3.reto3.service;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Client;
import com_reto3_ciclo3.reto3.repository.IClientRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class ClientService {

    private IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Collection<Client> findAllClients(){
        log.info("Se buscaron todos los clientes");
        return clientRepository.findAll();
    }

    public Client findById(Integer id) throws ResourceNotFound {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new ResourceNotFound("No se encontro el cliente con id: " + id);
        }else{
            log.info("Se busco el cliente con id: " + id);
            return client.get();
        }
    }

    public Client saveClient(Client c){
        c.setIdClient(null);
        Client client = clientRepository.save(c);
        log.info("Se guardo el cliente con nombre: " + client.getName());
        return client;
    }
}
