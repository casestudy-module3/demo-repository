package com.example.casestudy.service.implement;

import com.example.casestudy.model.Admin;
import com.example.casestudy.repo.AdminRepo;
import com.example.casestudy.service.IAdmin;

public class AdminService implements IAdmin {
    private static AdminRepo adminRepo = new AdminRepo();
    @Override
    public boolean checkInformation(Admin admin) {
        if (adminRepo.getAdmin().equals(admin)) {
            return true;
        }
        return false;
    }
}
