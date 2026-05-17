package dev.orion.track_my_vehicle_domain.keyGenerator;

import dev.orion.track_my_vehicle_domain.way.entity.CarWay;
import dev.orion.track_my_vehicle_domain.way.pk.CarWayPK;
import dev.orion.track_my_vehicle_domain.way.repo.CarWayRepo;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CarWayKeyGenerator {

    private final CarWayRepo repo;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public CarWayPK next(LocalDate now) {
        if (repo.count() > 0){
            long seq = repo.count(countFunc(now));
            return CarWayPK.from(now, ++seq, repo.count() + 1);
        }

        return CarWayPK.from(now, 1, 1);
    }

    private Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc(LocalDate date) {
        return cb -> {
            var cq = cb.createQuery(Long.class);
            var root = cq.from(CarWay.class);
            cq.select(cb.count(root.get("id")));
            cq.where(cb.equal(root.get("id").get("requestedAt"), date));

            return cq;
        };
    }
}
