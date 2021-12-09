package lpnu.service.impl;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import lpnu.mapper.OrderToOrderMapper;
import lpnu.repository.OrderRepository;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderToOrderMapper orderMapper;

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.getAllOrders().stream()
                .map(e -> orderMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(final long id) {
        return orderMapper.toDTO(orderRepository.getOrderById(id));
    }

    @Override
    public OrderDTO saveOrder(final OrderDTO orderDTO) {
        final Order order = orderMapper.toEntity(orderDTO);

        Double totalPrice = order.getBroomMap().entrySet().stream().collect(Collectors.summingDouble(e -> e.getKey().getPrice() * e.getValue()));
        totalPrice += order.getSauna().getPricePerHourSell() * order.getTimeForOrderSauna();

        order.setTotalPrice(totalPrice);

        orderRepository.saveOrder(order);

        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO updateOrder(final OrderDTO orderDTO) {

        final Order order = orderMapper.toEntity(orderDTO);

        Double totalPrice = order.getBroomMap().entrySet().stream().collect(Collectors.summingDouble(e -> e.getKey().getPrice() * e.getValue()));
        totalPrice += order.getSauna().getPricePerHourSell() * order.getTimeForOrderSauna();

        order.setTotalPrice(totalPrice);

        return orderMapper.toDTO(orderRepository.updateOrder(order));
    }

    @Override
    public void deleteOrderById(final long id) {
        orderRepository.deleteOrderById(id);
    }


    @Override
    public double getTotalPriceForPeriod(final LocalDateTime start, final LocalDateTime end) {
        return orderRepository.getAllOrders().stream()
                .filter(e -> e.getOrderTime().isAfter(start) && e.getOrderTime().isBefore(end))
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }
}
