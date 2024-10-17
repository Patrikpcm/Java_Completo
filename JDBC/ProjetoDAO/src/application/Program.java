package JDBC.ProjetoDAO.src.application;

import java.util.Date;

import JDBC.ProjetoDAO.src.model.dao.DaoFactory;
import JDBC.ProjetoDAO.src.model.dao.SellerDao;
import JDBC.ProjetoDAO.src.model.entities.Department;
import JDBC.ProjetoDAO.src.model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        
        Department obj = new Department(1,"TI");
        System.out.println("obj");

        Seller seller = new Seller(21,"bob", "bob@gmail.com",new Date(), 3000.00, obj);
        System.out.println(seller);

        SellerDao sellerDao = DaoFactory.createSellerDao();
    }
}
