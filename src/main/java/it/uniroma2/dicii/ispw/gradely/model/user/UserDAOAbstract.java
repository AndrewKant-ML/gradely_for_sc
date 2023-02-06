package it.uniroma2.dicii.ispw.gradely.model.user;

import it.uniroma2.dicii.ispw.gradely.dao_interface.DAOInterface;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.exceptions.UserNotFoundException;

public abstract class UserDAOAbstract implements DAOInterface <User> {
    protected static UserDAOAbstract instance;

    protected UserDAOAbstract(){
    }

    abstract User getUserByEmail(String email) throws UserNotFoundException, DAOException;
}