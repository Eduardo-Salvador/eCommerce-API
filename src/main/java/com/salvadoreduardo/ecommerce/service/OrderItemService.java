package com.salvadoreduardo.ecommerce.service;
import com.salvadoreduardo.ecommerce.dto.request.OrderItemRequest;
import com.salvadoreduardo.ecommerce.dto.response.OrderItemResponse;
import com.salvadoreduardo.ecommerce.entity.Order;
import com.salvadoreduardo.ecommerce.entity.OrderItem;
import com.salvadoreduardo.ecommerce.entity.Product;
import com.salvadoreduardo.ecommerce.exception.RuleException;
import com.salvadoreduardo.ecommerce.repository.OrderItemRepository;
import com.salvadoreduardo.ecommerce.repository.OrderRepository;
import com.salvadoreduardo.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderService orderService;

    public OrderItemResponse createOrderItem(OrderItemRequest request) {
        if (request.quantity() <= 0) {
            throw new RuleException("Quantity cannot be zero or negative");
        }
        Order order = findOrderById(request.orderId());
        Product product = findProductById(request.productId());
        BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(request.quantity()));
        OrderItem orderItem = new OrderItem(order, product, request.quantity(), totalPrice);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        orderService.updateOrderTotal(order);
        return OrderItemResponse.fromEntity(savedOrderItem);
    }

    public Page<OrderItemResponse> getAllOrderItems(Pageable pageable) {
        return orderItemRepository.findAll(pageable).map(OrderItemResponse::fromEntity);
    }

    public OrderItemResponse getOrderItemById(Long id) throws RuleException {
        return OrderItemResponse.fromEntity(findOrderItemById(id));
    }

    public OrderItemResponse updateOrderItem(Long id, OrderItemRequest request) {
        OrderItem orderItem = findOrderItemById(id);
        Order order = request.orderId() != null ? findOrderById(request.orderId()) : orderItem.getOrder();
        Product product = request.productId() != null ? findProductById(request.productId()) : orderItem.getProduct();
        request.updateOrderItem(orderItem, order, product);

        BigDecimal totalPrice = product.getPrice()
                .multiply(BigDecimal.valueOf(orderItem.getQuantity()));

        orderItem.setPrice(totalPrice);
        OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        orderService.updateOrderTotal(orderItem.getOrder());
        return OrderItemResponse.fromEntity(savedOrderItem);
    }

    public void deleteOrderItem(Long id) throws RuleException {
        orderItemRepository.delete(findOrderItemById(id));
    }

    private OrderItem findOrderItemById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new RuleException("OrderItem not found"));
    }

    private Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuleException("Order not found"));
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuleException("Product not found"));
    }
}