package employeeinformation;
import java.util.*;
import java.util.Arrays;

public class EmployeeInfoSystem {



    
     // Multidimensional array to store employee info
	private String[][] employeeInfo;
	private int size;
	
	public EmployeeInfoSystem() {
		this.employeeInfo = new String[10][4];
		this.size = 10;
                
                this.employeeInfo[0][0] = "Raffy Carreon";
                this.employeeInfo[0][1] = "20";
                this.employeeInfo[0][2] = "30000";
                this.employeeInfo[0][3] = "Web Developer";
                
                this.employeeInfo[1][0] = "Ken Alvarado";
                this.employeeInfo[1][1] = "19";
                this.employeeInfo[1][2] = "20000";
                this.employeeInfo[1][3] = "Java Developer";
                
                this.employeeInfo[2][0] = "Kyla Ostia";
                this.employeeInfo[2][1] = "21";
                this.employeeInfo[2][2] = "50000";
                this.employeeInfo[2][3] = "Full Stack Developer";
                
                this.employeeInfo[3][0] = "Carlo Dayoc";
                this.employeeInfo[3][1] = "23";
                this.employeeInfo[3][2] = "10000";
                this.employeeInfo[3][3] = "System Analyst";
                
                this.employeeInfo[4][0] = "Gab Villacarlos";
                this.employeeInfo[4][1] = "20";
                this.employeeInfo[4][2] = "80000";
                this.employeeInfo[4][3] = "Database Administrator";
                
                this.employeeInfo[5][0] = "Irvin Barientos";
                this.employeeInfo[5][1] = "25";
                this.employeeInfo[5][2] = "90000";
                this.employeeInfo[5][3] = "PHP Developer";
                
                this.employeeInfo[6][0] = "Cj Jubay";
                this.employeeInfo[6][1] = "28";
                this.employeeInfo[6][2] = "60000";
                this.employeeInfo[6][3] = "Software Engineer";
                
                this.employeeInfo[7][0] = "Justine Denila";
                this.employeeInfo[7][1] = "22";
                this.employeeInfo[7][2] = "70000";
                this.employeeInfo[7][3] = "Security Engineer";
                
                this.employeeInfo[8][0] = "Reeve Balase";
                this.employeeInfo[8][1] = "26";
                this.employeeInfo[8][2] = "30000";
                this.employeeInfo[8][3] = "Hardware Engineer";
                
                this.employeeInfo[9][0] = "Ashanti Saquin";
                this.employeeInfo[9][1] = "23";
                this.employeeInfo[9][2] = "90000";
                this.employeeInfo[9][3] = "Mobile Developer";
                
	}
	
	public void addEmployee(String[] employee) {
		if (size == employeeInfo.length) {
			// Increase array size by 10
			employeeInfo = Arrays.copyOf(employeeInfo, size + 10);
		}
		employeeInfo[size] = employee;
		size++;
	}
	
	public void removeEmployee(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		for (int i = index; i < size - 1; i++) {
			employeeInfo[i] = employeeInfo[i + 1];
		}
		size--;
	}
	
	public void sortEmployees(String sortBy) {
		if (sortBy.equalsIgnoreCase("name")) {
			// Sort array by name using insertion sort
			for (int i = 1; i < size; i++) {
				String[] key = employeeInfo[i];
				int j = i - 1;
				while (j >= 0 && employeeInfo[j][0].compareTo(key[0]) > 0) {
					employeeInfo[j + 1] = employeeInfo[j];
					j--;
				}
				employeeInfo[j + 1] = key;
			}
		} else if (sortBy.equalsIgnoreCase("age")) {
			// Sort array by age using selection sort
			for (int i = 0; i < size - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < size; j++) {
					if (Integer.parseInt(employeeInfo[j][1]) < Integer.parseInt(employeeInfo[minIndex][1])) {
						minIndex = j;
					}
				}
				// Swap
				String[] temp = employeeInfo[i];
				employeeInfo[i] = employeeInfo[minIndex];
				employeeInfo[minIndex] = temp;
			}
		} else if (sortBy.equalsIgnoreCase("salary")) {
			// Sort array by salary using bubble sort
			for (int i = 0; i < size - 1; i++) {
				for (int j = 0; j < size - i - 1; j++) {
					if (Integer.parseInt(employeeInfo[j][2]) > Integer.parseInt(employeeInfo[j + 1][2])) {
						// Swap
						String[] temp = employeeInfo[j];
						employeeInfo[j] = employeeInfo[j + 1];
						employeeInfo[j + 1] = temp;
					}
				}
			}
		}
	}
	
	
	public int searchEmployee(String name) {
		// Search array using linear search
		for (int i = 0; i < size; i++) {
			if (employeeInfo[i][0].equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public void printEmployees() {
		System.out.println("Name\t\t\t\t\t\tAge\t\t\t\t\tSalary\t\t\t\t\tPosition");
		for (int i = 0; i < size; i++) {
			System.out.println(employeeInfo[i][0] + "\t\t\t\t\t" + employeeInfo[i][1] + "\t\t\t\t\t" + employeeInfo[i][2] + "\t\t\t\t\t" + employeeInfo[i][3]);
		
                } 
                        
               
		System.out.println("Total Employees: " + size);
	}
	//Sorting algorithm of age and salary
public void sortEmployeesByAgeAndSalary() {
		// Sort array using insertion sort
		for (int i = 1; i < size; i++) {
			String[] key = employeeInfo[i];
			int j = i - 1;
			while (j >= 0 && (employeeInfo[j][1].compareTo(key[1]) > 0 || (employeeInfo[j][1].compareTo(key[1]) == 0 && employeeInfo[j][2].compareTo(key[2]) > 0))) {
				employeeInfo[j + 1] = employeeInfo[j];
				j--;
			}
			employeeInfo[j + 1] = key;
		}
	}
	public static void main(String[] args) {
		EmployeeInfoSystem eis = new EmployeeInfoSystem();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Sort Employees");
			System.out.println("4. Search Employee");
			System.out.println("5. Print Employees");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				// Get user input
				System.out.print("Enter name: ");
				String name = sc.next();
				System.out.print("Enter age: ");
				String age = sc.next();
				System.out.print("Enter salary: ");
				String salary = sc.next();
				System.out.print("Enter position: ");
				String position = sc.next();
				
				// Add employee
				eis.addEmployee(new String[] {name, age, salary, position});
				System.out.println("Employee Added!");
			} else if (choice == 2) {
				// Get user input
				System.out.print("Enter index of employee to remove: ");
				int index = sc.nextInt();
				
				// Remove employee
				eis.removeEmployee(index);
				System.out.println("Employee Removed!");
			} else if (choice == 3) {
				// Get user input
				System.out.print("Enter sort by (name, age, salary): ");
				String sortBy = sc.next();
				
				// Sort employees
				eis.sortEmployees(sortBy);
				System.out.println("Employees Sorted!");
			} else if (choice == 4) {
				// Get user input
				System.out.print("Enter name of employee to search for: ");
				String name = sc.next();
				
				// Search employee
				int index = eis.searchEmployee(name);
				if (index == -1) {
					System.out.println("Employee not found!");
				} else {
					System.out.println("Employee found at index: " + index);
				}
			} else if (choice == 5) {
				// Print employees
				eis.printEmployees();
			} else if (choice == 6) {
				// Exit
				break;
			} else {
				System.out.println("Invalid Choice!");
			}
			System.out.println();
		}
		
		sc.close();
		System.out.println("Bye!");
	}
}