package com.example.website.controllers;

import com.example.website.dto.SignUpDto;
import com.example.website.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @ModelAttribute("form") SignUpDto form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // добавить сообщения об ошибке во вью
            return "sign_up";
        }
        service.signUp(form);
        return "redirect:/signIn";
    }

//    private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//    @PostMapping("/signUp")
//    public String signUp(@ModelAttribute("form") SignUpDto form, Model model) {
//        try {
//            service.signUp(form);
//            return "redirect:/signIn";
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            logger.error(errorMessage);
//            model.addAttribute("errorMessage", errorMessage);
//
//            model.addAttribute("add", true);
//            return "sign_up";
//        }
//    }

}
