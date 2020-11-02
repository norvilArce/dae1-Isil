package pe.isil.model.dao;

import pe.isil.db.DB;
import pe.isil.model.dao.impl.BookDaoJdbc;

public class DaoFactory {

    public static BookDao createBookDao(){
        return new BookDaoJdbc(DB.getConnection());
    }
}
