package dev.damola.fullstacktest.repository;

import dev.damola.fullstacktest.model.UserSector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSectorRepository extends JpaRepository<UserSector,Integer> {
}
