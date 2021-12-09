package lpnu.resource;


import lpnu.dto.OrderDTO;
import lpnu.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderResource {

    private OrderService orderService;

    public OrderResource(final OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable final long id) {
        return orderService.getOrderById(id);
    }


    @PostMapping(value = "/orders", produces = "application/json", consumes = "application/json")
    public OrderDTO saveOrder(@RequestBody @Validated final OrderDTO orderDTO) {
        return orderService.saveOrder(orderDTO);
    }


    @PutMapping(value = "/orders", produces = "application/json", consumes = "application/json")
    public OrderDTO updateOrder(@RequestBody @Validated final OrderDTO orderDTO) {
        return orderService.updateOrder(orderDTO);
    }


    @DeleteMapping("/orders/{id}")
    public ResponseEntity deleteOrderById(@PathVariable final long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}

