package it.uniroma2.dicii.ispw.gradely.model.role.student;

import it.uniroma2.dicii.ispw.gradely.dao_manager.DAOFactoryAbstract;
import it.uniroma2.dicii.ispw.gradely.dao_manager.DAOFactoryDB;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.model.title.Title;
import it.uniroma2.dicii.ispw.gradely.model.user.User;
import it.uniroma2.dicii.ispw.gradely.model.user.UserLazyFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentLazyFactory {
    private static StudentLazyFactory instance;
    private List<Student> students;

    private StudentLazyFactory(){
        students = new ArrayList<Student>();
    }

    public static synchronized StudentLazyFactory getInstance(){
        if (instance == null){
            instance = new StudentLazyFactory();
        }
        return instance;
    }

    public Student getStudentByUser(User user) throws DAOException {
        for (Student s : students) {
            if (s.getUser().equals(user)) {
                return s;
            }
        }
        return DAOFactoryDB.getInstance().getStudentDAO().getStudentByUser(user);
    }

    public Student newStudent(String name, String surname, String codiceFiscale, String email, String password, String matricola, LocalDate registrationDate, List<Title> titles) throws DAOException {
        User user = UserLazyFactory.getInstance().newUser(name, surname, codiceFiscale, email, password);
        Student student = new Student(user, matricola, registrationDate, titles);
        user.setRole(student);
        DAOFactoryAbstract.getInstance().getStudentDAO().insert(student);
        students.add(student);
        return student;
    }
}
