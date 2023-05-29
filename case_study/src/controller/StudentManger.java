package controller;

import storage.ReadFile;
import storage.WriteFile;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManger extends AbStudent implements IStudent {
    private List<Student> listStudent;

    public List<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(List<Student> listStudent) {
        this.listStudent = listStudent;
    }

    public StudentManger() {
        listStudent = new ArrayList<>();

    }

    // Thêm sinh viên
    public void add() {
        Scanner sc = new Scanner(System.in);
        System.err.println("Thêm sinh viên");
        listStudent = ReadFile.read();
        int id;
        boolean check = true;

        do {
            System.out.println("Mời nhập  id:");
            id = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < listStudent.size(); i++) {
                if (listStudent.get(i).getId() == id) {
                    check = false;
                    System.err.println("Sinh viên có ID " + id + " đã tồn tại");

                    break;
                } else {
                    check = true;
                }
            }

        } while (!check);

        System.out.println("Mời nhập tên:");
        String name = sc.nextLine();

        System.out.println("Mời nhập tuổi:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Mời bạn nhập quê:");
        String address = sc.nextLine();

        System.out.println("Mời bạn nhập điểm:");
        int score = sc.nextInt();

        Student st = new Student(id, name, age, address, score);
        listStudent.add(st);

        System.out.println();
        System.err.println("Đã thêm sinh viên thành công");
        WriteFile.WriteFile((ArrayList<Student>) listStudent);
    }


    @Override
    public String toString() {
        return "controller.ManagerStudent{" +
                "listStudent=" + listStudent +
                '}';
    }

    // Hiển thị sinh viên
    @Override
    public void display() {
        listStudent = ReadFile.read();
        System.err.println("Hiển thị danh sách sinh viên:");
        for (Student s : listStudent) {
            System.out.println(s);

        }

    }

    // Sửa sinh viên theo id
    public void edit() {
        Scanner sc = new Scanner(System.in);
        System.err.println("Sửa sinh viên");


        int id;
        boolean validId = false;
        do {
            System.out.println("Mời nhập ID của sinh viên cần sửa:");
            id = Integer.parseInt(sc.nextLine());
//            sc.nextLine();

            for (Student s : listStudent) {
                if (s.getId() == id) {
                    validId = true;
                    System.out.println("Mời nhập tên:");
                    String name1 = sc.nextLine();

                    System.out.println("Mời nhập tuổi:");
                    int age1 = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Mời bạn nhập quê:");
                    String address1 = sc.nextLine();

                    System.out.println("Mời bạn nhập điểm:");
                    int score1 = sc.nextInt();

                    s.setName(name1);
                    s.setAge(age1);
                    s.setAddress(address1);
                    s.setScore(score1);

                    System.out.println();
                    System.err.println("Đã sửa sinh viên thành công");
                    WriteFile.WriteFile((ArrayList<Student>) listStudent);
                    break;
                }
            }
            if (!validId) {
                System.err.println("Không tìm thấy sinh viên có ID là " + id);
            }
        } while (!validId);
    }

    // Xóa sinh viên theo id
    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        System.out.println("Nhập id của sinh viên cần xóa:");
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
            System.err.println("Đã xóa thành công");
            found = true;
        } else {
            System.err.println("Không tìm thấy sinh viên với id là " + id + ". Vui lòng nhập lại.");
        }
        while (!found) {
            System.out.println("Nhập id của sinh viên cần xóa:");
            id = scanner.nextInt();
            st = null;
            size = listStudent.size();
            for (int i = 0; i < size; i++) {
                if (listStudent.get(i).getId() == id) {
                    st = listStudent.get(i);
                    break;
                }
            }
            if (st != null) {
                listStudent.remove(st);
                System.err.println("Đã xóa thành công");
                found = true;
            } else {
                System.err.println("Không tìm thấy sinh viên với id là " + id + ". Vui lòng nhập lại.");
            }
        }
        WriteFile.WriteFile((ArrayList<Student>) listStudent);
    }

    // Tìm sinh viên theo id
    @Override
    public void search() {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;
        do {
            System.out.println("Tìm kiếm sinh viên theo id:");
            int id = scanner.nextInt();
            ArrayList<Student> list = ReadFile.read();
            for (Student s : list) {
                if (s.getId() == id) {
                    System.out.println(s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy sinh viên với id là " + id + ". Vui lòng nhập lại.");
            }
        } while (!found);
    }

    // Sắp xếp sinh viên theo tên
    @Override
    public void sortName() {
        System.err.println("Sắp xếp sinh viên theo tên:");

        listStudent.sort(Comparator.comparing(Student::getName));
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }

    // Sắp xếp sinh viên theo điểm
    @Override
    public void sortScore() {
        System.err.println("Sắp xếp sinh viên theo điểm:");
        listStudent.sort(Comparator.comparing(Student::getScore));
        for (Student student : listStudent) {
            System.out.println(student);
        }
    }

    // Hiển thị  sinh viên qua môn
    @Override
    public void stPass() {
        System.err.println("hiển thị sinh viên qua môn:");
        for (Student st : listStudent) {
            if (st.getScore() >= 5) {
                System.out.println("Sinh viên qua môn là :" + st);

            }
        }
    }

    // Hiển thị sinh viên phải học lại
    @Override
    public void stNoPass() {
        for (Student st : listStudent) {
            if (st.getScore() < 5) {
                System.out.println("sinh viên học lại là :" + st);
            }
        }
    }

    // Hiển thị số lượng sinh viên có trong danh sách
    @Override
    public void displaySize() {
        System.err.println("Hiển thị số lượng sinh viên:");
        System.out.println("Số lượng sinh viên có trong danh sách là :" + listStudent.size());
    }

    // Hiển thị nhưunxg sinh viên có điểm cao nhất
    @Override
    public void studentsWithHighScores() {
        int maxSocer = 0;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getScore() > maxSocer) {
                maxSocer = listStudent.get(i).getScore();
            }
        }
        ArrayList<Student> studentSocer = new ArrayList<>();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getScore() == maxSocer) {
                studentSocer.add(listStudent.get(i));
            }
        }

        System.out.println(studentSocer);
    }

    //    Hiển thị những sinh viên có điểm thấp nhất
    @Override
    public void studentsWithLowScores() {
        int minSocer = Integer.MAX_VALUE;
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getScore() < minSocer) {
                minSocer = listStudent.get(i).getScore();
            }
        }
        ArrayList<Student> studentSocer = new ArrayList<>();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getScore() == minSocer) {
                studentSocer.add(listStudent.get(i));
            }
        }
        System.out.println(studentSocer);
    }

    @Override
    public void assessStudentCapacity() {
        for (Student st : listStudent) {
            if (st.getScore() > 8 && st.getScore() <= 10) {
                System.out.println("Sinh viên đạt loại A là:" + st);
            } else if (st.getScore() > 6 && st.getScore() <= 8) {
                System.out.println("Sinh viên đạt loại B là: " + st);
            } else if (st.getScore() > 4 && st.getScore() <= 6) {
                System.out.println("Sinh viên đạt loại C là: " + st);
            } else if (st.getScore() > 2 && st.getScore() <= 4) {
                System.out.println("Sinh viên đạt loại D là: " + st);
            } else
                System.out.println("Sinh viên đạt loại E là: " + st);
        }
    }
}
