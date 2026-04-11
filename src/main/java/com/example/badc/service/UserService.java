package com.example.badc.service;

import com.example.badc.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String FILE = "users.bin";

    public static void initDummyUsers() {
        if (new File(FileService.DATA_DIR + FILE).exists()) {
            return;
        }
        List<User> list = new ArrayList<>();

        // Field Officers
        list.add(new FieldOfficer("FO001", "Rahim Uddin",   "1234567890", "rahim123",  "01711111111", "Dhaka",     "SUP001"));
        list.add(new FieldOfficer("FO002", "Karim Mia",     "0987654321", "karim123",  "01722222222", "Rajshahi",  "SUP001"));

        // Report Officers
        list.add(new ReportOfficer("RO001", "Sadia Islam",  "1122334455", "sadia123",  "01733333333", "Production"));
        list.add(new ReportOfficer("RO002", "Nasrin Akter", "5544332211", "nasrin123", "01744444444", "Distribution"));

        // Farmers
        list.add(new FarmerUser("FA001", "Alamgir Hossain", "1111111110", "farmer123", "01755555555", "Dhaka"));
        list.add(new FarmerUser("FA002", "Sumaiya Begum",   "2222222220", "farmer456", "01766666666", "Rajshahi"));

        // Seed Dealers
        list.add(new SeedDealer("SD001", "Rafiqul Islam",  "3333333330", "dealer123", "01777777777", "Al-Amin Seeds",  "Dhaka"));
        list.add(new SeedDealer("SD002", "Moriyom Khatun", "4444444440", "dealer456", "01788888888", "Green Agro Shop","Chittagong"));

        // Admin
        list.add(new AdminUser("AD001", "Admin Boss", "9999999999", "admin123", "01999999999", "Headquarters"));

        // Finance
        list.add(new FinanceOfficer("FI001", "Finance Chief", "8888888888", "finance123", "01888888888", "Accounts"));

        FileService.saveList(FILE, list);
    }

    public static User login(String nid, String password) {
        List<User> list = FileService.loadList(FILE);
        for (User u : list) {
            if (u.getNid().equals(nid) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public static boolean nidExists(String nid) {
        List<User> list = FileService.loadList(FILE);
        for (User u : list) {
            if (u.getNid().equals(nid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean signup(User newUser) {
        if (newUser.getName() == null || newUser.getName().trim().isEmpty()) return false;
        if (newUser.getNid() == null || !newUser.getNid().matches("\\d{10}")) return false;
        if (newUser.getPassword() == null || newUser.getPassword().length() < 6) return false;
        if (newUser.getPhone() == null || newUser.getPhone().trim().isEmpty()) return false;
        if (nidExists(newUser.getNid())) return false;
        FileService.appendObject(FILE, newUser);
        return true;
    }
}
