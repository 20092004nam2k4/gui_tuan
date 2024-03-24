package com.example.demo.controller;

import com.example.demo.model.ProductJava;
import com.example.demo.repository.UploadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("product")
public class UploadController {
    @Autowired
    UploadRepo uploadRepo;
    public static String UPLOAD_DIRECTORY = "\\C:\\Users\\namca\\image\\";

    @GetMapping("/create")
    public ModelAndView displayCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("ob", new ProductJava());
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView displayHomePage() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("all", uploadRepo.findAll());
        return modelAndView;
    }

    public String uploadImage(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY + fileName));
        return fileName;
    }

    @PostMapping("/upload")
    public ModelAndView upload(@RequestParam("file") MultipartFile file, ProductJava productJava) throws IOException {
        ModelAndView modelAndView = new ModelAndView("redirect:/product/create");
        productJava.setImage(uploadImage(file));
        uploadRepo.save(productJava);
        return modelAndView;
    }
}
