package com.gensparkcart.shoppingCart.Controller;

import com.gensparkcart.shoppingCart.Entity.Product;
import com.gensparkcart.shoppingCart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    private ProductService productService;

    @GetMapping("/cart")
    public List<Product> listOJunk(){
        return productService.getAllCart();
    }

    @GetMapping("/cart/{productId}")
    public Product returnProd(@PathVariable String productId){
        try {
            return productService.getItemId(Integer.parseInt(productId));

        } catch (NumberFormatException numE){
            System.out.println("Ruh Roh : Something went wrong!");
            return null;
        }

    }

    @PostMapping("/cart")
    public boolean item(@RequestBody Product product){
        productService.addItem(product);
        return true;
    }

    @PutMapping("/cart")
    public boolean putItem(@RequestBody Product product){
        productService.changeItem(product);
        return true;
    }

    @DeleteMapping("/cart/{productId}")
    public boolean deleteItem(@PathVariable String productId){
        try {
            productService.deleteItemById(Integer.parseInt(productId));
            return true;
        }catch (NumberFormatException numE){
            System.out.println("Nope");
            return false;
        }
    }


}
