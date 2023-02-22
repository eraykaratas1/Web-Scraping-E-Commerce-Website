package com.meher.yazlab.controller;

import com.meher.yazlab.model.Product;
import com.meher.yazlab.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("akar")
public class ComparisonController {
    private final ProductServiceImpl productService;


    static int delete=0;



    @GetMapping("all")
    public String listProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());

        return "comparisonSite";

    }

    @GetMapping("inline")
    public String inlineProduct(Model model){

        model.addAttribute("products", productService.getinlineAllProducts());

        return "comparisonSite";

    }
    @GetMapping("line")
    public String lineProduct(Model model){

        model.addAttribute("products", productService.getlineAllProducts());

        return "comparisonSite";

    }
    @GetMapping("inlineSkor")
    public String lineSkorProduct(Model model){

        model.addAttribute("products", productService.getinlineSkorAllProducts());

        return "comparisonSite";

    }
    @GetMapping("lineSkor")
    public String inlineSkorProduct(Model model){

        model.addAttribute("products", productService.getlineSkorAllProducts());

        return "comparisonSite";

    }

    @GetMapping("/information/{_id}")
    public String informationProduct(@PathVariable int _id,
                                     @ModelAttribute("product") Product product,
                                     Model model) {

        model.addAttribute("product", productService.getProductById(_id));
        return "informationProduct";
    }
    @GetMapping("acer")
    public String Acer_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Acer";
    }
    @GetMapping("apple")
    public String Apple_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Apple";
    }

    @GetMapping("asus")
    public String Asus_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Asus";
    }

    @GetMapping("dell")
    public String Dell_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Dell";
    }

    @GetMapping("hometech")
    public String Hometech_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Hometech";
    }

    @GetMapping("hp")
    public String Hp_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "HP";
    }

    @GetMapping("lenovo")
    public String Lenovo_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Lenovo";
    }

    @GetMapping("monster")
    public String Monster_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Monster";
    }

    @GetMapping("msi")
    public String MSI_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "MSI";
    }

    @GetMapping("ram")
    public String ram_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ram";
    }

    @GetMapping("ramb")
    public String ramb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ramb";
    }

    @GetMapping("rambb")
    public String rambb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Rambb";
    }

    @GetMapping("rambbb")
    public String rambbb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Rambbb";
    }

    @GetMapping("rambbbb")
    public String rambbbb_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Rambbbb";
    }

    @GetMapping("ssd")
    public String ssd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssd";
    }

    @GetMapping("ssdd")
    public String ssdd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssdd";
    }

    @GetMapping("ssddd")
    public String ssddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssddd";
    }

    @GetMapping("ssdddd")
    public String ssdddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssdddd";
    }

    @GetMapping("ssddddd")
    public String ssddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssddddd";
    }

    @GetMapping("ssdddddd")
    public String ssdddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssdddddd";
    }

    @GetMapping("ssddddddd")
    public String ssddddddd_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Ssddddddd";
    }

    @GetMapping("hepsiburada")
    public String hepsiburada_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Hepsiburada";
    }

    @GetMapping("trendyol")
    public String trendyol_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "Trendyol";
    }

    @GetMapping("n11")
    public String n11_read(Model model) {
        Product product = new Product();
        model.addAttribute("products", productService.getAllProducts());
        return "N11";
    }


}
