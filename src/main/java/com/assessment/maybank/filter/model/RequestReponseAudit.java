package com.assessment.maybank.filter.model;

import com.assessment.maybank.model.base.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Getter @Setter  @NoArgsConstructor  @AllArgsConstructor
public class RequestReponseAudit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String endPoint;

    @Column(length = 5000)
    private String request;

    @Column(length = 5000)
    private String response;
    private long duration;

    @CreatedDate
    private Date createdDate;

}