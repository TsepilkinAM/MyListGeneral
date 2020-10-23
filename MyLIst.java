package LIst;

import Classes.MyList;

import java.util.Collection;
import java.util.Iterator;

public class MyLIst<T> implements Collection {
    private  T value;
    private Comparable compare;

    class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }


        public String toString() {
            return value.toString();
        }

        public boolean hasNext () {
            return (this.next != null);
        }
    }

    Node<T> begin;
    long length;
    private Comparable comparable;

    public MyLIst (Comparable compare) {
        this.begin = null;
        this.length = 0;
        this.comparable = compare;
    }



    public String toString() {
        String result = "[ ";
        if (this.begin != null) {
            Node<T> iter = this.begin;
            while (iter.hasNext()) {
                result += iter.getValue() + ", ";
                iter = iter.getNext();
            }
            result += iter.getValue() + " ";
        }
        result += "]";
        return result;
    }


    public Node indexAt(int index) {
        if (index <= this.length - 1 && index >= 0) {
            Node<T> iter = this.begin;
            for (int i = 0; i < index; i++) {
                iter = iter.getNext();
            }
            return iter;
        }
        else
            return null;
    }


    public boolean swap(int firstPos, int secondPos) {
        Node <T> preFirst = indexAt(firstPos - 1);
        Node <T> first = indexAt(firstPos);
        Node <T> aftFirst = indexAt(firstPos + 1);
        Node <T> preSecond = indexAt(secondPos - 1);
        Node <T> second = indexAt(secondPos);
        Node <T> aftSecond = indexAt(secondPos + 1);
        if (preFirst != null) {
            preFirst.setNext(second);
        } else {
            this.begin = second;
        }
        first.setNext(aftSecond);
        if (preSecond == first) {
            second.setNext(first);
        }else {
            second.setNext(aftFirst);
            preSecond.setNext(first);
        }
        return true;
    }


    public void sort() {
        for (int i = 0; i < this.length-1; i++)
            for (int j = 0; j < this.length-1; j++)
                if ( this.comparable.compare( this.indexAt(j), this.indexAt(j+1)) > 0)
                    this.swap(j, j+1);
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
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
    public boolean add (Object t) {
        Node<T> node = new Node<>((T) t);
        if (this.begin == null) {
            this.begin = node;
            this.length++;
        } else {
            end().setNext(node);
            this.length++;
        }
        return true;
    }

    public Node<T> end() {
        if (this.begin == null)
            return null;

        Node<T> iter = this.begin;
        while  (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
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
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
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


interface Comparable{
    int compare(MyLIst.Node a, MyLIst.Node b);
}

