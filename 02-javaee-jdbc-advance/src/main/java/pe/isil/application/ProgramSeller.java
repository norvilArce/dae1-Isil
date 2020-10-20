package pe.isil.application;

import pe.isil.model.dao.DaoFactory;
import pe.isil.model.dao.SellerDao;
import pe.isil.model.entities.Department;
import pe.isil.model.entities.Seller;

import java.util.Date;
import java.util.List;

public class ProgramSeller {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println("seller = "+seller);

        System.out.println("=== TEST 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> sellerList = sellerDao.findByDepartment(department);
        for (Seller s: sellerList ){
            System.out.println(s);
        }

        System.out.println("=== TEST 3: seller findAll ===");
        sellerList = sellerDao.findAll();
        for (Seller s: sellerList ){
            System.out.println(s);
        }

        System.out.println("=== TEST 4: seller insert ===");
        Seller newSeller = new Seller(null, "Jose",  "jsventuraa@isil.pe", new Date(), 1000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! new Seller = " + newSeller);

        System.out.println("=== TEST 5: seller update ===");
        Seller currentSeller = sellerDao.findById(newSeller.getId());
        currentSeller.setName("Franco");
        sellerDao.update(currentSeller);
        System.out.println("Updated! current Seller = " + currentSeller);

        System.out.println("=== TEST 6: seller deleteById ===");
        sellerDao.deleteById(currentSeller.getId());
        System.out.println("Delete completed!");


    }

}