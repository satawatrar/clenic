package com.example.clinic.repository;

import com.example.clinic.domain.DoctorScheduleEntity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DoctorScheduleSpecification implements Specification<DoctorScheduleEntity> {


    public Specification<DoctorScheduleEntity> searchWithCriteria(DoctorScheduleSearchCriteria criteria) {
        Specification specification = new Specification<DoctorScheduleEntity>() {
            @Override
            public Predicate toPredicate(Root<DoctorScheduleEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate orCondition = cb.notEqual(root.get("workDate"), "TRUE");
                if (criteria.getEmpId() != null) {
                    predicates.add(cb.equal(root.get("empId"), criteria.getEmpId()));
                }

                if (criteria.getDate() != null) {
                    predicates.add(cb.equal(root.get("workDate"), criteria.getDate()));
                }

                if (criteria.getBId() != null) {
                    predicates.add(cb.equal(root.get("bId"), criteria.getBId()));
                }

                if (criteria.getReserveTime() != null) {
                    predicates.add(cb.greaterThanOrEqualTo(root.get("endTime"),criteria.getReserveTime()));
                    predicates.add(cb.lessThanOrEqualTo(root.get("startTime"),criteria.getReserveTime()));
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
    public Predicate toPredicate(Root<DoctorScheduleEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}



