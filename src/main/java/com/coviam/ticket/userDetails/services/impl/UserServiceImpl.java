package com.coviam.ticket.userDetails.services.impl;

import com.coviam.ticket.userDetails.dto.CardDetailsDTO;
import com.coviam.ticket.userDetails.dto.UserDTO;
import com.coviam.ticket.userDetails.entities.CardDetails;
import com.coviam.ticket.userDetails.entities.User;
import com.coviam.ticket.userDetails.exceptions.RecordNotFoundException;
import com.coviam.ticket.userDetails.repositories.CardRepository;
import com.coviam.ticket.userDetails.repositories.UserRepository;
import com.coviam.ticket.userDetails.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardRepository cardRepository;

    @Override
    public User add(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public UserDTO get(String userId) {
        User user = userRepository.findOne(userId);
        if (null == user)
            throw new RecordNotFoundException(userId);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public User update(String userId, UserDTO updatedInformation) {
        if (!userRepository.exists(userId))
            throw new RecordNotFoundException(userId);
        updatedInformation.setId(userId);
        User user = new User();
        BeanUtils.copyProperties(updatedInformation, user);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();

    }

    @Override
    public Integer deleteAll() {
        userRepository.deleteAll();
        return (int) userRepository.count();
    }

    @Override
    public void delete(String userId) {
        userRepository.delete(userId);
    }

    /**
     * Update card list with a new card
     * @param userId : user id
     * @param cardInfo
     * @throws RecordNotFoundException
     */
    @Override
    public void addCardInfo(String userId, CardDetailsDTO cardInfo) throws RecordNotFoundException{
        User user = userRepository.findOne(userId);
        if (null == user)
            throw new RecordNotFoundException(userId);
        CardDetails cardDetails = new CardDetails();
        BeanUtils.copyProperties(cardInfo, cardDetails);
        cardDetails.setOwner(user);

        cardRepository.save(cardDetails);

        user.getCardDetails().add(cardDetails);
        userRepository.save(user);
    }
}
