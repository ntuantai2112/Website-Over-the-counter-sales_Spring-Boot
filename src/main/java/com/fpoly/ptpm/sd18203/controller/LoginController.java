package com.fpoly.ptpm.sd18203.controller;

import com.fpoly.ptpm.sd18203.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String loginForm(
            Model model,
            UserDTO userDTO
    ) {
        model.addAttribute("email", userDTO.getEmail());
        model.addAttribute("password", userDTO.getPassword());

        return "index";
    }
}
