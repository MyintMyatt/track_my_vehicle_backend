package dev.orion.track_my_vehicle_domain.account;

import dev.orion.track_my_vehicle_domain.constant.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee_account")
public class EmployeeAccount extends Account{

    @Column(name = "employee_id")
    private String employeeId;

    private Gender gender;
    @Override
    public AccountStatus getAccountStatus() {
        return null;
    }
}
