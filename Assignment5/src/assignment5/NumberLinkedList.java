package assignment5;

public class NumberLinkedList {

    private NumberNode head;

    public NumberLinkedList() {
        head = null;
    }

    public void add(double value) {
        NumberNode newNode = new NumberNode(value);

        if (head == null) {
            head = newNode;
        } else {
            NumberNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }
    public double getMean() {
        if (head == null) {
            return 0;
        }

        double sum = 0;
        int count = 0;

        NumberNode current = head;

        while (current != null) {
            sum = sum + current.value;
            count++;
            current = current.next;
        }

        return sum / count;
    }
    public double getStandardDeviation() {
        double mean = getMean();
        double sum = 0;
        int count = 0;

        NumberNode current = head;

        while (current != null) {
            double difference = current.value - mean;
            sum = sum + (difference * difference);
            count++;
            current = current.next;
        }

        if (count <= 1) {
            return 0;
        }

        return Math.sqrt(sum / (count - 1));
    }
}