package com.example.clinic.module.Patiention.service;


//import com.example.clinic.module.Authenticate.model.SignOn;

import com.example.clinic.domain.PatientEntity;
import com.example.clinic.module.Patiention.model.PatientFillUpRequest;
import com.example.clinic.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@AllArgsConstructor
public class PatientionService {

    private PatientRepository patientRepository;


    @Transactional
    public Long fillUpDetail(PatientFillUpRequest request) throws Exception {
        PatientEntity patientEntity;
        try {
            patientEntity = preparePatientData(request);
            patientRepository.save(patientEntity);
            return patientEntity.getPatientId();
        } catch (Exception e) {
            throw e;
        }
    }

    private PatientEntity preparePatientData(PatientFillUpRequest request) throws ParseException {

        try {
            PatientEntity patientEntity = new PatientEntity();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dateOfBirth=  simpleDateFormat.parse(request.getDob());

            patientEntity.setPassword(request.getPassword());
            patientEntity.setAddress(request.getAddress());
            patientEntity.setAge(request.getAge());
            patientEntity.setDob(dateOfBirth);
            patientEntity.setDrugAllergy(request.getDrugAllergy());
            patientEntity.setDrugUsed(request.getDrugUsed());
            patientEntity.setEmail(request.getEmail());
            patientEntity.setFaceImg(request.getFaceImg());
            patientEntity.setLineNo(request.getLineNo());
            patientEntity.setMedicalHistory(request.getMedicalHistory());
            patientEntity.setMobileNo(request.getMobileNo());
            patientEntity.setName(request.getName());
            patientEntity.setNickName(request.getNickName());
            patientEntity.setSex(request.getSex());
            patientEntity.setThaiId(request.getThaiId());
            return patientEntity;
        } catch (Exception e) {
            System.out.println("Eror PrepareData :"+e.toString());
            throw e;
        }
    }
}
