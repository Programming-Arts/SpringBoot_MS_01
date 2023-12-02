package com.nt;

import com.nt.entity.PersonDetails;
import com.nt.entity.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<PersonDetails,Integer> {
}
