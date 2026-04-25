package dev.orion.track_my_vehicle_domain.common;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.pk.BaseChangeReqPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_change_reqeust")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseChangeRequest {

    @EmbeddedId
    private BaseChangeReqPk id;

    private String title;

    private String desc;

    @Column(columnDefinition = "TEXT")
    private String oldInfo;

    @Column(columnDefinition = "TEXT")
    private String newInfo;

    private LocalDateTime requestAt;

    private LocalDateTime updateAt;

    private ApprovalStatus status;

    private boolean isRequested;

    private String rejectedReason;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "maker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maker_name"))
    })
    private Auditor maker;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "username", column = @Column(name = "checker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "checker_name"))
    })
    private Auditor checker;

}
