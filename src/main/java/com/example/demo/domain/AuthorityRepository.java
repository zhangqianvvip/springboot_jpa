package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuthorityRepository extends JpaRepository<Authority, String>,JpaSpecificationExecutor<Authority>{

}
