package lpnu.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import lpnu.entity.Sauna;
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
public class SaunaRepository {
    private List<Sauna> saunaList;

    private long id = 1;


    @PostConstruct
    public void init(){

        final Path file = Paths.get("saunas.txt");
        try {
            final String savedSaunasAsString = Files.readString(file, StandardCharsets.UTF_16);
            saunaList = JacksonUtil.deserialize(savedSaunasAsString, new TypeReference<List<Sauna>>() {});

            if (saunaList == null) {
                saunaList = new ArrayList<>();
                return;
            }

            final long maxId = saunaList.stream().mapToLong(Sauna::getId).max().orElse(1);

            this.id = maxId + 1;

        } catch (final Exception e){
            System.out.println("We have an issue");
            saunaList = new ArrayList<>();
        }

    }

    @PreDestroy
    public void preDestroy(){
        final Path file = Paths.get("saunas.txt");
        try {
            Files.writeString(file, JacksonUtil.serialize(saunaList), StandardCharsets.UTF_16);
        } catch (final Exception e){
            System.out.println("We have an issue");
        }
    }
    public List<Sauna> getAllSaunas() {
        return new ArrayList<>(saunaList);
    }

    public Sauna getSaunaById(final Long id) {
        return saunaList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "sauna with id {" + id + "} not found"));
    }

    public Sauna getSaunaByName(final String name) {
        return saunaList.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "sauna with name {" + name + "} not found"));
    }

    public Sauna saveSauna(final Sauna sauna) {
        sauna.setId(id);

        ++id;

        saunaList.add(sauna);
        return sauna;
    }

    public Sauna updateSauna(final Sauna sauna) {

        final Sauna savedSauna = getSaunaById(sauna.getId());

        savedSauna.setName(sauna.getName());
        savedSauna.setPricePerHourSell(sauna.getPricePerHourSell());
        savedSauna.setSaunaType(sauna.getSaunaType());

        return savedSauna;
    }

    public void deleteSaunaById(final Long id) {
        saunaList = saunaList.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());
    }
}
