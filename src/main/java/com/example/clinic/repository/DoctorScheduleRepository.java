package com.example.clinic.repository;


import com.example.clinic.domain.DoctorScheduleEntity;
import com.example.clinic.domain.EmployeeEntity;
import com.example.clinic.domain.PatientEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorScheduleRepository extends BaseRepository<DoctorScheduleEntity, Long> {


    Optional<DoctorScheduleEntity> findByEmpId(Long empId);

    @Query("select d from DoctorScheduleEntity d where d.bId = ?1 AND d.workDate = ?2 AND  ?3 between d.startTime and d.endTime")
    Optional<List<DoctorScheduleEntity>> findByBIdAndWorkDateAndReserveTime(Long bId, String workDate, Time reserveTime);


}
