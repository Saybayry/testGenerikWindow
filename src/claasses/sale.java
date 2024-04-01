package claasses;

import DAO.GenericDAO;
import DAO.SaleDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class sale implements GenerigSimpleGuideClass {
    private int id;
    private Date dateSale;
    private List<saleItem> items;
    private BigDecimal amountPrice;
    private employees saleEmloyees;

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    public List<saleItem> getItems() {
        return items;
    }

    public void setItems(List<saleItem> items) {
        this.items = items;
    }

    public BigDecimal getAmountPrice() {
        return amountPrice;
    }

    public void setAmountPrice(BigDecimal amountPrice) {
        this.amountPrice = amountPrice;
    }

    public employees getSaleEmloyees() {
        return saleEmloyees;
    }

    public void setSaleEmloyees(employees saleEmloyees) {
        this.saleEmloyees = saleEmloyees;
    }

    @Override
    public GenericDAO getDao() {
        return new SaleDAO();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
