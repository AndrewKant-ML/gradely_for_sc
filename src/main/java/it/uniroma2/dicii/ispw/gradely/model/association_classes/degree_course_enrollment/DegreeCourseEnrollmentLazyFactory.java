package it.uniroma2.dicii.ispw.gradely.model.association_classes.degree_course_enrollment;

import it.uniroma2.dicii.ispw.gradely.dao_factories.DAOFactoryAbstract;
import it.uniroma2.dicii.ispw.gradely.model.degree_course.DegreeCourse;
import it.uniroma2.dicii.ispw.gradely.model.role.student.Student;

import java.util.ArrayList;
import java.util.List;

public class DegreeCourseEnrollmentLazyFactory {
    private static DegreeCourseEnrollmentLazyFactory instance;
    private List<DegreeCourseEnrollment> degreeCourseEnrollments;

    private DegreeCourseEnrollmentLazyFactory(){
        degreeCourseEnrollments = new ArrayList<DegreeCourseEnrollment>();
    }

    public static DegreeCourseEnrollmentLazyFactory getInstance(){
        if (instance == null) {
            instance = new DegreeCourseEnrollmentLazyFactory();
        }
        return instance;
    }

    public List<DegreeCourseEnrollment> getDegreeCourseEnrollmentsByDegreeCourse(DegreeCourse course) {
        List<DegreeCourseEnrollment> list = new ArrayList<>();
        for(DegreeCourseEnrollment e : degreeCourseEnrollments){
            if(e.getDegreeCourse().equals(course)) {
                list.add(e); //TODO implementare exception
            }
        }
        List<DegreeCourseEnrollment> daoList = DAOFactoryAbstract.getDAOFactory().getDegreeCourseEnrollmentDAO().getDegreeCourseEnrollmentsByDegreeCourse(course); //TODO implementare exception
        for(DegreeCourseEnrollment e : daoList){
            if(!list.contains(e)) {
                list.add(e); //TODO implementare exceptions
            }
        }
        return list;
    }

    public List<DegreeCourseEnrollment> getDegreeCourseEnrollmentsByStudent(Student student) {
        List<DegreeCourseEnrollment> list = new ArrayList<>();
        for(DegreeCourseEnrollment e : degreeCourseEnrollments){
            if(e.getStudent().equals(student)) {
                list.add(e); //TODO implementare exception
            }
        }
        List<DegreeCourseEnrollment> daoList = DAOFactoryAbstract.getDAOFactory().getDegreeCourseEnrollmentDAO().getDegreeCourseEnrollmentsByStudent(student); //TODO implementare exception
        for(DegreeCourseEnrollment e : daoList){
            if(!list.contains(e)) {
                list.add(e); //TODO implementare exceptions
            }
        }
        return list;
    }

    public Boolean checkDegreeCourseEnrollmentPresence(Student student, DegreeCourse course){
        List<DegreeCourseEnrollment> list = getDegreeCourseEnrollmentsByStudent(student);
        for(DegreeCourseEnrollment e : list){
            if(!e.getDegreeCourse().equals(course)) {
                return true; //TODO implementare exceptions
            }
        }
        return false;
    }
}