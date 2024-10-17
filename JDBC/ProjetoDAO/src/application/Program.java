package JDBC.ProjetoDAO.src.application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import JDBC.ProjetoDAO.src.model.dao.DaoFactory;
import JDBC.ProjetoDAO.src.model.dao.SellerDao;
import JDBC.ProjetoDAO.src.model.entities.Department;
import JDBC.ProjetoDAO.src.model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n***** TEST 1 - findById(3) *****");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n***** TEST 2 - findByDepartment(2, null) *****");
        Department dep = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(dep);
        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n***** TEST 3 - findAll() *****");
        list = sellerDao.findAll();
        for (Seller sel : list) {
            System.out.println(sel);
        }

        System.out.println("\n***** TEST 4 - Seller insert() *****");
        Seller newSeller = new Seller(null, "Gregorio", "gerg@hotmail.com", new Date(), 4000.0, dep);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());

        System.out.println("\n***** TEST 5 - Seller update() *****");
        seller = sellerDao.findById(1);
        //System.out.println(seller);
        seller.setName("Marta Waine");
        sellerDao.update(seller);
        System.out.println("Updated completed");

        System.out.println("\n***** TEST 5 - Seller delete() *****");
        System.out.print("Enter if for delete test: ");
        int d = sc.nextInt();
        sellerDao.deleteById(d);
        System.out.println("Delete completed!");
        sc.close();
    }   
}
