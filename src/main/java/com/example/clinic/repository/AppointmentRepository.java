package com.example.clinic.repository;


import com.example.clinic.domain.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends BaseRepository<AppointmentEntity, Long> {

    Optional<List<AppointmentEntity>> findByAptDateAndDoctorId(String workDate,Long dId);


}
