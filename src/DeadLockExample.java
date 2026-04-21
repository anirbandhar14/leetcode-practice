public class DeadLockExample {

    Object lock1 = new Object();
    Object lock2 = new Object();

    Thread t1 = new Thread(()->{
        synchronized (lock1){
            //do something
            synchronized (lock2){
                //do something
            }
        }
    });
    Thread t2 = new Thread(()->{
        synchronized (lock2){
            //
            synchronized (lock1){
                //
            }
        }
    });

}
