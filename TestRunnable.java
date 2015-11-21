/**
 * Created by asus on 2015/11/20.
 */
class MyThreadA implements Runnable {
    private String name ;
    public MyThreadA(String name) {
        this.name = name;

    }

    public void run() {//重写run方法
        System.out.println("MyThread-->"+ name);

    }

}

public class TestRunnable {
    public static void main(String args[]) {
        MyThreadA t = new MyThreadA("线程");
        new Thread(t).start();//调用线程启动方法
        new Thread(t).start();

    }
}