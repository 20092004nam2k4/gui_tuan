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
    public static String UPLOAD_DIRECTORY = "/home/dang/Test111111111111111111/demo26/src/main/resources/static/";

    @GetMapping("/uploadimage")
    public ModelAndView displayUploadForm() {
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("all",uploadRepo.findAll());
        modelAndView.addObject("ob",new ProductJava());
        return modelAndView;
    }
    public String uploadImage(MultipartFile file) throws IOException {
        String fileName=file.getOriginalFilename();
        FileCopyUtils.copy(file.getBytes(), new File(UPLOAD_DIRECTORY+fileName));
        return fileName;
    }
    @PostMapping("/conC")
    public ModelAndView upload(@RequestParam(value = "file") MultipartFile file, @RequestParam(value = "music")MultipartFile file1, ProductJava productJava) throws IOException {
        ModelAndView modelAndView=new ModelAndView("redirect:/product/uploadimage");
        productJava.setImage(uploadImage(file));
        productJava.setCc(uploadImage(file1));
        uploadRepo.save(productJava);
        return modelAndView;
    }
}

