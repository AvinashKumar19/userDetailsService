package com.coviam.ticket.userDetails.repositories;

import com.coviam.ticket.userDetails.entities.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardDetails, String> {


}
