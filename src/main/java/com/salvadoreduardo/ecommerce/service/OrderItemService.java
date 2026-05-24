package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.OrderItemRequest;
import com.salvadoreduardo.ecommerce.dto.OrderItemResponse;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.repository.OrderItemRepository;
import com.salvadoreduardo.ecommerce.repository.OrderRepository;
import com.salvadoreduardo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderItemResponse createOrderItem(OrderItemRequest request) throws IllegalArgumentException {
        if (request.quantity().doubleValue() <= 0) {
            throw new IllegalArgumentException("Quantity cannot be zero or negative");
        }
        if (request.price().doubleValue() <= 0) {
            throw new IllegalArgumentException("Price cannot be zero or negative");
        }
        Order order = findOrderById(request.orderId());
        Product product = findProductById(request.productId());
        OrderItem orderItem = new OrderItem(order, product, request.quantity(), request.price());
        return OrderItemResponse.fromEntity(orderItemRepository.save(orderItem));
    }

    public Page<OrderItemResponse> getAllOrderItems(Pageable pageable) {
        return orderItemRepository.findAll(pageable).map(OrderItemResponse::fromEntity);
    }

    public OrderItemResponse getOrderItemById(Long id) throws IllegalArgumentException {
        return OrderItemResponse.fromEntity(findOrderItemById(id));
    }

    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest request) throws IllegalArgumentException {
        OrderItem orderItem = findOrderItemById(id);
        Order order = request.orderId() != null ? findOrderById(request.orderId()) : null;
        Product product = request.productId() != null ? findProductById(request.productId()) : null;
        request.updateOrderItem(orderItem, order, product);
        return OrderItemResponse.fromEntity(orderItemRepository.save(orderItem));
    }

    public void deleteOrderItem(Long id) throws IllegalArgumentException {
        orderItemRepository.delete(findOrderItemById(id));
    }

    private OrderItem findOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("OrderItem not found"));
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }
}