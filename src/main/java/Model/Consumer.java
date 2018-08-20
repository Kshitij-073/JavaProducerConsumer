package Model;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> blockingQueue;

    public Consumer(BlockingQueue<Message> q){
        this.blockingQueue = q;
    }

    @Override
    public void run(){
        try {
            Message msg;
            while((msg = blockingQueue.take()).getMessage() !="exit"){
                Thread.sleep(10);
                System.out.println("Consumed" + msg.getMessage());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
