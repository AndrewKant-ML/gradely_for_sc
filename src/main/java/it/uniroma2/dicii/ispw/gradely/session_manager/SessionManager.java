package it.uniroma2.dicii.ispw.gradely.session_manager;

import it.uniroma2.dicii.ispw.gradely.dao_manager.DAOFactoryAbstract;
import it.uniroma2.dicii.ispw.gradely.enums.FrontEndTypeEnum;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.PendingEvent;
import it.uniroma2.dicii.ispw.gradely.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static it.uniroma2.dicii.ispw.gradely.enums.FrontEndTypeEnum.JAVAFX;

public class SessionManager {
    private static SessionManager instance;
    private List<Session> activeSessions;
    private List<PendingEvent> pendingEvents;
    private SessionManager(){
        activeSessions = new ArrayList<Session>();
    }
    public static synchronized SessionManager getInstance(){
        if (instance == null){
            instance = new SessionManager();
        }
        return instance;
    }
    private Session getSession(User user){
        for(Session s : activeSessions){
            if(s.getUser().equals(user)){
                return s;
            }
        }
        return null;
    }

    private Session getSession(Token token){
        for(Session s : activeSessions){
            if(s.getToken().getKey().equals(token.getKey())){
                return s;
            }
        }
        return null;
    }
    public User getSessionUserByToken(Token token){
        Session s = getSession(token);
        if (s == null){
            return null;
        }
        return s.getUser();
    }
    public Token getSessionTokenByUser(User user){
        Session s = getSession(user);
        if (s == null){
            s = new Session(user, FrontEndTypeEnum.valueOf(System.getProperty("gradely.front_end_type")));  //TODO implementare
            activeSessions.add(s);
        }
        return s.getToken();
    }

    private void refreshPendingEvents(List<PendingEvent> pendingEvents) throws DAOException {
        for (PendingEvent p : DAOFactoryAbstract.getInstance().getPendingEventDAO().refresh(pendingEvents)){
            if (!pendingEvents.contains(p)){
                pendingEvents.add(p);
            }
        }

    }
    public List<PendingEvent> getPendingEventsByUser(User user) throws DAOException {
        refreshPendingEvents(pendingEvents);
        List<PendingEvent> list = new ArrayList<>();
        for (PendingEvent p : pendingEvents){
            if (p.isForUser(user)){
                list.add(p);
            }
        }
        return list;
    }

    public void setPendingEvents(List<PendingEvent> pendingEvents){
        this.pendingEvents = pendingEvents;
    }

    public Boolean checkUUID(UUID id) throws DAOException {
        refreshPendingEvents(pendingEvents);
        for(PendingEvent event : pendingEvents){
            if(id.equals(event.getId())){
                return true;
            }
        }
        return false;
    }

}
