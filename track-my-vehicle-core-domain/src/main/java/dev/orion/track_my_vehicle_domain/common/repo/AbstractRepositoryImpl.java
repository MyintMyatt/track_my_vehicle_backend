package dev.orion.track_my_vehicle_domain.common.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AbstractRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements AbstractRepository<T, ID> {

    private final EntityManager entityManager;

    public AbstractRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public <R> Page<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, int page, int size) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        var total = query.getResultList().size();
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return new PageImpl<R>(query.getResultList(), PageRequest.of(page, size), total);
    }

    @Override
    public <R> Page<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, Function<CriteriaBuilder, CriteriaQuery<Long>> countFunc, int page, int size) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        var total = count(countFunc);
        query.setFirstResult(page * size);
        query.setMaxResults(size);
        return new PageImpl<R>(query.getResultList(), PageRequest.of(page, size), total);
    }

    @Override
    public <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc, int limit) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public <R> Optional<R> findOne(Function<CriteriaBuilder, CriteriaQuery<R>> queryFunc) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFunc) {
        var criteriaQuery = queryFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Override
    public int update(Function<CriteriaBuilder, CriteriaUpdate<T>> updateFunc) {
        var criteriaQuery = updateFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        return query.executeUpdate();
    }

    @Override
    public int delete(Function<CriteriaBuilder, CriteriaDelete<T>> deleteFunc) {
        var criteriaQuery = deleteFunc.apply(entityManager.getCriteriaBuilder());
        var query = entityManager.createQuery(criteriaQuery);
        return query.executeUpdate();
    }

    @Override
    public T lock(T entity, LockModeType lockModeType){
        entityManager.refresh(entity, lockModeType);
        return entity;
    }
}
