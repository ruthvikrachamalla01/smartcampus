package com.smartcampus.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartcampus.entity.Complaint;
import com.smartcampus.service.ComplaintService;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(
            ComplaintService complaintService) {

        this.complaintService = complaintService;
    }

    @PostMapping
    public Complaint createComplaint(
            @RequestBody Complaint complaint) {

        return complaintService.saveComplaint(complaint);
    }

    @GetMapping
    public List<Complaint> getAllComplaints() {

        return complaintService.getAllComplaints();
    }

    /*
     * Get complaints assigned to a particular
     * Maintenance Staff user.
     */
    @GetMapping("/staff/{staffId}")
    public List<Complaint> getStaffComplaints(
            @PathVariable Long staffId) {

        return complaintService
                .getComplaintsByStaff(staffId);
    }

    @PutMapping("/{id}/status")
    public Complaint updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return complaintService
                .updateComplaintStatus(id, status);
    }

    /*
     * Assign complaint using Staff User ID.
     */
    @PutMapping("/{id}/assign")
    public Complaint assignStaff(
            @PathVariable Long id,
            @RequestParam Long staffId) {

        return complaintService
                .assignStaff(id, staffId);
    }

    @PutMapping("/{id}/remarks")
    public Complaint addResolutionRemarks(
            @PathVariable Long id,
            @RequestParam String remarks) {

        return complaintService
                .addResolutionRemarks(id, remarks);
    }
}