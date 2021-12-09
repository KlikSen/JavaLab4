package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Broom;
import lpnu.exception.ServiceException;
import lpnu.util.JacksonUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public class BroomRepository {
    private List<Broom> brooms;

    private long id = 1;


    @PostConstruct
    public void init() {

        final Path file = Paths.get("brooms.txt");
        try {
            final String savedBroomsAsString = Files.readString(file, StandardCharsets.UTF_16);
            brooms = JacksonUtil.deserialize(savedBroomsAsString, new TypeReference<List<Broom>>() {
            });

            if (brooms == null) {
                brooms = new ArrayList<>();
                return;
            }

            final long maxId = brooms.stream().mapToLong(Broom::getId).max().orElse(1);

            this.id = maxId + 1;


        } catch (final Exception e) {
            System.out.println("We have an issue");
            brooms = new ArrayList<>();
        }
    }

    @PreDestroy
    public void preDestroy() {
        final Path file = Paths.get("brooms.txt");
        try {
            Files.writeString(file, JacksonUtil.serialize(brooms), StandardCharsets.UTF_16);
        } catch (final Exception e) {
            System.out.println("We have an issue");
        }
    }

    public List<Broom> getAllBroom() {
        return new ArrayList<>(brooms);
    }

    public Broom getBroomById(final Long id) {
        return brooms.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "broom with id {" + id + "} not found"));
    }

    public Broom saveBroom(final Broom broom) {
        broom.setId(id);

        ++id;

        brooms.add(broom);
        return broom;
    }

    public Broom updateBroom(final Broom broom) {

        final Broom savedBroom = getBroomById(broom.getId());

        savedBroom.setPrice(broom.getPrice());
        savedBroom.setName(broom.getName());

        return savedBroom;
    }

    public void deleteBroomById(final Long id) {
        brooms = brooms.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
