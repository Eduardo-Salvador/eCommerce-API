package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.CustomerRequest;
import com.salvadoreduardo.ecommerce.dto.CustomerResponse;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerResponse createCustomer(CustomerRequest customerRequest) throws IllegalArgumentException {
        if (customerRequest.email() != null && customerRepository.existsByEmail(customerRequest.email())) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (customerRequest.cpf() != null && customerRepository.existsByCpf(customerRequest.cpf())) {
            throw new IllegalArgumentException("CPF already exists");
        }
        Customer customer = new Customer(customerRequest.firstName(), customerRequest.lastName(), customerRequest.cpf(), customerRequest.birthDate(), customerRequest.email());
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerResponse.fromEntity(savedCustomer);
    }

    public Page<CustomerResponse> getAllCustomers(Pageable pageable){
        return customerRepository.findAll(pageable).map(CustomerResponse::fromEntity);
    }

    public CustomerResponse getCustomerById(Long id) throws IllegalArgumentException {
        Customer customer = findCustomerById(id);
        return CustomerResponse.fromEntity(customer);
    }

    public CustomerResponse updateCustomer(Long id, CustomerRequest customerRequest) throws IllegalArgumentException {
        Customer customer = findCustomerById(id);
        customerRequest.updateCustomer(customer);
        Customer updatedCustomer = customerRepository.save(customer);
        return CustomerResponse.fromEntity(updatedCustomer);
    }

    public void deleteCustomer(Long id) throws IllegalArgumentException {
        Customer customer = findCustomerById(id);
        customerRepository.delete(customer);
    }

    private Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}