package jockercode.digital.digital.controller;

import jockercode.digital.digital.pojo.Product;
import jockercode.digital.digital.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductController {
    @Autowired
    private ProductRepository pRepo;

    public Product save(Product product){
        return   pRepo.save(product);
    }
}
