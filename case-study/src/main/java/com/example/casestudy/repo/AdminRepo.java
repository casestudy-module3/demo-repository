package com.example.casestudy.repo;

import com.example.casestudy.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminRepo {
    private static AdminRepo adminRepo = new AdminRepo();
    public Admin getAdmin(){
        try{
            PreparedStatement statement = Database.getConnection().prepareStatement("select * from admins where user_name=? and password_ad=?");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                String userName = resultSet.getString("user_name");
                String password = resultSet.getString("password_ad");
                return new Admin(userName,password);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return adminRepo.getAdmin();
    }
}
