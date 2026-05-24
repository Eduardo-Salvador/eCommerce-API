package com.salvadoreduardo.ecommerce.controller;
import com.salvadoreduardo.ecommerce.dto.OrderItemRequest;
import com.salvadoreduardo.ecommerce.dto.OrderItemResponse;
import com.salvadoreduardo.ecommerce.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemResponse createOrderItem(@RequestBody OrderItemRequest request) {
        return orderItemService.createOrderItem(request);
    }

    @GetMapping
    public Page<OrderItemResponse> getAllOrderItems(Pageable pageable) {
        return orderItemService.getAllOrderItems(pageable);
    }

    @GetMapping("/{id}")
    public OrderItemResponse getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemResponse updateOrderItem(@PathVariable Long id, @RequestBody OrderItemRequest request) {
        return orderItemService.updateOrderItem(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderItem(@PathVariable Long id) {
        orderItemService.deleteOrderItem(id);
    }
}