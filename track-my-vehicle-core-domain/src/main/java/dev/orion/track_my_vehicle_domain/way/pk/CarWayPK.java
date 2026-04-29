package dev.orion.track_my_vehicle_domain.way.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CarWayPK {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Column(name = "requested_at")
    private LocalDate requestedAt;

    @Column(name = "all_seq_number")
    private int allSeqNumber;

    @Column(name = "one_day_seq")
    private int oneDaySeq;

    public String code(){
        return "%s-%06d-%03d".formatted(requestedAt.format(formatter), allSeqNumber, oneDaySeq);
    }

    public static  CarWayPK from(String code){
        try{
            var arr = code.split("-");
            return new CarWayPK(LocalDate.parse(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
        }catch (RuntimeException e){
            throw new RuntimeException();
        }
    }
}
