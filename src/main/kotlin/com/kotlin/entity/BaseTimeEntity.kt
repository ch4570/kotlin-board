package com.kotlin.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseTimeEntity {
        
        @Column(name = "REG_DATE")
        @CreatedDate
        var regDate: LocalDateTime? = null
        
        
        @Column(name = "MOD_DATE")
        @LastModifiedDate
        var modDate: LocalDateTime? = null


}




