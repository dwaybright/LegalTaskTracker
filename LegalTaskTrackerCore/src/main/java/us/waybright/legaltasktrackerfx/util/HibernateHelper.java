package us.waybright.legaltasktrackerfx.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Daniel Waybright
 */
public final class HibernateHelper {
    private static final Logger LOG = LoggerFactory.getLogger(HibernateHelper.class);
    private static final SessionFactory SESSION_FACTORY;
    private static final Session SESSION;
    
    static {
        try {
            LOG.info("Building Hibernate SessionFactory ...");
            SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
            SESSION = SESSION_FACTORY.openSession();
            LOG.info("Build Hibernate SessionFactory - Success");
        } catch(HibernateException ex) {
            LOG.error("Build Hibernate SessionFactory - Failure", ex);
            throw ex;
        }
    }
    
    public static final void init() {
        // no op
    }
    
    public static final Session getSession() {
        return SESSION;
    }
    
    public static final void close() {
        LOG.info("Closing Hibernate SessionFactory ...");
        SESSION.close();
        SESSION_FACTORY.close();
        LOG.info("Hibernate SessionFactory Closed");
    }
}
