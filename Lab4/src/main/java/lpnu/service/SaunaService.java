package lpnu.service;

import lpnu.dto.SaunaDTO;

import java.util.List;

public interface SaunaService {

    List<SaunaDTO> getAllSaunas();
    SaunaDTO getSaunaById(long id);
    SaunaDTO saveSauna(SaunaDTO saunaDTO);
    SaunaDTO updateSauna(SaunaDTO saunaDTO);
    void deleteSaunaById(long id);

}
