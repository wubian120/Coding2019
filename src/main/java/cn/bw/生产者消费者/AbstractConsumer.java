package cn.bw.生产者消费者;

public abstract class AbstractConsumer implements Consumer, Runnable{

    @Override
    public void run() {
        while (true){
            try{
                consume();
            }catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}


