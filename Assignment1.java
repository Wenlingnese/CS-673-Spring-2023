public class Assignment1 {
    public static void main(String[] args) {
        System.out.println("Question 2:");
        question2();

        System.out.println("\nQuestion 3:");
        int tableSize = 12;
        question3(tableSize);

        System.out.println("\nQuestion 4:");
        System.out.println("Test Case 1:");
        String test1 = "madam";
        System.out.println("String: " + test1);
        System.out.println("Excepted result: true");
        System.out.println("Actual result: " + question4(test1) + "\n");
        System.out.println("Test Case 2:");
        String test2 = "hello";
        System.out.println("String: " + test2);
        System.out.println("Excepted result: false");
        System.out.println("Actual result: " + question4(test2));

        System.out.println("\nQuestion 5:");
        System.out.println("Test Case:");
        ListNode list1 = new ListNode('a');
        list1.next = new ListNode('b', new ListNode('c'));
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2, new ListNode(3));
        System.out.println("List 1: " + printList(list1));
        System.out.println("List 2: " + printList(list2));
        System.out.println("Excepted result: [a,1,b,2,c,3]");
        System.out.println("Actual result: " + printList(question5(list1, list2)));

        System.out.println("\nQuestion 6:");
        int fibonacciSize = 100;
        long[] fibonacci = question6(fibonacciSize);
        for(int i = 0; i <fibonacciSize; i++) {
            System.out.println(fibonacci[i]);
        }

        System.out.println("\nQuestion 7:");
        int testYear = 2023;
        System.out.println("Test Case 1:");
        System.out.println("Year: " + testYear);
        System.out.println("Excepted result: false");
        System.out.println("Actual result: " + question7(testYear));
        testYear = 1900;
        System.out.println("Test Case 2:");
        System.out.println("Year: " + testYear);
        System.out.println("Excepted result: false");
        System.out.println("Actual result: " + question7(testYear));
        testYear = 2000;
        System.out.println("Test Case 3:");
        System.out.println("Year: " + testYear);
        System.out.println("Excepted result: true");
        System.out.println("Actual result: " + question7(testYear));
    }

    public static void question2() {
        System.out.println("Hello World");
    }

    public static void question3(int tableSize) {
        for (int i = 1; i <= tableSize; i++) {
            for (int j = 1; j <= tableSize; j++) {
                System.out.println(i + " * " + j + " = " + i*j);
            }
        }
    }

    public static boolean question4(String str) {
        int pointer1 = 0;
        int pointer2 = str.length() - 1;
        while (pointer1 <= pointer2) {
            if (str.charAt(pointer1) != str.charAt(pointer2)) {
                return false;
            }
            pointer1 ++;
            pointer2 --;
        }
        return true;
    }

    public static ListNode question5(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (list1 != null && list2 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }
        if (list1 == null) {
            current.next = list2;
        }
        if (list2 == null) {
            current.next = list1;
        }
        return result.next;
    }

    public static String printList(ListNode list) {
        String result = "[";
        while(list.next != null) {
            result += list.value + ",";
            list = list.next;
        }
        result += list.value + "]";
        return result;
    }

    public static long[] question6(int size) {
        long[] result = new long[size];
        result[0] = 1L;
        result[1] = 1L;
        for(int i = 2; i < size; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result;
    }

    public static boolean question7(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
