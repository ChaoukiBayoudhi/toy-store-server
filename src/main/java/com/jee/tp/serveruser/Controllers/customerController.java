package com.jee.tp.serveruser.Controllers;

import com.jee.tp.serveruser.Models.Customer;
import com.jee.tp.serveruser.Repositories.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class customerController {
    @Autowired
    private customerRepository custRepos;


    public customerController() {
    }

    @GetMapping("/customersnameLike/{ch}")
    public List<Customer> getCustomerNameLike(@PathVariable("ch") String ch) {
        return custRepos.findAll().stream().
                filter(x -> x.getName().contains(ch))
                .collect(Collectors.toList());
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return custRepos.findById(id).get();
    }
}
