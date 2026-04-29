package dev.orion.track_my_vehicle_domain.account;

import dev.orion.track_my_vehicle_domain.auditor.AuditorEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "account")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account extends AuditorEntity {

    @Id
    @GeneratedValue(generator = "seq_generator")
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String fullName;

    private String email;

    @Column(nullable = false, length = 15)
    private String phone;

    public abstract AccountStatus getAccountStatus();
}