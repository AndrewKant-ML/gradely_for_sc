package it.uniroma2.dicii.ispw.gradely.use_cases.enroll_to_degree_course;

import it.uniroma2.dicii.ispw.gradely.general_beans.DegreeCourseBean;
import it.uniroma2.dicii.ispw.gradely.general_beans.StudentBean;
import it.uniroma2.dicii.ispw.gradely.general_beans.UserBean;
import it.uniroma2.dicii.ispw.gradely.session_manager.Token;

import java.util.ArrayList;
import java.util.List;

public class EnrollToDegreeCourseControl {

    private final StudentBean studentBean;
    private final UserBean userBean;

    public EnrollToDegreeCourseControl() {
        this.studentBean = new StudentBean("0294136");
        this.userBean = new UserBean("Andrea", "Cantarini", "DJDKDJ", "a@gmail.cm");
        /*this.studentBean = new StudentBean(
            SessionManager.getInstance().getLazySessionUser(
                    PageNavigationController.getInstance().getCurrentToken()
            ).getRole().Student().getId());
        User user = SessionManager.getInstance().getLazySessionUser(
                PageNavigationController.getInstance().getCurrentToken()
        );
        this.userBean = new UserBean(
                user.getName(),
                user.getSurname(),
                user.getCodiceFiscale(),
                user.getEmail()
        );*/
    }

    public List<DegreeCourseBean> getDegreeCourses() {
        // TODO call to lazyfactory method
        return new ArrayList<>();
    }

    public StudentBean getStudentBean() {
        return studentBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }
}
