package storage;

import model.Student;

import java.io.*;
import java.util.List;

public class ReadAndWriteImpl implements IReadAndWrite {
    private File file;
    private ReadAndWriteImpl() {}
    private static ReadAndWriteImpl instance;
    public static ReadAndWriteImpl getInstance() {
        if (instance == null) {
            instance = new ReadAndWriteImpl();
        }
        return instance;
    }
    public ReadAndWriteImpl(File file) {
        this.file = file;
    }

    @Override
    public void writeFileStudent(List<Student> students) {
        file = new File("text.txt");
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);
            objectOutputStream.writeObject(students);
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> readFileStudent() {
        file = new File("text.txt");
        List<Student> students;
        try {
            InputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            students = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}

/** Class này là để đọc ghi file nhị phân
 * Áp dụng design pattern là Singleton
 * Interface IReadAndWrite để đảm bảo cơ chế DI
 */

