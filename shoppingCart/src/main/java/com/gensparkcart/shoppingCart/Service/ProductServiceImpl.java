package com.gensparkcart.shoppingCart.Service;

import com.gensparkcart.shoppingCart.Dao.ProductDao;
import com.gensparkcart.shoppingCart.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductDao productDao;

    @Override
    public List<Product> getAllCart() {
        return productDao.findAll();
    }

    @Override
    public Product getItemId(int id) {
        return productDao.getById(id);
    }

    @Override
    public void addItem(Product item) {
    productDao.save(item);
    }

    @Override
    public void changeItem(Product item) {
    productDao.save(item);
    }

    @Override
    public void deleteItemById(int id) {
    productDao.deleteById(id);
    }
}
