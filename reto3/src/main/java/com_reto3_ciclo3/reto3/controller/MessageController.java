package com_reto3_ciclo3.reto3.controller;

import com_reto3_ciclo3.reto3.exceptions.ResourceNotFound;
import com_reto3_ciclo3.reto3.model.Message;
import com_reto3_ciclo3.reto3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    private MessageService messageService;


    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/all")
    public ResponseEntity<?> findAllMessages(){
        return ResponseEntity.ok(messageService.findAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>findMessageById(@PathVariable Integer id) throws ResourceNotFound {
        Message message = messageService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    //POST REQUEST
    @PostMapping("/save")
    public ResponseEntity<Message> registrerMessage(@RequestBody Message m){
        Message message = messageService.saveMessage(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
