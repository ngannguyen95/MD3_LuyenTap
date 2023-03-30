package ra.bussinessImp;

import ra.bussiness.IShop;

import static ra.run.ProductManagement.listCatalog;
import static ra.run.ProductManagement.scanner;

public class Product implements IShop,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private Catalog catalog;
    private float importPrice;
    private float exportPrice;
    private boolean productStatus;

    public Product() {
    }

    public Product(int productId, String productName, String title, String descriptions, Catalog catalog, float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.catalog = catalog;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập tiêu đề sản phẩm");
        this.title = scanner.nextLine();
        System.out.println("Mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        this.importPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Trạng thái sản phẩm: ");
        this.productStatus = Boolean.parseBoolean(scanner.nextLine());
        this.exportPrice = this.importPrice * RATE;
        for (Catalog catalog : listCatalog) {
            catalog.displayData();
        }
        // chọn danh mục sản phẩm cho sản phẩm từ danh sách sản phẩm đang quản lí
        System.out.println("Chọn danh mục sản phẩm theo id:");
        int id = Integer.parseInt(scanner.nextLine());
        for (Catalog catalog : listCatalog) {
            if (catalog.getCatalogId() == id) {
                this.setCatalog(catalog);
            }
        }
    }

    @Override
    public void displayData() {
        System.out.println("Thông tin sản phẩm:" +
                "\nMã sản phẩm: " + productId +
                "\nTên sản phẩm: " + productName +
                "\nTên danh mục sản phẩm: " + catalog.getCatalogName() +
                "\nGiá bán sản phẩm: " + importPrice +
                "\nTrạng thái: " + (productStatus?"Còn hàng":"Hết hàng"));
    }

    @Override
    public int compareTo(Product o) {
        return (int)(this.exportPrice-o.exportPrice);
    }
}
