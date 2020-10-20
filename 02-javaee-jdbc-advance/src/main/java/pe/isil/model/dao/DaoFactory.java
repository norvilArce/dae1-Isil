package pe.isil.model.dao;

import pe.isil.db.DB;
import pe.isil.model.dao.impl.DepartmentDaoJdbc;
import pe.isil.model.dao.impl.SellerDaoJdbc;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJdbc(DB.getConnection());
    }

    public static DepartmentDao createDepartmentDao(){
        return new DepartmentDaoJdbc(DB.getConnection());
    }

}
