package it.uniroma2.dicii.ispw.gradely.use_cases.login;

import it.uniroma2.dicii.ispw.gradely.exceptions.EmailFormatException;
import it.uniroma2.dicii.ispw.gradely.lazy_factories.UserLazyFactory;
import it.uniroma2.dicii.ispw.gradely.model.User;
import it.uniroma2.dicii.ispw.gradely.session_manager.SessionManager;
import it.uniroma2.dicii.ispw.gradely.session_manager.Token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginControl {
    public Token login(String email, String password) throws Exception{
        User user = UserLazyFactory.getInstance().getUserByEmail(email); //TODO implementare exception
        if(user.getPassword().equals(password)){// TODO implementare ricerca utente nel DAO
            return SessionManager.getInstance().getSessionTokenByUser(user);
        }
        else throw new Exception(); //TODO implementare exception
    }

    public void emailMatches(String email) throws EmailFormatException {
        final Pattern emailPattern = Pattern.compile("^\\w+(\\.-\\w)*@\\w+(\\.-\\w+)*(\\.\\w{2,3})+$");
        final Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches())
            throw new EmailFormatException("Please insert an email with a correct format");
    }
}
