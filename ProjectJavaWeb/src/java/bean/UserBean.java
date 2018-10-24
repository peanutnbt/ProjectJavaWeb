/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.UsersDAO;
import entity.Users;

/**
 *
 * @author ASUS
 */
public class UserBean {

    private int userId;

    public UserBean() {
    }

    public UserBean(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Users getUserById() throws Exception {
        UsersDAO userDAO = new UsersDAO();
        return userDAO.selectById(userId);
    }
}
