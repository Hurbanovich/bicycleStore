package com.kreva.bicycleStore.controller;

import com.kreva.bicycleStore.model.Product;
import com.kreva.bicycleStore.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ShopController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/product")
    public String product(Model model) {
        model.addAttribute("title", "Продукты");
        Iterable<Product> productList = productService.getAllProduct();
        model.addAttribute("produtList", productList);
        return "product";
    }

    @GetMapping("/product/add")
    public String productAdd(Model model) {
        return "product-add";
    }


    @PostMapping("/product/add")
    public String productNewAdd(@RequestParam String name,
                                @RequestParam int price,
                                @RequestParam int quantity,
                                @RequestParam String comment,
                                @RequestParam String chapter,
                                Model model) {
        productService.saveProduct(productService.newProduct(name, comment, chapter, price, quantity));
        return "product-add";
    }

    @GetMapping("/product/{id}")
    public String productDetals(@PathVariable(value = "id") long id, Model model) {
        Optional<Product> product = Optional.ofNullable(productService.getById(id));
        Product productDetail = product.get();
        model.addAttribute("product", productDetail);
        return "product-detail";
    }

    @GetMapping("/product/{id}/edit")
    public String productEdit(@PathVariable(value = "id") long id, Model model) {
        Optional<Product> product = Optional.ofNullable(productService.getById(id));
        Product productDetail = product.get();
        model.addAttribute("product", productDetail);
        return "product-edit";
    }

    @PostMapping("/product/{id}/edit")
    public String productEditData(@PathVariable(value = "id") long id,
                                  @RequestParam String name,
                                  @RequestParam int price,
                                  @RequestParam int quantity,
                                  @RequestParam String comment,
                                  @RequestParam String chapter,
                                  Model model) {
        productService.editProdyct(id, name, price, quantity, comment, chapter);
        return "redirect:/product";
    }

    @PostMapping("/product/{id}/remove")
    public String productRemoveData(@PathVariable(value = "id") long id, Model model) {
        productService.remove(id);
        return "redirect:/product";
    }

}
