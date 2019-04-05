package com.bolivarSoftware.eTurnos.dao;

import org.hibernate.Session;

public class CloseableSession implements AutoCloseable{

    private final Session session;

    public CloseableSession(Session session) {
        this.session = session;
    }

    public Session delegate() {
        return session;
    }

    @Override
    public void close() {
        if(session != null && session.isOpen()){
            session.close();
        }
    }
}
