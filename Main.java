import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String username = "";
    static String password = "";
    static String name = "";

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n======================================");
            System.out.println("     ONLINE QUIZ & EXAMINATION");
            System.out.println("======================================");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                registerStudent();
            } 
            else if (choice == 2) {
                loginStudent();
            } 
            else if (choice == 3) {
                admin();
            } 
            else if (choice == 4) {
                System.out.println("Thank you for using the system!");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
    }

    static void registerStudent() {

        System.out.println("\n===== STUDENT REGISTRATION =====");

        System.out.print("Enter your name: ");
        name = scanner.nextLine();

        System.out.print("Create username: ");
        username = scanner.nextLine();

        System.out.print("Create password: ");
        password = scanner.nextLine();

        System.out.println("\nRegistration successful!");
    }

    static void loginStudent() {

        System.out.println("\n===== STUDENT LOGIN =====");

        if (username.equals("")) {
            System.out.println("Please register first.");
            return;
        }

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(username)
                && enteredPassword.equals(password)) {

            System.out.println("\nLogin successful!");
            System.out.println("Welcome, " + name + "!");

            startQuiz();

        } 
        else {
            System.out.println("\nInvalid username or password.");
        }
    }

    static void startQuiz() {

        System.out.println("\n===== ONLINE QUIZ =====");

        int score = 0;

        System.out.println("\nQ1. Which language is used to develop this project?");
        System.out.println("1. Python");
        System.out.println("2. Java");
        System.out.println("3. HTML");
        System.out.println("4. C++");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 2) score++;

        System.out.println("\nQ2. Which keyword is used to create a class in Java?");
        System.out.println("1. class");
        System.out.println("2. create");
        System.out.println("3. newclass");
        System.out.println("4. object");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 1) score++;

        System.out.println("\nQ3. Which method is the starting point of a Java program?");
        System.out.println("1. start()");
        System.out.println("2. run()");
        System.out.println("3. main()");
        System.out.println("4. begin()");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 3) score++;

        System.out.println("\nQ4. Which symbol is used to end a Java statement?");
        System.out.println("1. :");
        System.out.println("2. ;");
        System.out.println("3. .");
        System.out.println("4. ,");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 2) score++;

        System.out.println("\nQ5. Which data type is used for whole numbers?");
        System.out.println("1. double");
        System.out.println("2. char");
        System.out.println("3. int");
        System.out.println("4. boolean");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 3) score++;

        System.out.println("\nQ6. Which keyword is used to create an object?");
        System.out.println("1. object");
        System.out.println("2. new");
        System.out.println("3. create");
        System.out.println("4. class");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 2) score++;

        System.out.println("\nQ7. Which keyword is used for inheritance in Java?");
        System.out.println("1. inherit");
        System.out.println("2. extends");
        System.out.println("3. implements");
        System.out.println("4. super");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 2) score++;

        System.out.println("\nQ8. Which data type stores true or false?");
        System.out.println("1. int");
        System.out.println("2. String");
        System.out.println("3. boolean");
        System.out.println("4. char");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 3) score++;

        System.out.println("\nQ9. Which keyword refers to the current object?");
        System.out.println("1. super");
        System.out.println("2. this");
        System.out.println("3. current");
        System.out.println("4. self");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 2) score++;

        System.out.println("\nQ10. Which keyword is used to stop a loop?");
        System.out.println("1. stop");
        System.out.println("2. exit");
        System.out.println("3. break");
        System.out.println("4. close");
        System.out.print("Enter answer: ");
        if (scanner.nextInt() == 3) score++;

        System.out.println("\n======================================");
        System.out.println("              RESULT");
        System.out.println("======================================");
        System.out.println("Student: " + name);
        System.out.println("Score: " + score + " / 10");

        if (score >= 8) {
            System.out.println("Excellent!");
        } 
        else if (score >= 5) {
            System.out.println("Good job!");
        } 
        else {
            System.out.println("Keep practicing!");
        }

        saveResult(score);

        scanner.nextLine();
    }

    static void saveResult(int score) {

        try {

            FileWriter writer = new FileWriter("results.txt", true);

            writer.write("Student: " + name
                    + " | Username: " + username
                    + " | Score: " + score + "/10\n");

            writer.close();

            System.out.println("\nResult saved successfully!");

        } 
        catch (IOException e) {

            System.out.println("Unable to save result.");
        }
    }

    static void admin() {

        System.out.println("\n===== ADMIN LOGIN =====");

        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();

        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (adminUsername.equals("admin")
                && adminPassword.equals("1234")) {

            System.out.println("\nAdmin login successful!");

            while (true) {

                System.out.println("\n===== ADMIN MENU =====");
                System.out.println("1. View Quiz Information");
                System.out.println("2. View Registered Student");
                System.out.println("3. View Result History");
                System.out.println("4. Logout");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {

                    System.out.println("\n===== QUIZ INFORMATION =====");
                    System.out.println("Quiz Subject: Java Programming");
                    System.out.println("Total Questions: 10");
                    System.out.println("Question Type: Multiple Choice");
                }

                else if (choice == 2) {

                    System.out.println("\n===== REGISTERED STUDENT =====");

                    if (username.equals("")) {
                        System.out.println("No student registered.");
                    } 
                    else {
                        System.out.println("Name: " + name);
                        System.out.println("Username: " + username);
                    }
                }

                else if (choice == 3) {

                    System.out.println("\n===== RESULT HISTORY =====");

                    File file = new File("results.txt");

                    if (!file.exists()) {
                        System.out.println("No result history available.");
                    } 
                    else {

                        try {

                            Scanner fileScanner = new Scanner(file);

                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }

                            fileScanner.close();

                        } 
                        catch (IOException e) {
                            System.out.println("Unable to read result history.");
                        }
                    }
                }

                else if (choice == 4) {

                    System.out.println("\nAdmin logged out.");
                    break;
                }

                else {
                    System.out.println("Invalid choice!");
                }
            }

        } 
        else {
            System.out.println("\nInvalid admin username or password.");
        }
    }
}