package lpnu.resource;

import lpnu.dto.BroomDTO;
import lpnu.service.BroomService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BroomResource {

    private BroomService broomService;

    public BroomResource(final BroomService broomService) {
        this.broomService = broomService;
    }

    @GetMapping("/brooms")
    public List<BroomDTO> getAllBrooms() {
        return broomService.getAllBrooms();
    }

    @GetMapping("/brooms/{id}")
    public BroomDTO getBroomById(@PathVariable final long id) {
        return broomService.getBroomById(id);
    }


    @PostMapping("/brooms")
    public BroomDTO saveBroom(@RequestBody @Validated final BroomDTO broomDTO) {
        return broomService.saveBroom(broomDTO);
    }


    @PutMapping("/brooms")
    public BroomDTO updateBroom(@RequestBody @Validated final BroomDTO broomDTO) {
        return broomService.updateBroom(broomDTO);
    }


    @DeleteMapping("/brooms/{id}")
    public ResponseEntity deleteBroomById(@PathVariable final long id) {
        broomService.deleteBroomById(id);
        return ResponseEntity.ok().build();
    }
}

