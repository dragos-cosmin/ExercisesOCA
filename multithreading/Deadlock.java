package org.example.multithreading;

/**
 * @author dragos.cosmin
 **/
public class Deadlock {
    static class Friend{
        private final String name;


        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void bow(Friend bower){
            System.out.format("%s: %s"
            +" has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        private synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            +" has bowed back to me!%n",
                    this.name, bower.getName());

        }
    }

    public static void main(String[] args) {
        final Friend tom=new Friend("Tom");
        final Friend sam=new Friend("Sam");
        new Thread(() -> {
            try {
                Thread.sleep(3);    // if we want to unlock deadlock we have to put positive value above 3ms
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            tom.bow(sam);


        }).start();
        new Thread(() -> sam.bow(tom)).start();
    }
}
