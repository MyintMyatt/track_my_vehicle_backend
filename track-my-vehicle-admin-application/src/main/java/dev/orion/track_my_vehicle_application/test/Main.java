package dev.orion.track_my_vehicle_application.test;

import tools.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
//        String date = "29-10-2026";
////        System.out.println(LocalDate.parse(date, MULTI_FORMATTER));
//
//        Form data = new Form("09953855461", "deviceId127", "MyDevice", "127.0.0.1");
       AuthRequestWithDevice req = new AuthRequestWithDevice(new AuthRequest("09953855461", "1iplA2XQ1F4cPI7MKer+DQDifL25CwYH34XLeueJ+FI="), new DeviceInformation("127.0.0.1", "MyDevice", "deviceId127"));
        ObjectMapper objectMapper = new ObjectMapper();
//        Map<String, String> data = Map.of("phone","09786396392","deviceId","deviceId127","deviceName","MyDevice","ipAddress","127.0.0.1");
        var dataJson = objectMapper.writeValueAsString(req);
        System.out.println(dataJson);
        long length = dataJson.getBytes().length;
        System.out.println(length);

//        System.out.println(percent(BigDecimal.valueOf(5555),  BigDecimal.valueOf(0.1)));

        System.err.println(fixAndPercent(BigDecimal.valueOf(5555), null, BigDecimal.valueOf(0.1)));


    }

//    public static BigDecimal percent(BigDecimal amount, BigDecimal percent) {
//        if (null == percent || percent.signum() == 0) {
//            return BigDecimal.ZERO;
//        }
//
//        return amount.divide(new BigDecimal(100)).multiply(percent);
////        BigDecimal result = amount.divide(new BigDecimal(100)).multiply(percent);
////        System.err.println(result+"=====================");
////        // Set scale to 2 and use RoundingMode.HALF_UP (5 and above goes up)
////        return result.setScale(2, RoundingMode.HALF_UP);
//    }

    public static BigDecimal percent(BigDecimal amount, BigDecimal percent) {
        if(null == percent || BigDecimal.ZERO == percent) {
            return BigDecimal.ZERO;
        }
        return amount.divide(new BigDecimal(100)).multiply(percent);
    }

    public static BigDecimal fixAndPercent(BigDecimal amount, BigDecimal fix, BigDecimal percent) {
        if(null != fix) {
            return fix.add(percent(amount, percent));
        }

        return percent(amount, percent);
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


 record AuthRequestWithDevice(

        AuthRequest request,
        DeviceInformation device
) {

}

 record AuthRequest(
        String username,
        String password
) {

}

 record DeviceInformation(
        String ipAddress,
        String device,
        String deviceId
) {

}