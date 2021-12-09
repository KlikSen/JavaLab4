package lpnu.resource;

import lpnu.dto.SaunaDTO;
import lpnu.service.SaunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SaunaResource {
    @Autowired
    private SaunaService saunaService;

    @GetMapping("/saunas")
    public List<SaunaDTO> getAllSaunas() {
        return saunaService.getAllSaunas();
    }

    @GetMapping("/saunas/{id}")
    public SaunaDTO getSaunaById(@PathVariable final long id) {
        return saunaService.getSaunaById(id);
    }

    @PostMapping("/saunas")
    public SaunaDTO saveSauna(@RequestBody @Validated final SaunaDTO saunaDTO) {
        return saunaService.saveSauna(saunaDTO);
    }

    @PutMapping("/saunas")
    public SaunaDTO updateSauna(@RequestBody @Validated final SaunaDTO saunaDTO) {
        return saunaService.updateSauna(saunaDTO);
    }

    @DeleteMapping("/saunas/{id}")
    public ResponseEntity deleteSaunaById(@PathVariable final long id) {
        saunaService.deleteSaunaById(id);
        return ResponseEntity.ok().build();
    }
}
