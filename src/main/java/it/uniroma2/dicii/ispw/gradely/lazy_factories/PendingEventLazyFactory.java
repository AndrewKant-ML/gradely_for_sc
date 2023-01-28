package it.uniroma2.dicii.ispw.gradely.lazy_factories;

import it.uniroma2.dicii.ispw.gradely.daos.abstracts.AbstractPendingEventDAO;
import it.uniroma2.dicii.ispw.gradely.model.PendingEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PendingEventLazyFactory {
    private static PendingEventLazyFactory instance;
    private List<PendingEvent> pendingEvents;

    private PendingEventLazyFactory(){
        pendingEvents = new ArrayList<PendingEvent>();
    }

    public static PendingEventLazyFactory getInstance(){
        if (instance == null) {
            instance = new PendingEventLazyFactory();
        }
        return instance;
    }

    public PendingEvent getPendingEventById(UUID id) {
        for(PendingEvent p : pendingEvents){
            if(p.getId().equals(id)) {
                return p; //TODO implementare exception
            }
        }
        return AbstractPendingEventDAO.getInstance().getPendingEventById(id); //TODO implementare exception
    }

}
