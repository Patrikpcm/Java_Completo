package JDBC.ProjetoDAO.src.model.dao;

import JDBC.ProjetoDAO.src.model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao(){
        return new SellerDaoJDBC();
    }
}
