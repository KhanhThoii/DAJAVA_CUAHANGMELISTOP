package com.DAJAVA.MeliStop.controller;

import com.DAJAVA.MeliStop.model.Product;
import com.DAJAVA.MeliStop.service.CategoryService;
import com.DAJAVA.MeliStop.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService; // Đảm bảo bạn đã inject CategoryService
    // Display a list of all products
    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "/products/home";
    }
    @GetMapping("/search")
    public String searchProductsByName(@RequestParam("name") String name, Model model) {
        List<Product> searchResults = productService.findProductsByName(name);
        model.addAttribute("products", searchResults);
        return "/products/home"; // Template dùng cho người dùng
    }
    @RequestMapping("/403")
    public String accessDenied() {
        return "403"; // Trả về tên của file HTML chứa nội dung lỗi 403
    }

}
