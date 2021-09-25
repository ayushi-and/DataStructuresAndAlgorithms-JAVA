package testDemo;

//Push, Pop, getMin() in stack using array
public class test2 {
    int min;
    int size;
    int max = 1000;
    int[] data = new int[max];

    void push(int val) {
        if(size == max - 1) {
            System.out.println("Overflow!");
        }
        if(size == 0) {
            data[size] = val;
            min = val;
        }
        else if(val < min) {
            data[size] = 2 * val - min; //Detection, storing a fake smaller value
            min = val; //original value stored in min
        }
        else {
            data[size] = val;
        }

        ++size;
    }

    int top(test2 s) {
        if(s.size == 0) {
            System.out.println("Stack underflow!");
            return -1;
        }
        else {
            if(s.peek() >= min) {
                return s.peek();
            }
            else {
                return min;
            }
        }
    }

    int pop() {
        if(size == -1) {
            System.out.println("Underflow!");
            return -1;
        }
        --size;

        int val = data[size];

        if(val >= min) {
            return val;
        }
        else {
            int prevMin = min; //original value
            min = 2 * min - val;
            return prevMin;
        }
    }

    int peek() {
        if(size == -1) {
            System.out.println("Underflow!");
            return -1;
        }
        else {
            int temp = data[size];
            return temp;
        }
    }

    int getMin() {
        if(size == -1) {
            System.out.println("Stack underflow!");
            return -1;
        }
        else {
            return min;
        }
    }

    public static void main(String[] args) {
        test2 t = new test2();
        t.push(1);
        t.push(2);
        t.push(3);
        t.push(4);

        System.out.println(t.getMin());
        System.out.println(t.pop());
        System.out.println(t.getMin());

    }
}
