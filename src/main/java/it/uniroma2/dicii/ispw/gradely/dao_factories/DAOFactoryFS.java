package it.uniroma2.dicii.ispw.gradely.dao_factories;

import it.uniroma2.dicii.ispw.gradely.model.association_classes.course_assignment.dao.AbstractCourseAssignmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.course_assignment.dao.CourseAssignmentDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.degree_course_enrollment.dao.AbstractDegreeCourseEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.degree_course_enrollment.dao.DegreeCourseEnrollmentDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.exam_enrollment.dao.AbstractExamEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.exam_enrollment.dao.ExamEnrollmentDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_enrollment.dao.AbstractSubjectCourseEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_enrollment.dao.SubjectCourseEnrollmentDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.degree_course.dao.AbstractDegreeCourseDAO;
import it.uniroma2.dicii.ispw.gradely.model.degree_course.dao.DegreeCourseDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.exam.dao.AbstractExamDAO;
import it.uniroma2.dicii.ispw.gradely.model.exam.dao.ExamDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.exam_result.dao.AbstractExamResultDAO;
import it.uniroma2.dicii.ispw.gradely.model.exam_result.dao.ExamResultDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.dao.AbstractPendingEventDAO;
import it.uniroma2.dicii.ispw.gradely.model.pending_events.dao.PendingEventDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.dao.AbstractProfessorDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.dao.ProfessorDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.role.secretary.dao.AbstractSecretaryDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.secretary.dao.SecretaryDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.role.student.dao.AbstractStudentDAO;
import it.uniroma2.dicii.ispw.gradely.model.role.student.dao.StudentDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.dao.SubjectCourseDAOAbstract;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.dao.SubjectCourseDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.timer.dao.TimerDAOAbstract;
import it.uniroma2.dicii.ispw.gradely.model.timer.dao.TimerDAOFS;
import it.uniroma2.dicii.ispw.gradely.model.user.dao.UserDAOAbstract;
import it.uniroma2.dicii.ispw.gradely.model.user.dao.UserDAOFS;

public class DAOFactoryFS extends DAOFactoryAbstract {
    @Override
    public AbstractCourseAssignmentDAO getCourseAssignmentDAO(){
        return CourseAssignmentDAOFS.getInstance();
    }
    @Override
    public AbstractDegreeCourseEnrollmentDAO getDegreeCourseEnrollmentDAO(){
        return DegreeCourseEnrollmentDAOFS.getInstance();
    }
    @Override
    public AbstractExamEnrollmentDAO getExamEnrollmentDAO(){
        return ExamEnrollmentDAOFS.getInstance();
    }
    @Override
    public AbstractSubjectCourseEnrollmentDAO getSubjectCourseEnrollmentDAO(){
        return SubjectCourseEnrollmentDAOFS.getInstance();
    }
    @Override
    public AbstractDegreeCourseDAO getDegreeCourseDAO(){
        return DegreeCourseDAOFS.getInstance();
    }
    @Override
    public AbstractExamDAO getExamDAO(){
        return ExamDAOFS.getInstance();
    }
    @Override
    public AbstractExamResultDAO getExamResultDAO() {
        return ExamResultDAOFS.getInstance();
    }
    @Override
    public AbstractPendingEventDAO getPendingEventDAO(){
        return PendingEventDAOFS.getInstance();
    }
    @Override
    public AbstractProfessorDAO getProfessorDAO(){
        return ProfessorDAOFS.getInstance();
    }
    @Override
    public AbstractSecretaryDAO getSecretaryDAO(){
        return SecretaryDAOFS.getInstance();
    }
    @Override
    public AbstractStudentDAO getStudentDAO(){
        return StudentDAOFS.getInstance();
    }
    @Override
    public SubjectCourseDAOAbstract getSubjectCourseDAO(){
        return SubjectCourseDAOFS.getInstance();
    }
    @Override
    public TimerDAOAbstract getTimerDAO() {
        return TimerDAOFS.getInstance();
    }
    @Override
    public UserDAOAbstract getUserDAO(){
        return UserDAOFS.getInstance();
    }
}
