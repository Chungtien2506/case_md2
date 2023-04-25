package storage;

import Acc.Account;
import model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile<E> {
    public static ArrayList<Student> read() {
        ArrayList<Student> listStudent = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {

            fis = new FileInputStream("text.txt");
            ois = new ObjectInputStream(fis);
            listStudent = (ArrayList<Student>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listStudent;
    }
    public static ArrayList<Account> readData() {
        ArrayList<Account> list = new ArrayList<>();
        try {
           FileInputStream fis = new FileInputStream("Database.txt");
            if(fis.available() != 0) {
               ObjectInputStream ois = new ObjectInputStream(fis);
                list = (ArrayList<Account>) ois.readObject();
            }else {
                return list;
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

}
