package dev.orion.track_my_vehicle_application.test;

import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;

public class Main {
    private static final DateTimeFormatter  MULTI_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ofPattern("yyyy/MM/dd"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            .appendOptional(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
            .appendOptional(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            .toFormatter();
    public static void main(String[] args) {
        String date = "29-10-2026";
//        System.out.println(LocalDate.parse(date, MULTI_FORMATTER));

//        Form data = new Form("09786396392", "deviceId127", "MyDevice", "127.0.0.1");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> data = Map.of("phone","09786396392","deviceId","deviceId127","deviceName","MyDevice","ipAddress","127.0.0.1");
        var dataJson = objectMapper.writeValueAsString(data);
        System.out.println(dataJson);
        long length = dataJson.getBytes().length;
        System.out.println(length);
    }
}
/*"phone" : "09786396392",
    "deviceId" : "deviceId127",
    "deviceName": "MyDevice",
    "ipAddress" : "127.0.0.1"*/
class Form{
    String phone;
    String deviceId;
    String deviceName;
    String ipAddress;

    public Form(String phone, String deviceId, String deviceName, String ipAddress) {
        this.phone = phone;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.ipAddress = ipAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getIpAddress() {
        return ipAddress;
    }
}
