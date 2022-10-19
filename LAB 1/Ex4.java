import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter arguments: ");

        String arguments = input.nextLine();
        String[] arr = arguments.split(" ");
        if (arr.length > 3) {
            System.out.println("Too many arguments");
            throw new IndexOutOfBoundsException(); }
        else System.out.println(arr[1]);

    }
}
