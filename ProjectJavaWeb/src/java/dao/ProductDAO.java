/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Context.DBContext;
import entity.InvoiceProduct;
import entity.Product;
import entity.Shop;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vu
 */
public class ProductDAO {
    public List<Product> selectAll() throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "select * from [Product]";
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while(rs.next()){
            int productID = rs.getInt("ProductID");
            int shopID = rs.getInt("ShopID");
            String name = rs.getString("Name");
            String image = rs.getString("Image");
            int price = rs.getInt("Price");
            products.add(new Product(productID, shopID, name, image, price));
        }
        rs.close();
        con.close();
        return products;
    }
    
    public List<Product> selectAllByShopID(int shopID) throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "select * from [Product] where ShopID = "+shopID;
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while(rs.next()){
            int productID = rs.getInt("ProductID");
            String name = rs.getString("Name");
            String image = rs.getString("Image");
            int price = rs.getInt("Price");
            products.add(new Product(productID, shopID, name, image, price));
        }
        rs.close();
        con.close();
        return products;
    }
    
    public List<Product> searchByProductID(int productID) throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "select * from [Product] where ProductID = "+productID;
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while(rs.next()){
            int shopID = rs.getInt("ShopID");
            String name = rs.getString("Name");
            String image = rs.getString("Image");
            int price = rs.getInt("Price");
            products.add(new Product(productID, shopID, name, image, price));
        }
        rs.close();
        con.close();
        return products;
    }
    
    public List<Product> searchByPrice(int price) throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "select * from [Product] where Price = "+price;
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while(rs.next()){
            int productID = rs.getInt("ProductID");
            int shopID = rs.getInt("ShopID");
            String name = rs.getString("Name");
            String image = rs.getString("Image");
            products.add(new Product(productID, shopID, name, image, price));
        }
        rs.close();
        con.close();
        return products;
    }
    
    public List<Product> searchByOther(String value, String coloum) throws Exception {
        List<Product> products = new ArrayList<>();
        String query = "select * from [Product] where "+coloum+" like N'%"+value+"%'";
        Connection con = new DBContext().getConnection();
        ResultSet rs = con.prepareStatement(query).executeQuery();
        while(rs.next()){
            int productID = rs.getInt("ProductID");
            int shopID = rs.getInt("ShopID");
            String name = rs.getString("Name");
            String image = rs.getString("Image");
            int price = rs.getInt("Price");
            products.add(new Product(productID, shopID, name, image, price));
        }
        rs.close();
        con.close();
        return products;
    }
    public List<Product> select(int shopidInput) throws Exception {
        List<Product> product = new ArrayList<>();
        String query = "select * from [Product] where shopid=?";
        Connection con = new DBContext().getConnection();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, shopidInput);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("productId");
            int shopid = rs.getInt("shopid");
            String name = rs.getString("name").trim();
            String image = rs.getString("image").trim();
            double  price = rs.getDouble("price");
            product.add(new Product(productId, shopid, name, image, price));
        }
        rs.close();
        con.close();
        return product;
    }
}
