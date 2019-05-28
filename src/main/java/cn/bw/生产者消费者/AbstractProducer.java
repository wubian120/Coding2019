package cn.bw.生产者消费者;

public abstract class AbstractProducer implements Producer,Runnable {

    @Override
    public void run() {
        while (true){
            try{
                produce();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
