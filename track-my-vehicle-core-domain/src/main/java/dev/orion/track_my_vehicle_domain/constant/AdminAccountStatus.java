package dev.orion.track_my_vehicle_domain.constant;

public enum AdminAccountStatus implements AccountStatus{
    Active("Active"),
    Freeze("Freeze"),
    Deactivate("Deactivate");

    private String value;

    AdminAccountStatus(String value){
        this.value = value;
    }
    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getDisplayName() {
        return value;
    }
}
