package concurrency;

public class PrintAlternateNums {
    private static final Object lock = new Object();
    private static int turn = 0;
    private static int curr = 0;
    private static final int CAP = 20;
    private static final int threadNum = 2;


    private static class CountTask implements Runnable{
        private String name;
        private int no;

        public CountTask(String name, int number){
            this.name = name;
            this.no = number;
        }

        @Override
        public void run() {
            while(true){
                synchronized (lock){
                    while(turn % threadNum != no && curr <= CAP){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    if(curr > CAP) {
                        lock.notifyAll();
                        break;
                    }
                    turn++;
                    System.out.println(name + ": " + curr++);
                    lock.notifyAll();
                }
            }
        }
    }
    public static void main(String[] args) {

        Thread threadA = new Thread(new CountTask("A", 0));
        Thread threadB = new Thread(new CountTask("B", 1));
        threadA.start();
        threadB.start();
    }

}
