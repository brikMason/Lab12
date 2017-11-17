package lab12;

import java.io.File;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		try {

			File file = new File("/Users/wesmaxwell/Desktop/BST/students.in");
			Scanner scan = new Scanner(file);
			String input;

			BinarySearchTree<StudentGPA> studentTree = new BinarySearchTree<StudentGPA>();
			BinarySearchTree<GraduateStudentGPA> gradTree = new BinarySearchTree<GraduateStudentGPA>();

			StudentGPA tmpStudent;
			GraduateStudentGPA tmpGrad;

			while (scan.hasNextLine()) {
				input = scan.nextLine();
				if (input.length() > 11) {
					int i = 0;
					while (Character.isDigit(input.charAt(i))) {
						i++;
					}
					Integer ID = new Integer(input.substring(0, i));
					String name = input.substring(i + 1, i + 4);
					Double GPA = new Double(input.substring(i + 5, i + 8));
					tmpStudent = new StudentGPA(ID, name, GPA);
					studentTree.insert(tmpStudent);
				}

				else {
					int i = 0;
					while (Character.isDigit(input.charAt(i))) {
						i++;
					}
					Integer ID = new Integer(input.substring(0, i));
					String name = input.substring(i + 1, i + 4);
					Double GPA = new Double(input.substring(i + 5, i + 8));
					String advisor = input.substring(i + 8, input.length());
					tmpGrad = new GraduateStudentGPA(ID, name, GPA, advisor);
					gradTree.insert(tmpGrad);
				}
			}

			TreeIterator<StudentGPA> studentIterator = new TreeIterator<StudentGPA>(studentTree);
			TreeIterator<GraduateStudentGPA> gradIterator = new TreeIterator<GraduateStudentGPA>(gradTree);
			
			System.out.println("Student Tree:");
			studentIterator.printInorder();
			System.out.println();
			System.out.println("*********************************************************");
			System.out.println();
			System.out.println("Graduate Tree:");
			gradIterator.printInorder();

			scan.close();
		} catch (Exception e) {
			System.out.println("File not found.");
		}
	}

}