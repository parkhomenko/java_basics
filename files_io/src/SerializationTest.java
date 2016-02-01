import java.io.*;

public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //serializeDog();
        Dog dog = deserializeDog();

        System.out.println(dog);
    }

    private static void serializeDog() throws IOException {
        Dog dog = new Dog(5, "Phluffy");

        FileOutputStream fileOutputStream = new FileOutputStream("d:\\dog.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dog);
    }

    private static Dog deserializeDog() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("d:\\dog.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Dog dog = (Dog) objectInputStream.readObject();

        return dog;
    }
}

class Dog implements Serializable {

    private static final long serialVersionUID = 2L;

    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
