package claasses;

import DAO.GenericDAO;
import DAO.ManufacturerDAO;
import DAO.ProductDAO;

import java.math.BigDecimal;

public class product implements GenerigSimpleGuideClass {
    private int id;
    private String name;
    private BigDecimal price;
    private manufacturer manufacturer;

    public product(){
        this.id = 0;
        this.manufacturer=null;
    }
    @Override
    public GenericDAO<product> getDao() {
        GenericDAO<product> Dao = new ProductDAO();
        return Dao;
    }
    @Override
    public String toString() {
        return this.name;
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

}
