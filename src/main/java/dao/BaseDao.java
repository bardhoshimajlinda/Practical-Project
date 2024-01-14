package dao;

import org.hibernate.SessionFactory;
import utils.DatabaseUtils;

public class BaseDao {
    public static SessionFactory sessionFactory = null;

    public BaseDao() {
        if (sessionFactory == null) {
            sessionFactory = DatabaseUtils.getFactory();
        }
    }
}
