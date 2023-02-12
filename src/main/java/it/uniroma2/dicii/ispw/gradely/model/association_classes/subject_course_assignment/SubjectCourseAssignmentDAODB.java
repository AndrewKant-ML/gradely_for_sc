package it.uniroma2.dicii.ispw.gradely.model.association_classes.subject_course_assignment;

import it.uniroma2.dicii.ispw.gradely.instances_management_abstracts.DAODBAbstract;
import it.uniroma2.dicii.ispw.gradely.enums.ExceptionMessagesEnum;
import it.uniroma2.dicii.ispw.gradely.enums.SubjectCourseCodeEnum;
import it.uniroma2.dicii.ispw.gradely.exceptions.*;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.Professor;
import it.uniroma2.dicii.ispw.gradely.model.role.professor.ProfessorLazyFactory;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.SubjectCourse;
import it.uniroma2.dicii.ispw.gradely.model.subject_course.SubjectCourseLazyFactory;
import it.uniroma2.dicii.ispw.gradely.model.user.UserLazyFactory;

import java.sql.*;
import java.time.Year;
import java.util.List;


public class SubjectCourseAssignmentDAODB extends DAODBAbstract<SubjectCourseAssignment> implements SubjectCourseAssignmentDAOInterface {
protected static SubjectCourseAssignmentDAOInterface instance;

    private SubjectCourseAssignmentDAODB() {

    }

    public static synchronized SubjectCourseAssignmentDAOInterface getInstance() {
        if (instance == null) {
            instance = new SubjectCourseAssignmentDAODB();
        }
        return instance;
    }

    @Override
    public List<SubjectCourseAssignment> getCourseAssignmentsBySubjectCourse(SubjectCourse course, List<SubjectCourseAssignment> exclusions) throws DAOException, PropertyException, ResourceNotFoundException, ObjectNotFoundException, UnrecognizedRoleException, MissingAuthorizationException, WrongDegreeCourseCodeException, WrongListQueryIdentifierValue, UserNotFoundException {
        return getListQuery(
                "SUBJECT_COURSE_ASSIGNMENT",
                List.of("sc_code","sc_name","sc_cfu","sc_aa"),
                List.of(course.getCode().value,course.getName(),course.getCfu(), Date.valueOf(course.getAcademicYear().atDay(0))),
                exclusions,
                null,
                false
        );
    }

    @Override
    public List<SubjectCourseAssignment> getCourseAssignmentsByProfessor(Professor professor, List<SubjectCourseAssignment> exclusions) throws DAOException, PropertyException, ResourceNotFoundException, ObjectNotFoundException, UnrecognizedRoleException, MissingAuthorizationException, WrongDegreeCourseCodeException, WrongListQueryIdentifierValue, UserNotFoundException {
        return getListQuery(
                "SUBJECT_COURSE_ASSIGNMENT",
                List.of("professor"),
                List.of(professor.getCodiceFiscale()),
                exclusions,
                null,
                false
        );
    }

    @Override
    public void insert(SubjectCourseAssignment subjectCourseAssignment) throws DAOException, PropertyException, ResourceNotFoundException, MissingAuthorizationException {
        insertQuery(
                "SUBJECT_COURSE_ASSIGNMENT",
                List.of(subjectCourseAssignment.getProfessor().getCodiceFiscale(),subjectCourseAssignment.getSubjectCourse().getCode().value,subjectCourseAssignment.getSubjectCourse().getName(),subjectCourseAssignment.getSubjectCourse().getCfu(),Date.valueOf(subjectCourseAssignment.getSubjectCourse().getAcademicYear().atDay(0)))
        );
    }

    @Override
    public void delete(SubjectCourseAssignment subjectCourseAssignment) throws DAOException, PropertyException, ResourceNotFoundException {
        deleteQuery(
                "SUBJECT_COURSE_ASSIGNMENT",
                List.of("professor","sc_code","sc_name","sc_cfu","sc_aa"),
                List.of(subjectCourseAssignment.getProfessor().getCodiceFiscale(),subjectCourseAssignment.getSubjectCourse().getCode().value,subjectCourseAssignment.getSubjectCourse().getName(),subjectCourseAssignment.getSubjectCourse().getCfu(),Date.valueOf(subjectCourseAssignment.getSubjectCourse().getAcademicYear().atDay(0)))

        );
        
    }

    @Override
    public void update(SubjectCourseAssignment subjectCourseAssignment){

    }

    @Override
    protected SubjectCourseAssignment queryObjectBuilder(ResultSet rs, List<Object> objects) throws SQLException, DAOException, PropertyException, ResourceNotFoundException, UnrecognizedRoleException, UserNotFoundException, MissingAuthorizationException, WrongDegreeCourseCodeException, ObjectNotFoundException, WrongListQueryIdentifierValue {
        return new SubjectCourseAssignment(
                SubjectCourseLazyFactory.getInstance().getSubjectCourseByCodeNameCfuAndAcademicYear(SubjectCourseCodeEnum.getSubjectCourseCodeByValue(rs.getInt("sc_code")),rs.getString("sc_name"),rs.getInt("sc_cfu"),Year.of(rs.getDate("sc_aa").toLocalDate().getYear())),
                ProfessorLazyFactory.getInstance().getProfessorByUser(UserLazyFactory.getInstance().getUserByCodiceFiscale(rs.getString("professor")))
        );
    }

    @Override
    protected String setGetListQueryIdentifiersValue(SubjectCourseAssignment subjectCourseAssignment, int valueNumber) throws DAOException, WrongListQueryIdentifierValue {
        switch (valueNumber){
            case 0 -> {return subjectCourseAssignment.getProfessor().getCodiceFiscale();}
            case 1 -> {return String.valueOf(subjectCourseAssignment.getSubjectCourse().getCode().value);}
            case 2 -> {return subjectCourseAssignment.getSubjectCourse().getName();}
            case 3 -> {return String.valueOf(subjectCourseAssignment.getSubjectCourse().getCfu());}
            case 4 -> {return Date.valueOf(subjectCourseAssignment.getSubjectCourse().getAcademicYear().atDay(0)).toString();}
            default -> throw new WrongListQueryIdentifierValue(ExceptionMessagesEnum.WRONG_LIST_QUERY_IDENTIFIER_VALUE.message);
        }
    }
}
