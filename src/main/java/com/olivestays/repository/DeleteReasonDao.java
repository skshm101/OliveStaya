package com.olivestays.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olivestays.model.DeleteReason;

public interface DeleteReasonDao extends JpaRepository<DeleteReason, Long>{

}
