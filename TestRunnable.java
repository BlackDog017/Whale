/**
 * Created by asus on 2015/11/20.
 */
class MyThreadA implements Runnable {
    private String name ;
    public MyThreadA(String name) {
        this.name = name;

    }

    public void run() {//��дrun����
        System.out.println("MyThread-->"+ name);

    }

}

public class TestRunnable {
    public static void main(String args[]) {
        MyThreadA t = new MyThreadA("�߳�");
        new Thread(t).start();//�����߳���������
        new Thread(t).start();

    }
}