package com.coviam.ticket.userDetails.controllers;


import com.coviam.ticket.userDetails.dto.CardDetailsDTO;
import com.coviam.ticket.userDetails.dto.UserDTO;
import com.coviam.ticket.userDetails.entities.User;
import com.coviam.ticket.userDetails.services.CardService;
import com.coviam.ticket.userDetails.services.UserService;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CardService cardService;

    ObjectNode objectNode = JsonNodeFactory.instance.objectNode();

    @PostMapping(
            value = "/addUser",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addUser(@RequestBody UserDTO userDTO) {
        User user = userService.add(userDTO);
        return new ResponseEntity<>(user, OK);
    }

    @PutMapping(
            value = "/{userId}",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> updateUser(@PathVariable("userId") String userId,
                                        @RequestBody UserDTO userDTO) {
        User user = userService.update(userId, userDTO);
        return new ResponseEntity<>(user, OK);
    }


    @GetMapping(value = "/{userId}",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getUser(@PathVariable("userId") String userId) {
        UserDTO userDTO = userService.get(userId);
        return new ResponseEntity<>(userDTO, OK);
    }

    @DeleteMapping(
            value = "/{userId}",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> deleteUser(@PathVariable("userId") String userId) {
        userService.delete(userId);
        objectNode.removeAll();
        objectNode.put("message","Deleted" + userId + " successfully");
        return ResponseEntity.ok().contentType(APPLICATION_JSON).body(objectNode);
    }

    @GetMapping(
            value = "/getAll",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @DeleteMapping(
            value = "/deleteAll",
            produces = APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> deleteAll() {
        userService.deleteAll();
        objectNode.removeAll();
        objectNode.put("message", "Deleted ALL recoreds successfully.");
        return ResponseEntity.ok().contentType(APPLICATION_JSON).body(objectNode);
    }

    @PutMapping(
            value = "/card/{userId}"
    )
    public ResponseEntity<?> addCardInfo(@PathVariable("userId") String userId, @RequestBody CardDetailsDTO cardInfo){
        userService.addCardInfo(userId, cardInfo);
        return ResponseEntity.ok(cardInfo);
    }

    @GetMapping(
            value = "/card/getAllCards"
    )
    public ResponseEntity<?> getAllCards(){
        return ResponseEntity.ok(cardService.getAll());
    }
}
