import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ManagerStudent managerStudent = new ManagerStudent() {

        };

        int chon = 0;
        while (true) {

            System.out.println(
                             "------MENU------ \n"
                            + "1: Add \n"
                            + "2: Display \n"
                            + "3: Edit theo id \n"
                            + "4: Delete theo id \n"
                            + "5: Search theo id \n"
                            + "6: SortName \n"
                            + "7: SortScore \n"
                             +"8: Check student pass and no pass \n"
                            + "9: Exit \n"

               );
            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
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
                    managerStudent.sortName();
                    break;
                case 7:
                    managerStudent.sortScore();
                    break;
                case 8:
                    managerStudent.quamon();
                    break;
                case 9:
                    System.out.println("thoát");
                    break;
                default:

            }

        }
    }
}

