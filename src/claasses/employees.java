package claasses;

import DAO.EmployeesDAO;
import DAO.GenericDAO;

public class employees implements GenerigSimpleGuideClass {
    private int id;
    private String first_name;
    private String last_name;
    private String middle_name;
    private documents_employer dociments;

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public documents_employer getDociments() {
        return dociments;
    }

    public void setDociments(documents_employer dociments) {
        this.dociments = dociments;
    }

    public employees() {
        this.id = 0;
    }

    @Override
    public GenericDAO getDao() {
        return new EmployeesDAO();
    }

    @Override
    public int getId() {
        return 0;
    }
}
