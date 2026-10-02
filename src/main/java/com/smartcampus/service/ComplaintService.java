package com.smartcampus.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartcampus.entity.Complaint;
import com.smartcampus.repository.ComplaintRepository;

@Service
public class ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintService(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    public Complaint saveComplaint(Complaint complaint) {

        if (complaint.getStatus() == null
                || complaint.getStatus().isEmpty()) {

            complaint.setStatus("PENDING");
        }

        return complaintRepository.save(complaint);
    }

    public List<Complaint> getAllComplaints() {

        return complaintRepository.findAll();
    }

    public List<Complaint> getComplaintsByStaff(Long staffId) {

        return complaintRepository.findByAssignedStaffId(staffId);
    }

    public Complaint updateComplaintStatus(
            Long id,
            String status) {

        Complaint complaint =
                complaintRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complaint not found"
                                )
                        );

        complaint.setStatus(status);

        return complaintRepository.save(complaint);
    }

    public Complaint assignStaff(
            Long id,
            Long staffId) {

        Complaint complaint =
                complaintRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complaint not found"
                                )
                        );

        complaint.setAssignedStaffId(staffId);

        complaint.setStatus("ASSIGNED");

        return complaintRepository.save(complaint);
    }

    public Complaint addResolutionRemarks(
            Long id,
            String remarks) {

        Complaint complaint =
                complaintRepository.findById(id)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Complaint not found"
                                )
                        );

        complaint.setResolutionRemarks(remarks);

        return complaintRepository.save(complaint);
    }
}