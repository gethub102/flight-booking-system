package main.java.com.offer.dao;

import main.java.com.offer.domain.Admin;

public interface AdminDao {
    Admin login(Admin admin);
    Admin updateProfile(Admin admin);
}
