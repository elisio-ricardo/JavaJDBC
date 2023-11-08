package model.dao;

import db.DB;
import model.dao.impl.SellerDaoImpleJDBC;

import java.sql.Connection;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoImpleJDBC(DB.getConnection());
    }

}
