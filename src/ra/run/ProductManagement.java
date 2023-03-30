package ra.run;

import ra.bussinessImp.Catalog;
import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Catalog> listCatalog = new ArrayList<>();
    public static List<Product> listProduct = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************\n" +
                    "1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục \n" +
                    "2. Nhập số sản phẩm và nhập thông tin các sản phẩm \n" +
                    "3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần (Comparable/Comparator) \n" +
                    "4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm \n" +
                    "5. Thoát \n");
            System.out.println("Nhập vào lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //nhập số danh mục và thông tin danh mục
                    createCatalog();
                    break;
                case 2:
                    //nhập số sản phẩm và thôn tin sản phẩm
                    createProduct();
                    break;
                case 3:
                    //sắp xếp theo giá sản phẩm tăng dần
                    System.out.println("Sắp xếp theo giá tăng dần:");
                    Collections.sort(listProduct);
                    for (Product product : listProduct) {
                        product.displayData();
                    }
                    break;
                case 4:
                    //tìm kiếm sản phẩm theo tên danh mục sản phẩm
                    System.out.println("Nhập vào tên danh mục: ");
                    String catalogName = scanner.nextLine();
                    int cataId = 0;
                    for (Catalog cata : listCatalog) {
                        if (cata.getCatalogName().equals(catalogName)) {
                            cataId = cata.getCatalogId();
                        }
                    }
                    for (Product product : listProduct) {
                        if (product.getProductId() == cataId) {
                            product.displayData();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Thoát");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ");
                    break;
            }

        }
    }

    public static void createCatalog() {
        System.out.println("Nhập số danh mục sản phẩm cần thêm: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Danh mục sản phẩm thứ: " + (i + 1));
            Catalog newCatalog = new Catalog();
            newCatalog.inputData();
            if (listCatalog.size() == 0) {
                newCatalog.setCatalogId(1);
            } else {
                newCatalog.setCatalogId(listCatalog.get(listCatalog.size() - 1).getCatalogId() + 1);
            }
            listCatalog.add(newCatalog);
        }
        for (Catalog catalog : listCatalog) {
            catalog.displayData();
        }
    }

    public static void createProduct() {
        System.out.println("Nhập số sản phẩm cần thêm: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            System.out.println("Sản phẩm thứ: " + (i + 1));
            Product newProduct = new Product();
            newProduct.inputData();
            if (listProduct.size() == 0) {
                newProduct.setProductId(1);
            } else {
                newProduct.setProductId(listProduct.get(listProduct.size() - 1).getProductId() + 1);
            }
            listProduct.add(newProduct);
        }
    }


}
