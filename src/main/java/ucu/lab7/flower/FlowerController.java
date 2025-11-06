package ucu.lab7.flower;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/flower")
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    // GET /flower/ — return all flowers
    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getAllFlowers();
    }

    // POST /flower/ — add new flower
    @PostMapping
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.addFlower(flower);
    }
}
