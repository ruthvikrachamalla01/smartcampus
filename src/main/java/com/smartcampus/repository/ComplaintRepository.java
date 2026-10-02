package com.smartcampus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcampus.entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    List<Complaint> findByAssignedStaffId(Long assignedStaffId);

}