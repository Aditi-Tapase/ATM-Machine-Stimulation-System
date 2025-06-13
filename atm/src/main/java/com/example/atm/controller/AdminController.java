package com.example.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atm.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (adminService.login(username, password)) {
            return "Admin login successful.";
        }
        return "Invalid admin credentials.";
    }

    @PostMapping("/load-cash")
    public String loadCash(@RequestParam double amount) {
        return adminService.loadCash(amount);
    }

    @GetMapping("/balance")
    public double getBalance() {
        return adminService.viewAtmBalance();
    }
}

