package url;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        while (true) {
            System.out.println("\n****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào câu: ");
                    String string = scanner.nextLine();
                    for (String st:string.split("\\s")) {
                        stack.push(st+" ");
                    }
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        throw new IllegalArgumentException("Chưa có chuỗi truyền vào");
                    } else{
                        System.out.println("Câu đảo ngược: ");
                        for (int i = 0; i < stack.size()+i; i++) {
                            System.out.print(stack.pop()+" ");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thoát ");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }

    }


}
