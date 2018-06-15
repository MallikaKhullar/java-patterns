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
 * If multiple threads try to fetch (and potentially initialize Singleton instances for the first time)
 * it can cause problems in concurrency
 */
public class TestMultithreadedSingleton {
    static void useSingleton() {
        Singleton singleton =  Singleton.getInstance();
        print("SingletonObj", singleton);
    }
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.submit(TestMultithreadedSingleton::useSingleton);
        pool.submit(TestMultithreadedSingleton::useSingleton);
        pool.shutdown();

    }

    public static void print(String objId, Singleton singleton) {
        System.out.println(String.format("Id: %s\tHash: %d", objId, singleton.hashCode()));
    }
}