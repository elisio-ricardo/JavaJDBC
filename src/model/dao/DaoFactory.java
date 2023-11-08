package model.dao;

import model.dao.impl.SellerDaoImpleJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoImpleJDBC();
    }

}
