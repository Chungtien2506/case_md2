package Acc;

import storage.ReadFile;
import storage.WriteFile;

import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccManager  {
    Scanner scanner = new Scanner(System.in);
    public  boolean Signin(){
        List<Account> list = ReadFile.readData();
        boolean isSignIn = false;
        System.out.println("Mời đăng nhập");
        System.out.println("Nhập tên tài khoản :");
        String name = scanner.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = scanner.nextLine();
        Account acc = new Account(name, password);
        for(Account account : list){
            if(account.getUserName().equals(name) && account.getPassword().equals(password)){
                isSignIn = true;
                break;
            }
        }
        return isSignIn;
    }


    public static void main(String[] args) {
        ArrayList<Account> list = ReadFile.readData();
        Account admin = new Account("admin", "1");
        list.add(admin);
        WriteFile.WriteFileData(list);
    }
}
