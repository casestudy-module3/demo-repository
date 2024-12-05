package com.example.casestudy.repo;

import com.example.casestudy.model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminRepo {
    private List<Admin> admins= new ArrayList<>();

    public List<Admin> getAdmin() {
        return admins;
    }
}
