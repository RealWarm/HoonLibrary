package com.group.libraryapp.util.image.damin;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity extends BaseTimeEntity{
    //등록자
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    //수정자
    @LastModifiedBy
    private String lastModifiedBy;
}
