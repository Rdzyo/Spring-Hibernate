package employee.crud;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import employee.entity.Employee;

public class EmployeeApp {

	private static int decideNumber=0;
	private static int eId;
	private static String eCompany;
	static Employee nextEmployee;
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("Type '1' - for adding employee " 
									+ "'2' - for searching employees by id " 
									+ "'3' - for searching employees by company "
									+ "'4' - for deleting employees by id");
			Scanner scanner = new Scanner(System.in);
			decideNumber=scanner.nextInt();
			scanner.nextLine();
			if(decideNumber==1) {
			session.beginTransaction();
			createEmployee();
			System.out.println("Saving employee...");
			session.save(nextEmployee);
			session.getTransaction().commit();
			}
			else if(decideNumber==2) {
			session.beginTransaction();
			searchEmployeeById();
			List<Employee> theEmployees = session.createQuery("from Employee e where e.id=" + eId).getResultList();
			System.out.println("Getting employee with id number " + eId);
			displayEmployee(theEmployees);
			session.getTransaction().commit();
			}
			else if(decideNumber==3) {
			session.beginTransaction();
			searchEmployeesByCompany();
			List<Employee> theEmployees = session.createQuery("from Employee e where e.company=" + eCompany).getResultList();
			System.out.println("Getting employees with company name " + eCompany);
			displayEmployee(theEmployees);
			session.getTransaction().commit();
			}
			else if(decideNumber==4) {
			session.beginTransaction();
			searchEmployeeById();
			System.out.println("Deleting employee with id " + eId);
			session.createQuery("delete from Employee e where e.id=" + eId).executeUpdate();
			session.getTransaction().commit();
			}
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayEmployee(List<Employee> theEmployees) {
		for(Employee employee : theEmployees) {
			System.out.println(employee);
		}
	}

	private static void createEmployee() {
		Scanner scanner = new Scanner(System.in);
		String inFirstName, inLastName, inCompany;
		System.out.println("Enter employee first name...");
		inFirstName=scanner.nextLine();
		System.out.println("Enter emloyee last name...");
		inLastName=scanner.nextLine();
		System.out.println("Enter employee company...");
		inCompany=scanner.nextLine();
		System.out.println("Creating new employee object...");
		nextEmployee = new Employee(inFirstName,inLastName,inCompany);
	}
	private static void searchEmployeeById() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id number of an employee...");
		eId=scanner.nextInt();
		scanner.nextLine();
	}
	private static void searchEmployeesByCompany() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter company name of an employee...");
		eCompany=scanner.nextLine();
	}
}
