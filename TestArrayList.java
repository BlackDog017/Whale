import java.util.ArrayList;

/**
 * Created by asus on 2015/11/20.
 */
public class TestArrayList
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        for(int i =0; i<10;i++)//����������10��IntԪ��
            al.add(i);
        System.out.println(al);
        al.remove(5);//����6��Ԫ���Ƴ�
        System.out.println(al);
        for(int i = 0;i<3;i++)//����3��Ԫ��
            al.add(i+20);
        System.out.println(al);
        al.set(0,"10");
        System.out.println(al);
    }}