package entity;

import dao.ProductDao;

import java.util.Arrays;


public class Product {
    private int productId;
    private String productName;
    private Long productPrice;
    private String productType;
    private byte[] productImg;
    private String productDes;

    private String productURLImg;

    public Product() {
    }

    public Product(String productName, Long productPrice, String productCarType, byte[] productImg, String productDes) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productCarType;
        this.productImg = productImg;
        this.productDes = productDes;
    }

    public Product(int productId, String productName, Long productPrice, String productType, String productDes) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productType = productType;
        this.productDes = productDes;
    }
    
    

    public Product(int parseInt, String name, long parseLong, int parseInt0, String img, String des, int parseInt1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setProductURLImg(String productURLImg) {
        this.productURLImg = productURLImg;
    }

    public String getProductURLImg() {
        return productURLImg;
    }

    public String getUrlImage(){
        ProductDao dao = new ProductDao();
        return dao.convertToPicture(this.getProductImg(),this.productId);
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public String getProductType() {
        return productType;
    }

    public byte[] getProductImg() {
        return productImg;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productType='" + productType + '\'' +
                ", productImg=" + Arrays.toString(productImg) +
                ", productDes='" + productDes + '\'' +
                '}';
    }
}
