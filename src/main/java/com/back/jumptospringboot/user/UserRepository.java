package com.back.jumptospringboot.user;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername (String username);

    Optional<SiteUser> findByUsername(String username, Sort sort);

    Optional<SiteUser> findByUsername(String username);
}
