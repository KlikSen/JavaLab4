package lpnu.service.impl;

import lpnu.dto.BroomDTO;
import lpnu.entity.Broom;
import lpnu.mapper.BroomToBroomDTOMapper;
import lpnu.repository.BroomRepository;
import lpnu.service.BroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BroomServiceImpl implements BroomService {
    @Autowired
    private BroomToBroomDTOMapper broomMapper;

    @Autowired
    private BroomRepository broomRepository;

    @Override
    public List<BroomDTO> getAllBrooms() {
        return broomRepository.getAllBroom().stream()
                .map(e -> broomMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public BroomDTO getBroomById(final long id) {
        return broomMapper.toDTO(broomRepository.getBroomById(id));
    }

    @Override
    public BroomDTO saveBroom(final BroomDTO broomDTO) {

        final Broom broom = broomMapper.toEntity(broomDTO);

        broomRepository.saveBroom(broom);

        return broomMapper.toDTO(broom);
    }

    @Override
    public BroomDTO updateBroom(final BroomDTO broomDTO) {
        final Broom broom = broomMapper.toEntity(broomDTO);

        return broomMapper.toDTO(broomRepository.updateBroom(broom));
    }

    @Override
    public void deleteBroomById(final long id) {
        broomRepository.deleteBroomById(id);
    }
}
