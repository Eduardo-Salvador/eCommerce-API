package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.request.OrderRequest;
import com.salvadoreduardo.ecommerce.dto.response.OrderResponse;
import com.salvadoreduardo.ecommerce.entity.Customer;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import com.salvadoreduardo.ecommerce.exception.RuleException;
import com.salvadoreduardo.ecommerce.repository.CustomerRepository;
import com.salvadoreduardo.ecommerce.repository.OrderItemRepository;
import com.salvadoreduardo.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;

    public OrderResponse createOrder(OrderRequest request) {
        Customer customer = findCustomerById(request.customerId());
        Order order = new Order(customer, BigDecimal.ZERO);
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public Page<OrderResponse> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(OrderResponse::fromEntity);
    }

    public OrderResponse getOrderById(Long id) throws RuleException {
        return OrderResponse.fromEntity(findOrderById(id));
    }

    public OrderResponse updateOrder(Long id, OrderRequest request) throws RuleException {
        Order order = findOrderById(id);
        Customer customer = request.customerId() != null ? findCustomerById(request.customerId()) : null;
        return OrderResponse.fromEntity(orderRepository.save(order));
    }

    public void deleteOrder(Long id) throws RuleException {
        orderRepository.delete(findOrderById(id));
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuleException("Order not found"));
    }

    private Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuleException("Customer not found"));
    }

    public void updateOrderTotal(Order order) {
        List<OrderItem> items = orderItemRepository.findByOrder(order);
        BigDecimal total = items.stream()
                .map(OrderItem::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        order.setTotal(total);
        orderRepository.save(order);
    }
}