package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private User user;
    private Map<Broom, Integer> broomMap = new HashMap<>();
    private Sauna sauna;
    private Double timeForOrderSauna;
    private Double totalPrice;
    private LocalDateTime orderTime;
}
