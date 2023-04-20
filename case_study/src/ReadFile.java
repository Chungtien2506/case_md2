import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listStudent;
    }

}
