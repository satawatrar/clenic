package com.example.clinic.repository;


import com.example.clinic.domain.PatientEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends BaseRepository<PatientEntity, Long> {


}
