package com.example.casestudy.service.implement;

import com.example.casestudy.model.Admin;
import com.example.casestudy.repo.AdminRepo;
import com.example.casestudy.service.IAdminService;

import java.util.List;

public class AdminService implements IAdminService {
    private AdminRepo adminRepo= new AdminRepo();
    public List<Admin> getAdmin(){
        return adminRepo.getManagementEventData();
    }
}
