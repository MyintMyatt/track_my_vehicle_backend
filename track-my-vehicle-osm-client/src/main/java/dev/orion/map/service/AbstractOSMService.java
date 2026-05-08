package dev.orion.map.service;

public abstract class AbstractOSMService {
    private final String BASE_URL;

    public AbstractOSMService(String BASE_URL){
        this.BASE_URL = BASE_URL;
    }

    protected String getBaseUrl(){
        return this.BASE_URL;
    }

}
