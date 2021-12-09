package lpnu.service.impl;

import lpnu.dto.SaunaDTO;
import lpnu.entity.Sauna;
import lpnu.mapper.SaunaToSaunaDTOMapper;
import lpnu.repository.SaunaRepository;
import lpnu.service.SaunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaunaServiceImpl implements SaunaService {
    @Autowired
    private SaunaRepository saunaRepository;

    @Autowired
    private SaunaToSaunaDTOMapper saunaMapper;

    @Override
    public List<SaunaDTO> getAllSaunas() {
        return saunaRepository.getAllSaunas().stream().map(saunaMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public SaunaDTO getSaunaById(final long id) {
        return saunaMapper.toDTO(saunaRepository.getSaunaById(id));
    }

    @Override
    public SaunaDTO saveSauna(final SaunaDTO saunaDTO) {
        final Sauna sauna = saunaMapper.toEntity(saunaDTO);
        return saunaMapper.toDTO(saunaRepository.saveSauna(sauna));
    }

    @Override
    public SaunaDTO updateSauna(final SaunaDTO saunaDTO) {
        final Sauna sauna = saunaMapper.toEntity(saunaDTO);
        return saunaMapper.toDTO(saunaRepository.updateSauna(sauna));
    }

    @Override
    public void deleteSaunaById(final long id) {
        saunaRepository.deleteSaunaById(id);
    }
}
