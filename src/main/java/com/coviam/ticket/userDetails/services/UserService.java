package com.coviam.ticket.userDetails.services;

import com.coviam.ticket.userDetails.dto.CardDetailsDTO;
import com.coviam.ticket.userDetails.dto.UserDTO;
import com.coviam.ticket.userDetails.entities.User;

import java.util.List;

public interface UserService {

    User add(UserDTO userDTO);

    UserDTO get(String userId);

    User update(String userId, UserDTO updatedInformation);

    List<User> getAll();

    Integer deleteAll();

    void delete(String userId);

    void addCardInfo(String userId, CardDetailsDTO cardInfo);
}
