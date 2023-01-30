package it.uniroma2.dicii.ispw.gradely.dao_factories;

import it.uniroma2.dicii.ispw.gradely.model.association_classes.course_assignment.dao.AbstractCourseAssignmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.course_assignment.dao.CourseAssignmentDAODB;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.degree_course_enrollment.dao.AbstractDegreeCourseEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.degree_course_enrollment.dao.DegreeCourseEnrollmentDAODB;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.exam_enrollment.exam_enrollment.AbstractExamEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.exam_enrollment.exam_enrollment.ExamEnrollmentDAODB;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_enrollment.subject_course_enrollment.AbstractSubjectCourseEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_enrollment.subject_course_enrollment.SubjectCourseEnrollmentDAODB;
import it.uniroma2.dicii.ispw.gradely.model.degree_course.dao.AbstractDegreeCourseDAO;
import it.uniroma2.dicii.ispw.gradely.model.degree_course.dao.DegreeCourseDAODB;
import it.uniroma2.dicii.ispw.gradely.model.exam.dao.AbstractExamDAO;
import it.uniroma2.dicii.ispw.gradely.model.exam.dao.ExamDAODB;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.dao.AbstractPendingEventDAO;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.dao.PendingEventDAODB;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.dao.AbstractProfessorDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.dao.ProfessorDAODB;
import it.uniroma2.dicii.ispw.gradely.model.role.secretary.dao.AbstractSecretaryDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.secretary.dao.SecretaryDAODB;
import it.uniroma2.dicii.ispw.gradely.model.role.student.dao.AbstractStudentDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.student.dao.StudentDAODB;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.dao.AbstractSubjectCourseDAO;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.dao.SubjectCourseDAODB;
import it.uniroma2.dicii.ispw.gradely.model.user.dao.UserDAOAbstract;
import it.uniroma2.dicii.ispw.gradely.model.user.dao.UserDAODB;

public class DAOFactoryDB extends DAOFactory{
    public AbstractCourseAssignmentDAO getCourseAssignmentDAO(){
        return CourseAssignmentDAODB.getInstance();
    }
    public AbstractDegreeCourseEnrollmentDAO getDegreeCourseEnrollmentDAO(){
        return DegreeCourseEnrollmentDAODB.getInstance();
    }
    public AbstractExamEnrollmentDAO getExamEnrollmentDAO(){
        return ExamEnrollmentDAODB.getInstance();
    }
    public AbstractSubjectCourseEnrollmentDAO getSubjectCourseEnrollmentDAO(){
        return SubjectCourseEnrollmentDAODB.getInstance();
    }
    public AbstractDegreeCourseDAO getDegreeCourseDAO(){
        return DegreeCourseDAODB.getInstance();
    }
    public AbstractExamDAO getExamDAO(){
        return ExamDAODB.getInstance();
    }
    public AbstractPendingEventDAO getPendingEventDAO(){
        return PendingEventDAODB.getInstance();
    }
    public AbstractProfessorDAO getProfessorDAO(){
        return ProfessorDAODB.getInstance();
    }
    public AbstractSecretaryDAO getSecretaryDAO(){
        return SecretaryDAODB.getInstance();
    }
    public AbstractStudentDAO getStudentDAO(){
        return StudentDAODB.getInstance();
    }
    public AbstractSubjectCourseDAO getSubjectCourseDAO(){
        return SubjectCourseDAODB.getInstance();
    }
    public UserDAOAbstract getUserDAO(){
        return UserDAODB.getInstance();
    }
}
