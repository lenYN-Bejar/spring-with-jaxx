package com.jaax.restfulapi.repository;

import com.jaax.restfulapi.entity.Local;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILocalRepository extends JpaRepository<Local, Long> {
}
