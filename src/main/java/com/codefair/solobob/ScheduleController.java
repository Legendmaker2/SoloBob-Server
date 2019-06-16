package com.codefair.solobob;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ApplyService applyService;

    @GetMapping
    public List<ScheduleListTO> getScheduleList() {
        return scheduleService.getScheduleList();
    }

    @PutMapping(value = "/{id}/applies/{applyId}")
    public String decideApply(@PathVariable Long id, @PathVariable Long applyId, @RequestBody DecideApplyTO decideApplyTO) {
        return applyService.decideApply(id, applyId, decideApplyTO.getStatus());
    }
}
