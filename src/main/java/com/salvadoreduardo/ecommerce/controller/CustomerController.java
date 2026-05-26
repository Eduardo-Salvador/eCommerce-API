package com.salvadoreduardo.ecommerce.controller;
import com.salvadoreduardo.ecommerce.dto.CustomerRequest;
import com.salvadoreduardo.ecommerce.dto.CustomerResponse;
import com.salvadoreduardo.ecommerce.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping
    public Page<CustomerResponse> getAllCustomers(Pageable pageable){
        return customerService.getAllCustomers(pageable);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponse updateCustomer(@PathVariable Long id, @RequestBody CustomerRequest customerRequest){
        return customerService.updateCustomer(id, customerRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}