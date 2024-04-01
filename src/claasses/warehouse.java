package claasses;

import DAO.GenericDAO;
import DAO.ProductDAO;
import DAO.WarehouseDAO;

import java.sql.Date;

public class warehouse implements GenerigSimpleGuideClass {

    private int id;
    private int batch_number;
    private Date production_date;
    private Date expiration_date;
    private Date date_receipt;
    private product product;
    private int quantity;

    public warehouse(){
        this.id = 0;
        this.product=null;
    }

    @Override
    public GenericDAO getDao() {
        GenericDAO<warehouse> Dao = new WarehouseDAO();
        return Dao;
    }


    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(int batch_number) {
        this.batch_number = batch_number;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Date getDate_receipt() {
        return date_receipt;
    }

    public void setDate_receipt(Date date_receipt) {
        this.date_receipt = date_receipt;
    }

    public claasses.product getProduct() {
        return product;
    }

    public void setProduct(claasses.product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
