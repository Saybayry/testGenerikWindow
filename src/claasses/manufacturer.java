package claasses;

import DAO.GenericDAO;
import DAO.ManufacturerDAO;

public class manufacturer implements GenerigSimpleGuideClass {
    private int id;
    private String name;
    private String description;
    private String country;

    @Override
    public String toString() {
        return this.name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public manufacturer(){
        this.id = 0;
    }

    @Override
    public GenericDAO<manufacturer> getDao(){
        GenericDAO<manufacturer> Dao = new ManufacturerDAO();
        return Dao;
    }

    @Override
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
