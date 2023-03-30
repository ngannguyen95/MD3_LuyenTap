package b3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exam_Advance_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> list = new LinkedList<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.println("Nhập vào lựa chọn:");
            int choice =Integer.parseInt(scanner.nextLine()) ;
            switch (choice) {
                case 1:
                    System.out.println("Nhập tên phụ huynh nộp hồ sơ:");
                    String name = scanner.nextLine();
                    list.offer(name);
                    System.out.println("Thêm mới tên thành công");
                    break;
                case 2:
                    System.out.println("Phụ huynh đầu tiên: " + list.poll());
                    break;
                case 3:
                    System.exit(0);
                    System.out.println("Thoát");
                    break;
                default:
                    System.err.println("Vui lòng chọn lại");
                    break;
            }
        }


    }
}
