package it.uniroma2.dicii.ispw.gradely.graphic_controllers_general.homepages;

import it.uniroma2.dicii.ispw.gradely.PageNavigationController;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorHomepageGraphicController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void openExamsPage() {
        PageNavigationController.getInstance().navigateTo("insert_students_grades");
    }

    public void openCoursesPage() {
        PageNavigationController.getInstance().navigateTo("under_construction");
    }

    public void openReceptionsPage() {
        PageNavigationController.getInstance().navigateTo("under_construction");
    }

    public void openCareerPage() {
        PageNavigationController.getInstance().navigateTo("under_construction");
    }

    public void openServicesPage() {
        PageNavigationController.getInstance().navigateTo("under_construction");
    }

    public void openPersonalDataPage() {
        PageNavigationController.getInstance().navigateTo("under_construction");
    }
}