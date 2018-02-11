package com.coviam.ticket.userDetails.services.impl;

import com.coviam.ticket.userDetails.entities.CardDetails;
import com.coviam.ticket.userDetails.repositories.CardRepository;
import com.coviam.ticket.userDetails.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Override
    public List<CardDetails> getAll() {
        return cardRepository.findAll();
    }
}
