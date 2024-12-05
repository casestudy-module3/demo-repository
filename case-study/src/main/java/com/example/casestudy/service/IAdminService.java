package com.example.casestudy.service;

import com.example.casestudy.model.Admin;

import java.util.List;

public interface IAdminService<T> {
    List<T> getAdmin();
}
