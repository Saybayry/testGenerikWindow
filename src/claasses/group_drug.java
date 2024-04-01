package claasses;

import DAO.GenericDAO;
import DAO.GroupDrugDAO;

public class group_drug implements GenerigSimpleGuideClass {
    private int id;
    private String name;
    private String description;

    public group_drug(){
        this.id = 0;
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

    @Override
    public String toString() {
        return this.name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GenericDAO<group_drug> getDao(){
        GenericDAO<group_drug> Dao = new GroupDrugDAO();
        return Dao;
    }
}
