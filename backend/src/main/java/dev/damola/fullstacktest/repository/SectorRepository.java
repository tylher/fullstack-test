package dev.damola.fullstacktest.repository;

import dev.damola.fullstacktest.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SectorRepository extends JpaRepository<Sector,Integer> {
}
