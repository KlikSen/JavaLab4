package lpnu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;

    @Min(1)
    @NotNull
    private Long userId;

    @NotNull
    private Map<Long, Integer> broomMap;

    @Min(1)
    @NotNull
    private Long saunaId;

    @Min(1)
    @NotNull
    private Double timeForOrderSauna;

    private Double totalPrice;

    @JsonFormat(pattern="yyyy-MM-dd HH")
    private LocalDateTime orderTime;
}
