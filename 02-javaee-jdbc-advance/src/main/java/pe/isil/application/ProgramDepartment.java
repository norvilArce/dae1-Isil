package pe.isil.application;

import pe.isil.model.dao.DaoFactory;
import pe.isil.model.dao.DepartmentDao;
import pe.isil.model.entities.Department;

import java.util.List;

public class ProgramDepartment {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===TEST 1: FindById ===");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("=== TEST 3: insert ===");
        List<Department> list = departmentDao.findAll();
        for (Department d : list             ) {
            System.out.println(d);
        }

        System.out.println("=== TEST 3: insert ===");
        Department theDepartment = new Department(null, "Music");
        departmentDao.insert(theDepartment);
        System.out.println("Inserted! New id: "+theDepartment.getId());

        System.out.println("=== TEST 4: udate ===");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed!");

        System.out.println("=== TEST 5: deleteById ===");
        Integer id = 5;
        departmentDao.deleteById(theDepartment.getId());
        System.out.println("Delete completed!");

    }
}
