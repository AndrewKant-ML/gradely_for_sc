package it.uniroma2.dicii.ispw.gradely.model.timer;

import it.uniroma2.dicii.ispw.gradely.exceptions.*;

import java.util.List;

public class TimerDAOFS implements TimerDAOInterface {
    protected static TimerDAOInterface instance;

    private TimerDAOFS(){
        super();
    }

    public static synchronized TimerDAOInterface getInstance(){
        if (instance == null){
            instance = new TimerDAOFS();
        }
        return instance;
    }


    public void insert(AbstractTimer timer){

    }

    public void delete(AbstractTimer timer){

    }

    public void update(AbstractTimer timer){

    }

    @Override
    public List<AbstractTimer> getAllTimers(List<AbstractTimer> list) throws UserNotFoundException, DAOException, PropertyException, WrongListQueryIdentifierValue, ObjectNotFoundException, ResourceNotFoundException, UnrecognizedRoleException, MissingAuthorizationException, WrongDegreeCourseCodeException {
        return null;
    }
}
