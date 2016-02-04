import java.io.*;

public class SerializationTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        serializeDog();
        Dog dog = deserializeDog();

        System.out.println(dog);
    }

    private static void serializeDog() throws IOException {
        Dog dog = new Dog(5, "Phluffy");
        Owner owner = new Owner("Sam");
        dog.setOwner(owner);

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

    transient int age;
    String name;

    Owner owner;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
//        stream.defaultWriteObject();
        stream.writeInt(age);
        stream.writeObject(name);
        stream.writeObject(owner);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//        stream.defaultReadObject();
        this.age = stream.readInt();
        this.name = (String) stream.readObject();
        this.owner = (Owner) stream.readObject();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}

class Owner implements Serializable {

    String name;

    public Owner(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}
