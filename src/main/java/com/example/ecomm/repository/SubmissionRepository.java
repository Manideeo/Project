package com.example.ecomm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecomm.dto.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {

}
