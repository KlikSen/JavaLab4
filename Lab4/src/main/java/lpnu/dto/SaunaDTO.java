package lpnu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.SaunaType;

import javax.persistence.EnumType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class SaunaDTO {
    private Long id;

    @NotBlank
    private String name;

    @Min(1)
    @NotNull
    private Double pricePerHourSell;

    @Enumerated(EnumType.ORDINAL)
    private SaunaType saunaType;
}
