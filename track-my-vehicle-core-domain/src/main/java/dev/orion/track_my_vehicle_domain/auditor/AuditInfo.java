package dev.orion.track_my_vehicle_domain.auditor;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Embeddable
@Data
public class AuditInfo {
    private boolean deleted;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreatedBy
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "created_user_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "created_user_name"))
    })
    @Embedded
    private Auditor createdBy;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updateAt;

    @LastModifiedBy
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "created_user_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "created_user_name"))
    })
    @Embedded
    private Auditor updateBy;
}
