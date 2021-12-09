package lpnu.service;

import lpnu.dto.BroomDTO;

import java.util.List;

public interface BroomService {
    List<BroomDTO> getAllBrooms();
    BroomDTO getBroomById(long id);
    BroomDTO saveBroom(BroomDTO broomDTO);
    BroomDTO updateBroom(BroomDTO broomDTO);
    void deleteBroomById(long id);
}
