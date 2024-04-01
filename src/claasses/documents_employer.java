package claasses;

import DAO.DocumentsEmployerDao;
import DAO.GenericDAO;

public class documents_employer implements GenerigSimpleGuideClass {
    private int id;
    private String passport;
    private String phone;

    @Override
    public String toString() {
        return this.passport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public GenericDAO<documents_employer> getDao() {
        GenericDAO<documents_employer> Dao = new DocumentsEmployerDao();
        return Dao;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
