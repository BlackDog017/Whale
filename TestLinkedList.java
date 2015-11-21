/**
 * Created by asus on 2015/11/20.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestLinkedList {

    public static void main(String[] args) {

        List<String> a=new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        System.out.println(a);

        List<String> b=new ArrayList<String>();
        b.add("d");
        b.add("e");
        b.add("f");
        b.add("g");
        System.out.println(b);

        //��ͨ��Iteratorֻ������������hasNext()��next()��remove()
        Iterator<String> bIter=b.iterator();

        //ListIterator��Iterator������������add(),previous()��hasPrevious()����
        ListIterator<String> aIter=a.listIterator();


        //b�鲢��a���У��������Ĳ���b�е�Ԫ��
        while(bIter.hasNext())
        {
            if(aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }
        System.out.println(a);

        //��b��ÿ������Ԫ��ɾ��һ��
        bIter=b.iterator();

        while(bIter.hasNext())
        {
            bIter.next();
            if(bIter.hasNext())
            {
                bIter.next();//remove��next�ǳɶԳ��ֵģ�remove����ɾ��ǰ��
                bIter.remove();
            }
        }
        System.out.println(b);

        //ɾ��a�����е�b�е�Ԫ��
        a.removeAll(b);
        System.out.println(a);
    }
}
