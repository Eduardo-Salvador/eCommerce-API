package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.OrderRequest;
import com.salvadoreduardo.ecommerce.dto.OrderResponse;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.repository.CustomerRepository;
import com.salvadoreduardo.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderResponse createOrder(OrderRequest request) throws IllegalArgumentException {
        if (request.total().doubleValue() < 0) {
            throw new IllegalArgumentException("Total cannot be negative");
        }
        Customer customer = findCustomerById(request.customerId());
        Order order = new Order(customer, request.total());
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public Page<OrderResponse> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(OrderResponse::fromEntity);
    }

    public OrderResponse getOrderById(Long id) throws IllegalArgumentException {
        return OrderResponse.fromEntity(findOrderById(id));
    }

    public OrderResponse updateOrder(Long id, OrderRequest request) throws IllegalArgumentException {
        Order order = findOrderById(id);
        Customer customer = request.customerId() != null ? findCustomerById(request.customerId()) : null;
        request.updateOrder(order, customer);
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public void deleteOrder(Long id) throws IllegalArgumentException {
        orderRepository.delete(findOrderById(id));
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }
}