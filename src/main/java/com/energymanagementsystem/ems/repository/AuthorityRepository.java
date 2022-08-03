package com.energymanagementsystem.ems.repository;

import com.energymanagementsystem.ems.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
