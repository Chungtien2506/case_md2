package storage;

import Acc.Account;
import model.Student;

import java.io.*;
import java.util.ArrayList;

public class WriteFile<E> {
    public static void WriteFile(ArrayList<Student> listStudent) {
        File file = new File("text.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listStudent);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteFileData(ArrayList<Account> list) {
        File file = new File("Database.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

