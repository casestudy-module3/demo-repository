package com.example.casestudy.model;

import java.time.LocalDate;

public class Admin {
    private Integer idAdmin;
    private String userName;
    private String passWord;
    private String fullName;
    private LocalDate dob;
    private Boolean gender;
    private String email;
    private String address;
    private String position;
    private String phone;

    public Admin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public Admin(Integer idAdmin, String fullName, LocalDate dob, Boolean gender, String email, String address, String position, String phone) {
        this.idAdmin = idAdmin;
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.position = position;
        this.phone = phone;
    }

    public Admin(String fullName, LocalDate dob, Boolean gender, String address, String phone) {
        this.fullName = fullName;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
