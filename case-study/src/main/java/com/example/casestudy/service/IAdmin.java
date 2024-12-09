package com.example.casestudy.service;

import com.example.casestudy.model.Admin;

import java.util.List;

public interface IAdmin {
    List<Admin> getAdmin();
    boolean checkInformation(Admin admin);
    boolean updateInformation(Admin admin);
    boolean logOut(String action);
}
