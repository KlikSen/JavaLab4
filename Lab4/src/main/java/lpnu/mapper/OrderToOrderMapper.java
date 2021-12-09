package lpnu.mapper;


import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import lpnu.repository.BroomRepository;
import lpnu.repository.UserRepository;
import lpnu.repository.SaunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OrderToOrderMapper {

    @Autowired
    private BroomRepository broomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SaunaRepository saunaRepository;

    public Order toEntity(final OrderDTO orderDTO) {
        final Order order = new Order();


        order.setId(orderDTO.getId());
        order.setOrderTime(orderDTO.getOrderTime());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setTimeForOrderSauna(orderDTO.getTimeForOrderSauna());

        order.setUser(userRepository.getUserById(orderDTO.getUserId()));
        order.setSauna(saunaRepository.getSaunaById(orderDTO.getSaunaId()));

        order.setBroomMap(orderDTO.getBroomMap().entrySet().stream().collect(Collectors.toMap(e -> broomRepository.getBroomById(e.getKey()), Map.Entry::getValue)));


        return order;
    }

    public OrderDTO toDTO(final Order order) {
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderTime(order.getOrderTime());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setTimeForOrderSauna(order.getTimeForOrderSauna());

        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setSaunaId(order.getSauna().getId());

        orderDTO.setBroomMap(order.getBroomMap().entrySet().stream().collect(Collectors.toMap(e -> e.getKey().getId(), Map.Entry::getValue)));

        return orderDTO;
    }
}
