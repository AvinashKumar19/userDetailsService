package com.coviam.ticket.userDetails.repositories;

import com.coviam.ticket.userDetails.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
