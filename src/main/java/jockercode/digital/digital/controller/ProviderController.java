package jockercode.digital.digital.controller;

import jockercode.digital.digital.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderController {
    @Autowired
    private ProviderRepository pRepo;
}
