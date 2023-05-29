package view;

import Acc.AccManager;
import model.Student;
import controller.StudentManger;
import storage.ReadFile;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentManger managerStudent = new StudentManger();
        managerStudent.setListStudent(ReadFile.read());

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
                    System.out.println("|1:  Thêm sinh viên                                |");
                    System.out.println("|2:  Hiển thị danh sách sinh viên                  |");
                    System.out.println("|3:  Sửa sinh viên theo id                         |");
                    System.out.println("|4:  Xóa sinh viên theo id                         |");
                    System.out.println("|5:  Tìm kiếm sinh viên theo id                    |");
                    System.out.println("|6:  Sắp xếp sinh viên                             |");
                    System.out.println("|7:  Tìm xem những sinh viên nào qua môn           |");
                    System.out.println("|8:  Hiển thị số lượng sinh viên                   |");
                    System.out.println("|9:  Sinh viên có điểm cao và thấp nhất            |");
                    System.out.println("|10: Hiển thị năng lực sinh viên                   |");
                    System.out.println("|0:  Thoát                                         |");
                    System.out.println("               Mời bạn nhập lựa chọn                ");
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
                            System.out.println("2:Sắp xếp Sinh viên theo điểm");
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
                        case 11 -> System.exit(0);
                        default -> System.err.println("Lựa chọn không hợp lệ.Vui lòng chọn lại");
                    }
                }
            }else {
                System.out.println("Sai rồi.Mời bạn nhập lại");
            }
        }
    }
}

