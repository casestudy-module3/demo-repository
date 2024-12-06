package com.example.casestudy.service.implement;

import com.example.casestudy.model.Admin;
import com.example.casestudy.repo.AdminRepo;
import com.example.casestudy.service.IAdmin;

public class AdminService implements IAdmin {
    private static AdminRepo adminRepo = new AdminRepo();
    @Override
    public boolean checkInformation(Admin admin) {
        Admin admins = adminRepo.getAdmin();
        if(admins.getUserName().equals(admin.getUserName()) && admins.getPassword().equals(admin.getPassword())){
            return true;
        }
        return false;
}
}
