package com.website.login.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.website.login.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {

       Optional<UserEntity> findByUsername(String username);
} 
