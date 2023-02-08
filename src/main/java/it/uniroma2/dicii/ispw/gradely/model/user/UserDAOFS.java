package it.uniroma2.dicii.ispw.gradely.model.user;

import com.opencsv.exceptions.CsvException;
import it.uniroma2.dicii.ispw.gradely.CSVParser;
import it.uniroma2.dicii.ispw.gradely.enums.ExceptionMessagesEnum;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.exceptions.PropertyException;
import it.uniroma2.dicii.ispw.gradely.exceptions.ResourceNotFoundException;
import it.uniroma2.dicii.ispw.gradely.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;

public class UserDAOFS extends UserDAOAbstract {

    private final String fileName = "user";

    private UserDAOFS() {
        super();
    }

    public static synchronized UserDAOAbstract getInstance() {
        if (instance == null) {
            instance = new UserDAOFS();
        }
        return instance;
    }

    /**
     * Creates a User from a given csv file line
     *
     * @param line the csv file line
     * @return a User instance
     */
    private User getUserByLine(List<String> line) {
        return new User(
                line.get(1),
                line.get(2),
                line.get(0),
                line.get(3),
                line.get(4),
                LocalDate.parse(line.get(5))
        );
    }

    User getUserByEmail(String email) throws UserNotFoundException, DAOException, ResourceNotFoundException {
        try {
            List<List<String>> lines = new CSVParser().readAllLines(fileName);
            for (List<String> line : lines) {
                if (line.get(3).equals(email))
                    return getUserByLine(line);
            }
            throw new UserNotFoundException(ExceptionMessagesEnum.USER_NOT_FOUND.message);
        } catch (CsvException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }
    }

    @Override
    User getUserByCodiceFiscale(String codiceFiscale) throws UserNotFoundException, DAOException, PropertyException, ResourceNotFoundException {
        try {
            List<List<String>> lines = new CSVParser().readAllLines(fileName);
            for (List<String> line : lines) {
                if (line.get(0).equals(codiceFiscale))
                    return getUserByLine(line);
            }
            throw new UserNotFoundException(ExceptionMessagesEnum.USER_NOT_FOUND.message);
        } catch (CsvException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }
    }

    @Override
    public void insert(User user) throws DAOException {
        //TODO implementare query
    }

    @Override
    public void cancel(User user) throws DAOException {

    }

    @Override
    public void update(User user) throws DAOException {
        //TODO implementare query
    }

    @Override
    public List<User> refresh(List<User> users) throws DAOException {
        //TODO implementare query
        return null;
    }


}
