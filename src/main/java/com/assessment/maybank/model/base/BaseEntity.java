package com.assessment.maybank.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.Inheritance;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@MappedSuperclass
@Setter @Getter
public abstract class BaseEntity {

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate = new Date();
}

