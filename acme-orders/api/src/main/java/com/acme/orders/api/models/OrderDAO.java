package com.acme.orders.api.models;

import com.acme.orders.api.models.db.OrderEntity;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * The type Order dao. Data Access Object implemetation.
 */
public class OrderDAO extends AbstractDAO<OrderEntity> {

    //add timer to analyse calls performance
    private Timer findAllTimer;

    /**
     * Instantiates a new Order dao.
     *
     * @param sessionFactory the session factory
     * @param metricRegistry the metric registry
     */
    public OrderDAO(SessionFactory sessionFactory, MetricRegistry metricRegistry) {
        super(sessionFactory);

        //instantiate the find all time to analyse how long the find all mehod is taking
        this.findAllTimer = metricRegistry.timer(OrderDAO.class.getName() + ".query-find-all");
    }

    /**
     * Find all list.
     *
     * @param limit  the limit
     * @param offset the offset
     * @return the list
     */
    @SuppressWarnings("unchecked")
    public List<OrderEntity> findAll(Integer limit, Integer offset) {

        Query<OrderEntity> query = namedQuery("OrderEntity.findAll");

        if (limit != null && limit > 0) {
            query = query.setMaxResults(limit);
        }
        if (offset != null && offset > 0) {
            query = query.setFirstResult(offset);
        }

        //create the timer to start recording the time
        final Timer.Context context = findAllTimer.time();

        try {
            return list(query);
        } finally {
            //stop tracking the time regardless if fails, then return the context
            context.stop();
        }
    }

    /**
     * Find all count long.
     *
     * @return the long
     */
    public Long findAllCount() {
        return (Long) namedQuery("OrderEntity.findAllCount").uniqueResult();
    }

    /**
     * Find by id order entity.
     *
     * @param id the id
     * @return the order entity
     */
    public OrderEntity findById(String id) {
        return get(id);
    }

    /**
     * Create order entity.
     *
     * @param order the order
     * @return the order entity
     */
    public OrderEntity create(OrderEntity order) {
        return persist(order);
    }
}
