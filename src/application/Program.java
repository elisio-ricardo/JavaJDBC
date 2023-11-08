package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Department department = new Department(1, "Books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, department);

        //Dessa forma o programa não conhece a classe de implemetação apenas a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();

    }
}
