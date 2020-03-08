package work1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class MartSet<T> implements Set {
    private int index;
    //initial capacity
    private int N=1;
    //private double LF=0.75;
    private int size=0;
    private T t;
    private Node<T>[] array=new Node[N];
// inde = o.hhashode % size
    private static class Node<T>{
        int hash;
        T object;
        Node next;

        public Node(int hash, T object) {
            this.hash = hash;
            this.object = object;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", object=" + object +"} ";
        }
    }

    public String createStringFromLinkedList(Node node){
        String str="";
        if(node==null){
            return null;
        } else{
            while(node!=null){
                str+=node.toString();
                node=node.next;
            }
            return str;
        }
    }

    public void printSet(){
        for (int i = 0; i <array.length ; i++) {
            System.out.println("index:"+i+" item:"+createStringFromLinkedList(array[i]));
        }
    }

    @Override
    public boolean add(Object o) {
        T t=(T)o;
        int hash=t.hashCode();
        index=hash&(N-1);
        Node<T> node=new Node(hash, t);

        if(array[index]==null){
            array[index]=node;
        } else {
            Node temp=array[index];
            while (true){
                if (temp.hash==node.hash){
                    System.out.println("equal hash! additional Equals check!");
                    if(temp.object.equals(node.object)){
                        System.out.println("objects are equal!");
                        return false;
                    }
                } else {
                    if (temp.next==null){
                        break;
                    }
                     temp=temp.next;
                }
            }
            temp.next = node;
        }
        size++;
        return true;
    }

    public boolean addTest(Object o) {
        T t=(T)o;
        int hash=t.hashCode();
        index=hash&(N-1);
        Node<T> node=new Node(hash, t);
                if (array[index].hash==node.hash) {
                    System.out.println("equal hash!");
                    return false;
                } else{
                    array[index].next=node;
                    size++;
                }
        return true;
    }

    public boolean addTest2cycles(Object o) {
        T t=(T)o;
        int hash=t.hashCode();
        index=hash&(N-1);
        Node<T> node=new Node(hash, t);

        //реализовать за один цикл
        if(array[index]==null){
            array[index]=node;
        } else {
            Node temp=array[index];
            while (temp!=null){
                if (temp.hash==node.hash){
                    System.out.println("equal hash!");
                    return false;
                } else {
                    temp=temp.next;
                }
            }
            //temp.next = node;
            Node temp1=array[index];
            while (temp1.next!=null){
                temp1=temp1.next;
            }
            temp1.next = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
