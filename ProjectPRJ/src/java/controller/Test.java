/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vu
 */
public class Test extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String shopID = request.getParameter("SHOPID");
            String selectProduct = request.getParameter("selectProduct");
            String searchProduct = request.getParameter("searchProduct");
            String submit = request.getParameter("btnProductSubmit");
            ProductDAO dao = new ProductDAO();
            int shopid = Integer.valueOf(shopID);
            request.setAttribute("AllProduct", dao.selectAllByShopID(shopid));
            request.setAttribute("SHOPID", shopid);
            if (searchProduct != null && selectProduct != null && submit != null) {
                if (selectProduct.equals("productID")) {
                    int productID = Integer.valueOf(searchProduct);
                    request.setAttribute("SearchProID", dao.searchByShopIDAndProductID(shopid, productID));
                }else if(selectProduct.equals("Price")){
                    float price = Float.valueOf(searchProduct);
                    request.setAttribute("SearchPrice", dao.searchByShopIDAndPrice(shopid, price));
                }else {
                    request.setAttribute("SearchOther", dao.searchByShopIDAndNameImage(shopid, searchProduct, selectProduct));
                }
            }

            /////////////////////////////////////////////////////////////////////////////////////////
            RequestDispatcher rd = request.getRequestDispatcher("/container/admin/productinshop.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorProduct", "ProductID and Price must be Integer");
            RequestDispatcher rd = request.getRequestDispatcher("/container/admin/productinshop.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
