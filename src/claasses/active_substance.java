package claasses;

import DAO.ActiveSubstanceDAO;
import DAO.GenericDAO;

public class active_substance implements GenerigSimpleGuideClass {
    private int id;
    private String name;
    private String description;
    public active_substance(){
        this.id = 0;
    }

    public GenericDAO getDao() {
        ActiveSubstanceDAO activeSubstanceDAO = new ActiveSubstanceDAO();
        return activeSubstanceDAO;
    }
    @Override
    public String toString() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
