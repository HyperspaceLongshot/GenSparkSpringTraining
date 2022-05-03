package com.gensparkcart.shoppingCart.Service;

import com.gensparkcart.shoppingCart.Entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllCart();
    Product getItemId(int id);
    void addItem(Product item);
    void changeItem(Product item);
    void deleteItemById(int id);

}
