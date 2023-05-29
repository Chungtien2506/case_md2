package taikhoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Đăng ký");
            System.out.println("2. Đăng nhập");
            System.out.println("3. Thoát");
            System.out.print("Chọn tùy chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    registerUser(scanner, userList);
                    break;
                case 2:
                    loginUser(scanner, userList);
                    break;
                case 3:
                    System.out.println("Tạm biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Tùy chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void registerUser(Scanner scanner, List<User> userList) {
        System.out.println("==== ĐĂNG KÝ ====");
        String email;
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();

            // Kiểm tra email đã tồn tại trong danh sách người dùng hay chưa
            boolean emailExists = false;
            for (User user : userList) {
                if (user.getEmail().equals(email)) {
                    emailExists = true;
                    break;
                }
            }

            if (emailExists) {
                System.out.println("Email đã tồn tại. Vui lòng nhập lại.");
            } else if (isValidEmail(email)) {
                break;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập lại.");
            }
        }

        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        User user = new User(email, password);
        userList.add(user);

        System.out.println("Đăng ký thành công!");
        System.out.println();
    }


    private static void loginUser(Scanner scanner, List<User> userList) {
        System.out.println("==== ĐĂNG NHẬP ====");
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        boolean isLoggedIn = false;
        for (User user : userList) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                isLoggedIn = true;
                break;
            }
        }

        if (isLoggedIn) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Email hoặc mật khẩu không chính xác. Vui lòng thử lại.");
        }
        System.out.println();
    }

    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@gmail\\.com$";
        return email.matches(regex);

    }
}
