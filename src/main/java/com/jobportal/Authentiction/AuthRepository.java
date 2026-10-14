
package com.jobportal.Authentiction;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity, Long> {

    Optional<AuthEntity> findByEmail(String email);
    
    boolean existsByEmail(String email);
}

