package org.example.multithreading;

/**
 * @author dragos.cosmin
 **/
public class DaemonTest {
    public static void main(String[] args) {
        System.out.println("Main thread "+Thread.currentThread().getName());
        new WorkerThread().start();

        try {
            Thread.sleep(7500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Thread ending");
    }
}

    class WorkerThread extends Thread{
        public WorkerThread() {
            // When false, (i.e. when it's a non daemon thread),
            // the WorkerThread continues to run until 10 counts.
            // When true, (i.e. when it's a daemon thread),
            // the WorkerThread terminates when the main
            // thread or/and user defined thread(non daemon) terminates.
            setDaemon(false);
        }

        public void run() {
            int count=0;
            System.out.println("Worker thread "+Thread.currentThread().getName()+", isDaemon: "+Thread.currentThread().isDaemon());

            while (true){

                System.out.println("Hello from Worker "+count++);
                if (count==10){
                    System.out.println("Worker exited after 10 counts");
                    System.exit(130);
                }

                try {
                    sleep(5000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

