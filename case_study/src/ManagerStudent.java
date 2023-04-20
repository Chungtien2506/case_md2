import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ManagerStudent extends AbStudent implements IStudent {
    private ArrayList<Student> listStudent;
   private ReadFile<Student> readFile;
    public ManagerStudent() {

        listStudent = new ArrayList<Student>();
         readFile = new ReadFile();
        listStudent = readFile.read();
    }


    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Thêm sinh viên");

        System.out.println("Mời nhập id");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.println("Mời nhập tên");
        String name = sc.nextLine();

        System.out.println("Mời nhập tuổi");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Mời bạn nhập quê");
        String address = sc.nextLine();

        System.out.println("Mời bạn nhập điểm ");
        int socore = sc.nextInt();

        Student st;
        st = new Student(id, name, age, address, socore);
        listStudent.add(st);
        WriteFile.WriteFile(listStudent);

    }


    @Override
    public String toString() {
        return "ManagerStudent{" +
                "listStudent=" + listStudent +
                '}';
    }

    @Override
    public void display() {
        System.out.println("Hiển thị danh sách sinh viên");
        for (Student s : listStudent) {
            System.out.println(s);
        }

    }

    @Override
    public void edit() {
        System.out.println("Mời nhập id của sinh viên cần sửa");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();


        System.out.println("Mời nhập tên");
        String name1 = sc.nextLine();

        System.out.println("Mời nhập tuổi");
        int age1 = sc.nextInt();
        sc.nextLine();

        System.out.println("Mời bạn nhập quê");
        String address1 = sc.nextLine();

        System.out.println("Mời bạn nhập điểm ");
        int socore1 = sc.nextInt();
        for (Student s : listStudent) {
            if (s.getId() == id) {
                s.setName(name1);
                s.setAge(age1);
                s.setAddress(address1);
                s.setScore(socore1);
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có ID là " + id);

    }

    @Override
    public void delete() {
        System.out.println("Nhập id của sinh viên cần xóa");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Student st = null;
        int size = listStudent.size();
        for (int i = 0; i < size; i++) {
            if (listStudent.get(i).getId() == id) {
                st = listStudent.get(i);
                break;
            }
        }
        if (st != null) {
            listStudent.remove(st);
            System.out.println("đã xóa thành công");
        }

    }

    @Override
    public void search() {
        System.out.println("Tìm kiếm sinh viên theo id ");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ArrayList<Student> list = ReadFile.read();
        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println(s);
                break;
            }
        }
    }


    @Override
    public void sortName() {
        System.out.println("Sắp xếp sinh viên theo tên");

        listStudent.sort(Comparator.comparing(Student::getName));
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }


    @Override
    public void sortScore() {
        System.out.println("Sắp xếp sinh viên theo điểm");
        listStudent.sort(Comparator.comparing(Student::getScore));
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }

    @Override
    public void quamon() {
        System.out.println("hiển thị sinh viên qua môn và không qua môn");
        for (Student st : listStudent){
            if(st.getScore()>=5){
                System.out.println("Sinh viên qua môn"+st);
            }else {
                System.out.println("Sinh viên không qua môn"+st);
            }

        }
    }




}
