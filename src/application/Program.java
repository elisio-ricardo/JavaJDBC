package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Department department = new Department(1, "Books");

        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.00, department);

        //Dessa forma o programa não conhece a classe de implemetação apenas a interface
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=========== Teste 1 ===============");
        Seller sel = sellerDao.findById(3);
        System.out.println(sel);

        System.out.println("\n");
        System.out.println("=========== Teste 2 FindById ===============");
        Department department2 = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department2);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n");
        System.out.println("=========== Teste 3 FindAll ===============");
        List<Seller> list2 = sellerDao.findAll();
        for (Seller obj : list2) {
            System.out.println(obj);
        }

        System.out.println("\n");
        System.out.println("=========== Teste 4 Insert ===============");
        Seller newSeller = new Seller(null, "Greg", "gre@hotmail.com", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Id = " + newSeller.getId());

        System.out.println("\n");
        System.out.println("=========== Teste 5 Seller Update ===============");
        seller = sellerDao.findById(1);
        seller.setName("Ricardo Canuto");
        sellerDao.update(seller);
        System.out.println("Update completed ! ");

//        System.out.println("\n");
//        System.out.println("=========== Teste 5 Seller Delete ===============");
//        System.out.println("Entre com o id para delete: ");
//        int id = sc.nextInt();
//        sellerDao.deleteById(id);
//        System.out.println("Delete concluido");
//        sc.close();


    }
}
