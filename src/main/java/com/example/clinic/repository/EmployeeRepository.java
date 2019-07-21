package com.example.clinic.repository;


import com.example.clinic.domain.EmployeeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends BaseRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findByUsername(String username);

    Optional<EmployeeEntity> findByNameAndRole(String name,String role);

    @Query("select d from EmployeeEntity d where d.name like ?1 AND d.role = ?2")
    Optional<EmployeeEntity> findByNameContainingAndRole(String name,String role);

}
