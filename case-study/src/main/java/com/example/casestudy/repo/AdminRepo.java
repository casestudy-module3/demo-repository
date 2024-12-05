package com.example.casestudy.repo;

import com.example.casestudy.model.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminRepo {
    private static List<Admin> admins = new ArrayList<>();

    public List<Admin> getManagementEventData() {
        admins.clear();
        String query = "SELECT me.id, me.full_name, me.dob, me.gender, me.email, me.address, me.position, me.phoneNumber " +
                "FROM admins me;";

        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String fullName = resultSet.getString("full_name");
                LocalDate dob = resultSet.getDate("dob").toLocalDate();
                Boolean gender = resultSet.getBoolean("gender");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String position = resultSet.getString("position");
                String phone = resultSet.getString("phoneNumber");

                admins.add(new Admin(id, fullName, dob, gender, email, address, position, phone));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return admins;
    }

}
