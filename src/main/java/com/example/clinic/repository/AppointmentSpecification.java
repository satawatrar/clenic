package com.example.clinic.repository;

import com.example.clinic.domain.AppointmentEntity;
import com.example.clinic.domain.DoctorScheduleEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class AppointmentSpecification implements Specification<AppointmentEntity> {

    public Specification<AppointmentEntity> searchWithCriteria(AppointmentSearchCriteria criteria) {
        Specification specification = new Specification<AppointmentEntity>() {
            @Override
            public Predicate toPredicate(Root<AppointmentEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate orCondition = cb.notEqual(root.get("endTime"), "TRUE");
                if (criteria.getEmpId() != null) {
                    predicates.add(cb.equal(root.get("doctorId"), criteria.getEmpId()));
                }
                if (criteria.getReserveTime() != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("startTime"),criteria.getReserveTime()));
                }
                Predicate andCondition = cb.and(predicates.toArray(new Predicate[predicates.size()]));
                if(predicates.size() == 0){
                    return cb.or(orCondition, andCondition);
                }else {
                    return andCondition;
                }
            }
        };

        return specification;
    }


    @Override
    public Predicate toPredicate(Root<AppointmentEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}



