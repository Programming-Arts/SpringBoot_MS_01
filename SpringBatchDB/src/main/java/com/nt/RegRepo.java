package com.nt;

import com.nt.entity.RegistrationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegRepo extends JpaRepository<RegistrationDetails,Integer> {
}
