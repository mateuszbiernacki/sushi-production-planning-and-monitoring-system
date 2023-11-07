package info.biernacki.sushifactorywebserver.plan;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class PlanRecordController {

    @PostMapping("/plan-record")
    public ResponseEntity<PlanRecordID> createPlanRecord(@RequestBody final PlanRecord planRecord){
        PlanRecordID result = new PlanRecordID(UUID.randomUUID().toString());
        System.out.println(planRecord);
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @GetMapping("/plan-record")
    public List<PlanRecord> getAllPlanRecords() {
        List<PlanRecord> result = new ArrayList<>();
        result.add(new PlanRecord(
                "MAP 1",
                "ŻABKA",
                "NORIKO PL",
                6003,
                2023,
                10,
                30,
                3,
                14,
                2023,
                10,
                30,
                12,
                0
        ));

        return result;
    }

    @GetMapping("/plan-record/{id}")
    public PlanRecord getPlanRecordByID(@PathVariable final String id){
        return new PlanRecord(
                "MAP 1",
                "ŻABKA",
                "NORIKO PL",
                6003,
                2023,
                10,
                30,
                3,
                14,
                2023,
                10,
                30,
                12,
                0
        );
    }
}
