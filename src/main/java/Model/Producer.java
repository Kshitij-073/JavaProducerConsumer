package Model;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<Message> blockingQueue;

    public Producer(BlockingQueue<Message> q) {
        this.blockingQueue = q;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Message newMsg = new Message("" + i);
            try {
                Thread.sleep(i);
                blockingQueue.put(newMsg);
                System.out.println("Produced" + newMsg.getMessage());
            }
            catch (InterruptedException IE){
                IE.printStackTrace();
            }
        }

        Message newMsg = new Message("EXIT");
        try {
            blockingQueue.put(newMsg);
        }
        catch (InterruptedException IE){
            IE.printStackTrace();
        }

    }


}
