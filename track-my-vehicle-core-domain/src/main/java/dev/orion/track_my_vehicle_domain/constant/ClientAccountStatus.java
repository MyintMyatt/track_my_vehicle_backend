package dev.orion.track_my_vehicle_domain.constant;

import dev.orion.track_my_vehicle_domain.account.ClientAccountPermission;

public enum ClientAccountStatus implements AccountStatus{
    Active("Active", new ClientAccountPermission(true)),
    /*
    * blocked by admin
    * */
    Blocked("Blocked", new ClientAccountPermission(false)),

    /*
    * account is closed because he left job
    * */
    Closed("Closed", new ClientAccountPermission(false))
    ;

    private String value;
    private ClientAccountPermission permission;

    ClientAccountStatus(String value, ClientAccountPermission permission){
        this.value = value; this.permission = permission;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public String getDisplayName() {
        return "";
    }
}
