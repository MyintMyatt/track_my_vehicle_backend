package dev.orion.track_my_vehicle_application.test;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

    public static void main(String[] args) throws FileNotFoundException {
//        String date = "29-10-2026";
////        System.out.println(LocalDate.parse(date, MULTI_FORMATTER));
//
//        Form data = new Form("09953855461", "deviceId127", "MyDevice", "127.0.0.1");
       AuthRequestWithDevice req = new AuthRequestWithDevice(new AuthRequest("09953855461", "z5i10lveWV50XP18OPrzRPabb9O7nP4hgNYBEP9C/os="), new DeviceInformation("127.0.0.1", "MyDevice", "deviceId127"));
        ObjectMapper objectMapper = new ObjectMapper();
////        Map<String, String> data = Map.of("phone","09786396392","deviceId","deviceId127","deviceName","MyDevice","ipAddress","127.0.0.1");
        var dataJson = objectMapper.writeValueAsString(req);
        System.out.println(dataJson);
        long length = dataJson.getBytes().length;
        System.out.println(length);

        InputStream is = Main.class.getClassLoader().getResourceAsStream("essdata.json");

        JsonNode node = objectMapper.readTree(is);
        System.err.println(node.toPrettyString());
//toString
////        System.out.println(percent(BigDecimal.valueOf(5555),  BigDecimal.valueOf(0.1)));

//        System.err.println(fixAndPercent(BigDecimal.valueOf(5555), BigDecimal.valueOf(1000), BigDecimal.valueOf(0.1)));


//        System.out.println(validPhoneFormat("094002341"));;
//
        var instant = LocalDateTime.now().withNano(0).atZone(ZoneId.systemDefault()).toInstant();
        System.err.println(instant.toEpochMilli());
    }

    public static BigDecimal percent(BigDecimal amount, BigDecimal percent) {
        if(null == percent || BigDecimal.ZERO == percent) {
            return BigDecimal.ZERO;
        }
        return amount.divide(new BigDecimal(100)).multiply(percent).setScale(2, RoundingMode.HALF_UP);
    }
//
//    public static BigDecimal percent(BigDecimal amount, BigDecimal percent) {
//        if(null == percent || BigDecimal.ZERO == percent) {
//            return BigDecimal.ZERO;
//        }
//        return amount.divide(new BigDecimal(100)).multiply(percent);
//    }

    public static BigDecimal fixAndPercent(BigDecimal amount, BigDecimal fix, BigDecimal percent) {
        if(null != fix) {
            return fix.add(percent(amount, percent)).setScale(2, RoundingMode.HALF_UP);
        }

        return percent(amount, percent);
    }

    private static boolean validPhoneFormat(String phone) {
        String atom = "^(09|\\+?959)7(9|8|7|6|5|4|2|1)\\d{7}$";
        String mpt = "^(09|\\+?959)(2(0|1|2|3|4)\\d{5}|25\\d{7}|26\\d{7}|4(0|1|2|3|4|5|6|7|8|9)\\d{6,7}|5(0|1|2|3|4|5|6)\\d{5}|7(3)\\d{6}|8(3|4|5|6|7|8|9)\\d{5,7})$";
        String ooredoo = "^(09|\\+?959)9(9|8|7|6|5|4|3|2|1)\\d{7}$";
        String mytel = "^(09|\\+?959)6(1|2|3|4|5|6|7|8|9)\\d{7}$";

        return phone.matches(atom)
                || phone.matches(mpt)
                || phone.matches(ooredoo)
                || phone.matches(mytel);
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



