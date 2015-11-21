/**
 * Created by asus on 2015/11/20.
 */
class MyThread extends Thread{
    String name;
    public MyThread(String name){
        this.name = name;
    }
    public void run(){
        System.out.println(name+"正在运行");//重写run方法
    }
}

public class TestThread{
    public static void main(String args[]){
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        t1.start();//调用线程启动方法
        t2.start();
    }

}
