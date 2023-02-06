package it.uniroma2.dicii.ispw.gradely.session_manager;

import it.uniroma2.dicii.ispw.gradely.PropertiesHandler;
import it.uniroma2.dicii.ispw.gradely.dao_manager.DAOFactoryAbstract;
import it.uniroma2.dicii.ispw.gradely.enums.ExceptionMessagesEnum;
import it.uniroma2.dicii.ispw.gradely.enums.FrontEndTypeEnum;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.exceptions.PropertyException;
import it.uniroma2.dicii.ispw.gradely.exceptions.ResourceNotFoundException;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.AbstractPendingEvent;
import it.uniroma2.dicii.ispw.gradely.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SessionManager {
    private static SessionManager instance;
    private final List<Session> activeSessions;
    private List<AbstractPendingEvent> abstractPendingEvents;

    private SessionManager() {
        activeSessions = new ArrayList<>();
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Session getSession(User user) {
        for (Session s : activeSessions) {
            if (s.getUser().equals(user)) {
                return s;
            }
        }
        return null;
    }
    private Session getSession(String tokenKey) {
        for (Session s : activeSessions) {
            if (s.getToken().getKey().equals(tokenKey)) {
                return s;
            }
        }
        return null;
    }

    public User getSessionUserByTokenKey(String tokenKey) {
        Session s = getSession(tokenKey);
        if (s == null) {
            return null;
        }
        return s.getUser();
    }

    public String getSessionTokenKeyByUser(User user) throws ResourceNotFoundException, PropertyException {
        Session s = getSession(user);
        if (s == null) {
            FrontEndTypeEnum frontEndType = FrontEndTypeEnum.getFrontEndTypeByValue(PropertiesHandler.getInstance().getProperty("front_end_type"));
            s = new Session(user, frontEndType);  //TODO implementare
            activeSessions.add(s);
        }
            return s.getToken().getKey();
        }

    private void refreshPendingEvents(List<AbstractPendingEvent> abstractPendingEvents) throws DAOException {
        try {
            for (AbstractPendingEvent p : DAOFactoryAbstract.getInstance().getPendingEventDAO().refresh(abstractPendingEvents)) {
                if (!abstractPendingEvents.contains(p)) {
                    abstractPendingEvents.add(p);
                }
            }
        } catch (ResourceNotFoundException | PropertyException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }

    }
    public List<AbstractPendingEvent> getPendingEventsByUser(User user) throws DAOException {
        refreshPendingEvents(abstractPendingEvents);
        List<AbstractPendingEvent> list = new ArrayList<>();
        for (AbstractPendingEvent p : abstractPendingEvents){
            if (p.isForUser(user)){
                list.add(p);
            }
        }
        return list;
    }

    public void setPendingEvents(List<AbstractPendingEvent> abstractPendingEvents){
        this.abstractPendingEvents = abstractPendingEvents;
    }

    public Boolean checkUUID(UUID id) throws DAOException {
        refreshPendingEvents(abstractPendingEvents);
        for(AbstractPendingEvent event : abstractPendingEvents){
            if(id.equals(event.getId())){
                return true;
            }
        }
        return false;
    }

}
