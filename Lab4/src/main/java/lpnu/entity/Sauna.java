package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.SaunaType;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sauna {
    private Long id;
    private String name;
    private Double pricePerHourSell;
    private SaunaType saunaType;
}
