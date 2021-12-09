package lpnu.mapper;

import lpnu.dto.BroomDTO;
import lpnu.entity.Broom;
import org.springframework.stereotype.Component;

@Component
public class BroomToBroomDTOMapper {
    public Broom toEntity(final BroomDTO broomDTO){
        final Broom broom = new Broom();

        broom.setId(broomDTO.getId());
        broom.setName(broomDTO.getName());
        broom.setPrice(broomDTO.getPrice());
        return broom;
    }

    public BroomDTO toDTO(final Broom broom){
        final BroomDTO broomDTO = new BroomDTO();

        broomDTO.setId(broom.getId());
        broomDTO.setName(broom.getName());
        broomDTO.setPrice(broom.getPrice());

        return broomDTO;
    }
}
