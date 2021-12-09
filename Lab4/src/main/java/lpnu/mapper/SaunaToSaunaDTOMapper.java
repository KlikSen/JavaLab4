package lpnu.mapper;

import lpnu.dto.SaunaDTO;
import lpnu.entity.Sauna;
import org.springframework.stereotype.Component;

@Component
public class SaunaToSaunaDTOMapper {
    public Sauna toEntity(final SaunaDTO saunaDTO){
        final Sauna sauna = new Sauna();

        sauna.setId(saunaDTO.getId());
        sauna.setName(saunaDTO.getName());
        sauna.setPricePerHourSell(saunaDTO.getPricePerHourSell());
        sauna.setSaunaType(saunaDTO.getSaunaType());

        return sauna;
    }

    public SaunaDTO toDTO(final Sauna sauna){
        final SaunaDTO saunaDTO = new SaunaDTO();

        saunaDTO.setId(sauna.getId());
        saunaDTO.setName(sauna.getName());
        saunaDTO.setPricePerHourSell(sauna.getPricePerHourSell());
        saunaDTO.setSaunaType(sauna.getSaunaType());

        return saunaDTO;
    }
}
