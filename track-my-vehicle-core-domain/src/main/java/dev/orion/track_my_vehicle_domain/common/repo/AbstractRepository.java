package dev.orion.track_my_vehicle_domain.common.repo;

import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@NoRepositoryBean
public interface AbstractRepository<T, ID> extends JpaRepositoryImplementation<T, ID> {

    <R> Page<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, int page, int size);
    <R> Page<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, Function<CriteriaBuilder ,CriteriaQuery<Long>> countFunc, int page, int size);
    <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, int limit);
    <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc);

    <R> Optional<R> findOne(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc);
    Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFunc);

    int update(Function<CriteriaBuilder, CriteriaUpdate<T>> updateFunc);
    int delete(Function<CriteriaBuilder, CriteriaDelete<T>> deleteFunc);

    T lock(T entity, LockModeType lockModeType);
}
