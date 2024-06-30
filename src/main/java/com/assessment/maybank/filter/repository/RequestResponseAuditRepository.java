package com.assessment.maybank.filter.repository;

import com.assessment.maybank.filter.model.RequestReponseAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestResponseAuditRepository extends JpaRepository<RequestReponseAudit,Long> {
}
