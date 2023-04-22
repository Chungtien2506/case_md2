import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ManagerStudent managerStudent = new ManagerStudent() {

        };

        int chon1 = 0 ;
        int chon2 = 0;

        while (true) {
            System.out.println("----------------------------------------------------");
            System.out.println("|                     MENU                         |");
            System.out.println("----------------------------------------------------");
            System.out.println("|1:  Add                                           |");
            System.out.println("|2:  Display list Student                          |");
            System.out.println("|3:  Edit by id                                    |");
            System.out.println("|4:  Delete by id                                  |");
            System.out.println("|5:  Search by id                                  |");
            System.out.println("|6:  Sort Student                                  |");
            System.out.println("|7:  Check student pass                            |");
            System.out.println("|8:  Show quantity                                 |");
            System.out.println("|9:  Students with the highest and lowest scores   |");
            System.out.println("|10: Students with the highest and lowest scores   |");
            System.out.println("|0:  Exit                                          |");
            System.out.println("            Nhập lựa chọn của bạn                   ");
            System.out.println("----------------------------------------------------");


            chon1 = scanner.nextInt();

            scanner.nextLine();

            switch (chon1) {
                case 1:
                    managerStudent.add();
                    break;
                case 2:
                    managerStudent.display();
                    break;
                case 3:
                    managerStudent.edit();
                    break;
                case 4:
                    managerStudent.delete();
                    break;
                case 5:
                    managerStudent.search();
                    break;
                case 6:
                    System.err.println("Sắp xếp Sinh viên");
                    System.out.println("1:Sắp xếp Sinh viên theo tên");
                    System.out.println("2:Sắp xếp Sinh viên theo tuổi");
                    System.out.println("Mời bạn nhập lựa chọn:");

                    chon2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (chon2){
                        case 1:
                            System.err.println("1:Sắp xếp theo tên");
                            managerStudent.sortName();
                            break;
                        case 2:
                            System.err.println("2:Sắp xếp theo điểm");
                            managerStudent.sortScore();
                            break;
                        default:
                    }
                    break;
                case 7:
                    System.err.println("Tìm sinh viên qua môn và không qua môn");
                    System.out.println("1:Những sinh viên qua môn");
                    System.out.println("2:Những sinh viên phải học lại");
                    System.out.println("Mời bạn nhập lựa chọn:");
                    chon2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (chon2){
                        case 1:
                            System.err.println("1:Những sinh viên qua môn");
                            managerStudent.stPass();
                            break;
                        case 2:
                            System.err.println("2:Những sinh viên phải học lại");
                            managerStudent.stNoPass();
                            break;
                        default:
                    }

                    break;

                case 8:
                  managerStudent.displaySize();
                    break;
                case 9:
                    System.err.println("Tìm những sinh viên có điểm cao nhất và thấp nhất");
                    System.out.println("1:Những sinh viên có điểm cao nhất");
                    System.out.println("2:Những sinh viên có điểm thấp nhất");
                    System.out.println("Mời bạn nhập lựa chọn:");
                    chon2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (chon2){
                        case 1:
                            System.err.println("1:Những sinh viên có điểm cao nhất");
                            managerStudent.studentsWithHighScores();
                            break;
                        case 2:
                            System.err.println("2:Những sinh viên có điểm thấp nhất");
                            managerStudent.studentsWithLowScores();
                            break;
                        default:
                    }
                    break;
                case 10:
                    System.err.println("Hiển thị năng lực của sinh viên theo điểm");
                    managerStudent.assessStudentCapacity();
                    break;
                case 0:
                    System.err.println("Thoát chương trình");
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.Vui lòng chọn lại");
                    break;

            }
        }
    }
}

