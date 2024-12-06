package com.example.casestudy.service.implement;

import com.example.casestudy.model.Admin;
import com.example.casestudy.repo.AdminRepo;
import com.example.casestudy.service.IAdmin;

import java.util.List;

public class AdminService implements IAdmin {
    private static AdminRepo adminRepo = new AdminRepo();
    @Override
    public boolean checkInformation(Admin admin) {
        Admin admins = adminRepo.getAdmin();
        if(admins.getUserName().equals(admin.getUserName()) && admins.getPassWord().equals(admin.getPassWord())){
            return true;
        }
        return false;
}

    public List<Admin> getAdmin(){
        return adminRepo.getManagementEventData();
    }
}
