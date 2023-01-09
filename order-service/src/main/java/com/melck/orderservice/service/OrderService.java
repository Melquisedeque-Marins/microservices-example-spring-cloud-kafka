package com.melck.orderservice.service;

import com.melck.orderservice.dto.OrderLineItemsDto;
import com.melck.orderservice.dto.OrderRequest;
import com.melck.orderservice.model.Order;
import com.melck.orderservice.model.OrderLineItems;
import com.melck.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;

    public void placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = request.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);
        Boolean result = webClient.get()
                    .uri("http://localhost:8082/api/inventory")
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        if(result) {
            orderRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product is not in stock, try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
