/**
 * Created by asus on 2015/11/20.
 */
class MyThread extends Thread{
    String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        System.out.println(name+"��������");//��дrun����
    }
}

public class TestThread{
    public static void main(String args[]){
        MyThread t1 = new MyThread("�߳�1");
        MyThread t2 = new MyThread("�߳�2");
        t1.start();//�����߳���������
        t2.start();
    }

}
