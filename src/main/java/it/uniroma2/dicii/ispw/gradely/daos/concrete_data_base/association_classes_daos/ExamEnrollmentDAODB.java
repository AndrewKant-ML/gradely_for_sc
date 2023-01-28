package it.uniroma2.dicii.ispw.gradely.daos.concrete_data_base.association_classes_daos;

import it.uniroma2.dicii.ispw.gradely.daos.abstracts.association_classes_daos.AbstractExamEnrollmentDAO;
import it.uniroma2.dicii.ispw.gradely.model.Exam;
import it.uniroma2.dicii.ispw.gradely.model.Student;
import it.uniroma2.dicii.ispw.gradely.model.association_classes.ExamEnrollment;

import java.util.ArrayList;
import java.util.List;

public class ExamEnrollmentDAODB extends AbstractExamEnrollmentDAO {
    private List<ExamEnrollment> examEnrollments;

    private ExamEnrollmentDAODB() { //TODO implementare costruttore vero
        examEnrollments = new ArrayList<ExamEnrollment>();
        examEnrollments.add(new ExamEnrollment());
    }

    public static AbstractExamEnrollmentDAO getInstance() {
        if (instance == null) {
            instance = new ExamEnrollmentDAODB();
        }
        return instance;
    }

    public List<ExamEnrollment> getExamEnrollmentsByExam(Exam exam) {
        List<ExamEnrollment> list = new ArrayList<>();
        for(ExamEnrollment e : examEnrollments){
            if(e.getExam().equals(exam)) {
                list.add(e); //TODO implementare exception
            }
        }
        return list;
    }

    public List<ExamEnrollment> getExamEnrollmentsByStudent(Student student) {
        List<ExamEnrollment> list = new ArrayList<>();
        for(ExamEnrollment e : examEnrollments){
            if(e.getStudent().equals(student)) {
                list.add(e); //TODO implementare exception
            }
        }
        return list;
    }

    public ExamEnrollment getExamEnrollmentByExamAndStudent(Exam exam, Student student) {
        for(ExamEnrollment e : examEnrollments){
            if(e.getExam().equals(exam) && e.getStudent().equals(student)) {
                return e; //TODO implementare exception
            }
        }
        return null;
    }

    public void update(ExamEnrollment enrollment){
        System.out.println("Updated");
    }

}