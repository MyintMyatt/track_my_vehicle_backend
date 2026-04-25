package dev.orion.track_my_vehicle_domain.way.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class CarWayPK {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "all_seq_number")
    private int all_seq;

    @Column(name = "one_day_seq")
    private int one_seq;

    public String code(){
        return "%s-%06d-%03d".formatted(createdAt.format(formatter), all_seq, one_seq);
    }

    public static  CarWayPK from(String code){
        try{
            var arr = code.split("-");
            var pk = new CarWayPK(LocalDateTime.parse(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
            return  pk;
        }catch (RuntimeException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
