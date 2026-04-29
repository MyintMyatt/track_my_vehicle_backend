package dev.orion.track_my_vehicle_domain.common;

import dev.orion.track_my_vehicle_domain.auditor.Auditor;
import dev.orion.track_my_vehicle_domain.constant.ApprovalStatus;
import dev.orion.track_my_vehicle_domain.pk.BaseChangeReqPk;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "base_change_request")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseChangeRequest {

    @EmbeddedId
    private BaseChangeReqPk id;

    private String title;

    private String description;

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
            @AttributeOverride(name = "userName", column = @Column(name = "maker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "maker_name"))
    })
    private Auditor maker;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "userName", column = @Column(name = "checker_id")),
            @AttributeOverride(name = "fullName", column = @Column(name = "checker_name"))
    })
    private Auditor checker;

}
