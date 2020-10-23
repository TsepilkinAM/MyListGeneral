package LIst;

public class Main_3 {
    public static void main(String[] args) {

        MyLIst<Integer> myList1 = new MyLIst<>((a, b) -> {
            if (((int)a.getValue() - (int)b.getValue()) > 0) {
                return 1;
            }
            else if (((int)a.getValue() - (int)b.getValue()) < 0) {
                return -1;
            }
            else
                return 0;
        });

        myList1.add(18);
        myList1.add(5);
        myList1.add(12);
        myList1.add(7);
        myList1.add(19);
        myList1.add(4);

        System.out.println(myList1);
        myList1.sort();
        System.out.println(myList1);




        MyLIst<String> myList2 = new MyLIst<>( (a, b) -> {
            char[] q1 = a.getValue().toString().toCharArray();
            char[] q2 = b.getValue().toString().toCharArray();
            int i = 0;
            while ( (i < (q1).length) && (i < (q2).length) ) {
                if (q1[i] > q2[i])
                    return 1;
                else if (q1[i] < q2[i])
                    return -1;
                else
                    i++;
            }
            return 0;
        });

        myList2.add("Hello");
        myList2.add("World");
        myList2.add("Java");
        myList2.add("Float");
        myList2.add("Program");
        myList2.add("Tree");

        System.out.println(myList2.toString());
        myList2.sort();
        System.out.println(myList2.toString());

    }
}