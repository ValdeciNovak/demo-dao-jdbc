package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		
		System.out.println("== Teste 1: department findById");
		Department dep = departmentDao.findById(3);

		System.out.println(dep);

		System.out.println("== Teste 2: department findAll");
		List<Department> list = new ArrayList<Department>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}

		System.out.println("== Teste 3: department insert");
		Department newDepartment= new Department(null,"Education");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! new ID = " + newDepartment.getId());

		System.out.println("== Teste 4: department update");
		dep = departmentDao.findById(1);
		dep.setName("Library");
		departmentDao.update(dep);
		System.out.println("Update complete");

		System.out.println("== Teste 5: seller delete");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
	}

}
