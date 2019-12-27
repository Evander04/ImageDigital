package jockercode.digital.digital.controller;

import jockercode.digital.digital.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopController {
    @Autowired
    private ShopRepository sRepo;

}
