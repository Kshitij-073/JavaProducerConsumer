package Service;

import Model.Consumer;
import Model.Message;
import Model.Producer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args){

        BlockingQueue<Message> blockingQueue = new ArrayBlockingQueue<>(10);

        Producer producer = new Producer(blockingQueue);
        Consumer consumer = new Consumer(blockingQueue);

        new Thread(producer).start();
        new Thread(consumer).start();

        System.out.println("Producer and Consumer has been started");
    }

}
