package claasses;

import DAO.GenericDAO;

import java.math.BigDecimal;

public class medicines implements  GenerigSimpleGuideClass {

    private int id;
    private String name;
    private BigDecimal price;
    private manufacturer manufacturer;

    private active_substance active_substance;
    private group_drug group_drug;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public claasses.manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(claasses.manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public claasses.active_substance getActive_substance() {
        return active_substance;
    }

    public void setActive_substance(claasses.active_substance active_substance) {
        this.active_substance = active_substance;
    }

    public claasses.group_drug getGroup_drug() {
        return group_drug;
    }

    public void setGroup_drug(claasses.group_drug group_drug) {
        this.group_drug = group_drug;
    }

    @Override
    public GenericDAO getDao() {
        return null;

    }
}

