import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class Singleton {
    public static Singleton instance = null;
    private Singleton() {
        System.out.println("Creating the Singleton..");
    }
    public static Singleton getInstance() {
        if(instance == null) instance = new Singleton();
        return instance;
    }
}

/**
 * 
 */
public class ReflectionSingleton {
    public static void main(String[] args) throws Exception {
        Class clazz = Singleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);
        constructor.setAccessible(true);
        print("Singleton created by using constructor", (Singleton)constructor.newInstance());
        print("Singleton created by using constructor", (Singleton)constructor.newInstance());
        print("Singleton created by using constructor", (Singleton)constructor.newInstance());
        print("Singleton created by using constructor", (Singleton)constructor.newInstance());
    }

    public static void print(String objId, Singleton singleton) {
        System.out.println(String.format("Id: %s\tHash: %d", objId, singleton.hashCode()));
    }
}