class BasicSingleton {
    public static BasicSingleton instance = null;
    private BasicSingleton() {
        System.out.println("Creating the Singleton..");
    }
    public static BasicSingleton getInstance() {
        if(instance == null) instance = new BasicSingleton();
        return instance;
    }
}

public class TestBasicSingleton {
    public static void main(String[] args) {
        BasicSingleton singleton =  BasicSingleton.getInstance();
        print("obj1", singleton);

        BasicSingleton singleton2 =  BasicSingleton.getInstance();
        print("obj2", singleton2);
    }

    public static void print(String objId, BasicSingleton singleton) {
        System.out.println(String.format("Id: %s\tHash: %d", objId, singleton.hashCode()));
    }
}