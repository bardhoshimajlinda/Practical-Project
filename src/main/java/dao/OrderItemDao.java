package dao;

import entities.OrderItem;
import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.DatabaseUtils.getFactory;

public class OrderItemDao extends BaseDao {
    public OrderItem create(OrderItem order) {
        Transaction transaction = null;
        try (Session session = getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
            return order;
        }
    }
}
