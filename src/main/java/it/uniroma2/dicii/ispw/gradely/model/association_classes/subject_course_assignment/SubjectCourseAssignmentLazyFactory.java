package it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_assignment;

import it.uniroma2.dicii.ispw.gradely.dao_manager.DAOFactoryAbstract;
import it.uniroma2.dicii.ispw.gradely.enums.ExceptionMessagesEnum;
import it.uniroma2.dicii.ispw.gradely.exceptions.DAOException;
import it.uniroma2.dicii.ispw.gradely.exceptions.PropertyException;
import it.uniroma2.dicii.ispw.gradely.exceptions.ResourceNotFoundException;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.Professor;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.SubjectCourse;

import java.util.ArrayList;
import java.util.List;

public class SubjectCourseAssignmentLazyFactory {
    private static SubjectCourseAssignmentLazyFactory instance;
    private final List<SubjectCourseAssignment> subjectCourseAssignments;

    private SubjectCourseAssignmentLazyFactory(){
        subjectCourseAssignments = new ArrayList<SubjectCourseAssignment>();
    }

    public static synchronized SubjectCourseAssignmentLazyFactory getInstance(){
        if (instance == null){
            instance = new SubjectCourseAssignmentLazyFactory();
        }
        return instance;
    }

    public SubjectCourseAssignment getCourseAssignmentBySubjectCourse(SubjectCourse course) throws DAOException {
        for(SubjectCourseAssignment c : subjectCourseAssignments){
            if(c.getSubjectCourse().equals(course)){
                return c;
            }
        }
        try {
            return DAOFactoryAbstract.getInstance().getCourseAssignmentDAO().getCourseAssignmentBySubjectCourse(course);
        } catch (ResourceNotFoundException | PropertyException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }
    }

    public List<SubjectCourseAssignment> getCourseAssignmentsByProfessor(Professor professor) throws DAOException {
        List<SubjectCourseAssignment> list = new ArrayList<>();
        for(SubjectCourseAssignment c : subjectCourseAssignments){
            if(c.getProfessor().equals(professor)){
                list.add(c);
            }
        }
        try {
            List<SubjectCourseAssignment> daoList = DAOFactoryAbstract.getInstance().getCourseAssignmentDAO().getCourseAssignmentsByProfessor(professor);
            for (SubjectCourseAssignment c : daoList) {
                if (!list.contains(c)) {
                    list.add(c);
                }
            }
        } catch (PropertyException | ResourceNotFoundException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }
        return list;
    }
    public List<SubjectCourse> getAssignedSubjectCoursesByProfessor(Professor professor) throws DAOException {
        List<SubjectCourse> list = new ArrayList<>();
        for(SubjectCourseAssignment c : subjectCourseAssignments){
            if(c.getProfessor().equals(professor)){
                list.add(c.getSubjectCourse()); 
            }
        }
        try {
            List<SubjectCourseAssignment> daoList = DAOFactoryAbstract.getInstance().getCourseAssignmentDAO().getCourseAssignmentsByProfessor(professor);
            for (SubjectCourseAssignment c : daoList) {
                if (!list.contains(c.getSubjectCourse())) {
                    list.add(c.getSubjectCourse());
                }
            }
        } catch (PropertyException | ResourceNotFoundException e) {
            throw new DAOException(ExceptionMessagesEnum.DAO.message, e);
        }
        return list;
    }
}