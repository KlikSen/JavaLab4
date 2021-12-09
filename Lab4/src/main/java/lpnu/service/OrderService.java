package lpnu.service;

import lpnu.dto.OrderDTO;
import lpnu.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(long id);
    OrderDTO saveOrder(OrderDTO order);
    OrderDTO updateOrder(OrderDTO order);
    void deleteOrderById(long id);

    double getTotalPriceForPeriod(LocalDateTime start, LocalDateTime end);
}
