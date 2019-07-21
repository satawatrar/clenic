package com.example.clinic.module.Common.service;

import com.example.clinic.domain.AppointmentEntity;
import com.example.clinic.domain.DoctorScheduleEntity;
import com.example.clinic.domain.EmployeeEntity;
import com.example.clinic.module.Common.model.AvaliableTime;
import com.example.clinic.module.Common.model.DoctorScheduleRequest;
import com.example.clinic.module.Common.model.DoctorScheduleResponse;
import com.example.clinic.repository.*;
import com.example.clinic.security.jwt.TokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommonService {

    private EmployeeRepository employeeRepository;

    @Autowired
    private DoctorScheduleRepository doctorScheduleRepository;

    private AppointmentRepository appointmentRepository;

    @Autowired
    TokenProvider tokenProvider;

    private static final String DOCTOR_ROLE = "doctor";

    @Transactional
    public DoctorScheduleResponse getSchedule(DoctorScheduleRequest request) throws Exception {
        DoctorScheduleResponse doctorScheduleResponse = new DoctorScheduleResponse();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DateFormat responseFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date reserveTime = dateFormat.parse(request.getReserveTime());

        DoctorScheduleSpecification doctorScheduleSpecification = new DoctorScheduleSpecification();
        DoctorScheduleSearchCriteria doctorScheduleSearchCriteria = prepareCriteria(request, reserveTime);
        List<DoctorScheduleEntity> doctorScheduleEntities = doctorScheduleRepository.findAll(doctorScheduleSpecification.searchWithCriteria(doctorScheduleSearchCriteria));

        AppointmentSpecification appointmentSpecification = new AppointmentSpecification();
        List<AvaliableTime> avaliableTimes = new ArrayList<>();
        for (int i = 0; i < doctorScheduleEntities.size(); i++) {
            AppointmentSearchCriteria appointmentSearchCriteria = prepareCriteria(doctorScheduleEntities.get(i), reserveTime);
            List<AppointmentEntity> appointmentEntityList = appointmentRepository.findAll(appointmentSpecification.searchWithCriteria(appointmentSearchCriteria));
            AvaliableTime avaliableTime;

            //------------------- No Reserve ---------------------//
            if(appointmentEntityList.size() == 0 ){
                avaliableTime = new AvaliableTime();
                avaliableTime.setDoctorName(doctorScheduleEntities.get(i).getName());
                avaliableTime.setStartTime(dateFormat.format(reserveTime));
                avaliableTime.setEndTime(responseFormat.format(reserveTime)+" "+doctorScheduleEntities.get(i).getEndTime());
                avaliableTimes.add(avaliableTime);
            }

            for(int j = 0 ;j<appointmentEntityList.size(); j++){
                avaliableTime = new AvaliableTime();
                avaliableTime.setDoctorName(doctorScheduleEntities.get(i).getName());
                if(appointmentEntityList.size() > j+1){
                    //--------------------- End Time แต่ละ สล๊อต ------------------------//
//                    System.out.println("Start time :"+j+" "+dateFormat.format(appointmentEntityList.get(j).getEndTime()));
//                    System.out.println("End time :"+(j+1)+" "+dateFormat.format(appointmentEntityList.get(j+1).getStartTime()));
//                    if((appointmentEntityList.get(i).getEndTime()).after(appointmentEntityList.get(i + 1).getStartTime())) {
                        avaliableTime.setStartTime(dateFormat.format(appointmentEntityList.get(j).getEndTime()));
                        avaliableTime.setEndTime(dateFormat.format(appointmentEntityList.get(j+1).getStartTime()));
//                    }
                }else {
                    //--------------------- End Time ถึง End Doctor -------------------//
                    avaliableTime.setStartTime(dateFormat.format(appointmentEntityList.get(j).getEndTime()));
                    avaliableTime.setEndTime(responseFormat.format(reserveTime)+" "+doctorScheduleEntities.get(i).getEndTime());
                }
                System.out.println(avaliableTime.toString());
                avaliableTimes.add(avaliableTime);
            }
        }
        doctorScheduleResponse.setAvaliableTimes(avaliableTimes);

        return doctorScheduleResponse;
    }

    private DoctorScheduleSearchCriteria prepareCriteria(DoctorScheduleRequest request, Date reserveTime) throws Exception {
        EmployeeEntity employeeEntity = null;
        DoctorScheduleSearchCriteria doctorScheduleSearchCriteria = new DoctorScheduleSearchCriteria();

        if (request.getDoctorName() != null && request.getDoctorName() != "") {
            employeeEntity = employeeRepository.findByNameContainingAndRole(request.getDoctorName(), DOCTOR_ROLE).orElseThrow(() -> new Exception());
            doctorScheduleSearchCriteria.setEmpId(employeeEntity.getEmpId());
        }
        doctorScheduleSearchCriteria.setBId(request.getBranchId());
        doctorScheduleSearchCriteria.setDate(request.getDay());

        doctorScheduleSearchCriteria.setReserveTime(new Time(reserveTime.getTime()));

        return doctorScheduleSearchCriteria;
    }

    private AppointmentSearchCriteria prepareCriteria(DoctorScheduleEntity entity, Date reserveTime) throws Exception {

        AppointmentSearchCriteria appointmentSearchCriteria = new AppointmentSearchCriteria();
        appointmentSearchCriteria.setEmpId(entity.getEmpId());
        appointmentSearchCriteria.setReserveTime(reserveTime);

        return appointmentSearchCriteria;
    }




}

