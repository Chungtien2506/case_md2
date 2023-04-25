package view;

import Acc.AccManager;
import model.Student;
import controller.StudentManger;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        StudentManger managerStudent = new StudentManger() {

        };

        int chon1;
        int chon2;
        AccManager  am = new AccManager();
        while (true) {
            boolean isSign = am.Signin();
            if(isSign) {
                while (true) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("|                     MENU                         |");
                    System.out.println("----------------------------------------------------");
                    System.out.println("|1:  Add                                           |");
                    System.out.println("|2:  Display list model.Student                    |");
                    System.out.println("|3:  Edit by id                                    |");
                    System.out.println("|4:  Delete by id                                  |");
                    System.out.println("|5:  Search by id                                  |");
                    System.out.println("|6:  Sort model.Student                            |");
                    System.out.println("|7:  Check student pass                            |");
                    System.out.println("|8:  Show quantity                                 |");
                    System.out.println("|9:  Students with the highest and lowest scores   |");
                    System.out.println("|10: Display model.Student's A2bility              |");
                    System.out.println("|0:  Exit                                          |");
                    System.out.println("               Enter Your Selection                 ");
                    System.out.println("----------------------------------------------------");


                    chon1 = scanner.nextInt();
                    scanner.nextLine();

                    switch (chon1) {
                        case 1 -> managerStudent.add();
                        case 2 -> managerStudent.display();
                        case 3 -> managerStudent.edit();
                        case 4 -> managerStudent.delete();
                        case 5 -> managerStudent.search();
                        case 6 -> {
                            System.err.println("Sắp xếp Sinh viên");
                            System.out.println("1:Sắp xếp Sinh viên theo tên");
                            System.out.println("2:Sắp xếp Sinh viên theo tuổi");
                            System.out.println("Mời bạn nhập lựa chọn:");
                            chon2 = scanner.nextInt();
                            scanner.nextLine();
                            switch (chon2) {
                                case 1 -> {
                                    System.err.println("1:Sắp xếp theo tên");
                                    managerStudent.sortName();
                                }
                                case 2 -> {
                                    System.err.println("2:Sắp xếp theo điểm");
                                    managerStudent.sortScore();
                                }
                                default -> {
                                }
                            }
                        }
                        case 7 -> {
                            System.err.println("Tìm sinh viên qua môn và không qua môn");
                            System.out.println("1:Những sinh viên qua môn");
                            System.out.println("2:Những sinh viên phải học lại");
                            System.out.println("Mời bạn nhập lựa chọn:");
                            chon2 = scanner.nextInt();
                            scanner.nextLine();
                            switch (chon2) {
                                case 1 -> {
                                    System.err.println("1:Những sinh viên qua môn");
                                    managerStudent.stPass();
                                }
                                case 2 -> {
                                    System.err.println("2:Những sinh viên phải học lại");
                                    managerStudent.stNoPass();
                                }
                                default -> {
                                }
                            }
                        }
                        case 8 -> managerStudent.displaySize();
                        case 9 -> {
                            System.err.println("Tìm những sinh viên có điểm cao nhất và thấp nhất");
                            System.out.println("1:Những sinh viên có điểm cao nhất");
                            System.out.println("2:Những sinh viên có điểm thấp nhất");
                            System.out.println("Mời bạn nhập lựa chọn:");
                            chon2 = scanner.nextInt();
                            scanner.nextLine();
                            switch (chon2) {
                                case 1 -> {
                                    System.err.println("1:Những sinh viên có điểm cao nhất");
                                    managerStudent.studentsWithHighScores();
                                }
                                case 2 -> {
                                    System.err.println("2:Những sinh viên có điểm thấp nhất");
                                    managerStudent.studentsWithLowScores();
                                }
                                default -> {
                                }
                            }
                        }
                        case 10 -> {
                            System.err.println("Hiển thị năng lực của sinh viên theo điểm");
                            managerStudent.assessStudentCapacity();
                        }
                        case 0 -> System.err.println("Thoát chương trình");
                        default -> System.err.println("Lựa chọn không hợp lệ.Vui lòng chọn lại");
                    }
                }
            }else {
                System.out.println("Mời bạn nhập lại");
            }
        }
    }
}

