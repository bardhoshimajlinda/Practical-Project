package dao;

import entities.Menu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Optional;

import static utils.DatabaseUtils.getFactory;

public class MenuDao extends BaseDao {

    public MenuDao() {
        super();
    }
    public void save(Menu student) {
        Transaction transaction = null;
        try (Session session = getFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        }
    }
    public void saveIfAbsent(Menu menu) {
        Transaction transaction;
        try (Session session = getFactory().openSession()) {
            transaction = session.beginTransaction();
            Optional<Menu> dbItem = session.createQuery("from Menu m where m.name = :name", Menu.class)
                    .setParameter("name", menu.getName()).stream().findFirst();
            if (dbItem.isEmpty()) {
                session.persist(menu);
            }
            transaction.commit();
        }
    }

    public List<Menu> getMenu() {
        try (Session session = getFactory().openSession()) {
            return session.createQuery("from Menu", Menu.class).list();
        }
    }

    public Optional<Menu> getById(int id) {
        try (Session session = getFactory().openSession()) {
            return session.createQuery("from Menu o where o.id = :id", Menu.class)
                    .setParameter("id", id)
                    .stream().findFirst();
        }
    }
}
