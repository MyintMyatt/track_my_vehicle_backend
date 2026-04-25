package dev.orion.track_my_vehicle_domain.pk;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Builder
@Data
@AllArgsConstructor
@Embeddable
public class BaseChangeReqPk {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private LocalDate createAt;
    private int allSeq;
    private int todaySeq;

    public String code(){
        return "%s-%06d-%03d".formatted(createAt.format(formatter), allSeq, todaySeq);
    }

    public BaseChangeReqPk from(String code){
        try{
            var arr = code.split("-");
            return new BaseChangeReqPk(LocalDate.parse(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
