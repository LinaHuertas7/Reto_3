package com_reto3_ciclo3.reto3.service;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Message;
import com_reto3_ciclo3.reto3.repository.IMessageRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class MessageService {

    private IMessageRepository messageRepository;

    @Autowired
    public MessageService(IMessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Collection<Message> findAllMessages(){
        log.info("Se buscaron todos los Mensajes");
        return messageRepository.findAll();
    }

    public Message findById(Integer id) throws ResourceNotFound {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isEmpty()){
            throw new ResourceNotFound("No se encontro el Mensaje con id: " + id);
        }else{
            log.info("Se busco el Mensaje con id: " + id);
            return message.get();
        }
    }

    public Message saveMessage(Message m){
        m.setIdMessage(null);
        Message message = messageRepository.save(m);
        log.info("Se guardo el Mensaje con id : " + message.getIdMessage());
        return message;
    }
}
