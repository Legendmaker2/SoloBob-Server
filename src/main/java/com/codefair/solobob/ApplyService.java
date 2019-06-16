package com.codefair.solobob;

import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ApplyService {

    private final ApplyRepository applyRepository;

    public String applySchedule(Long userId, Long scheduleId) {
        Apply apply = Apply.builder()
                .userId(userId)
                .scheduleId(scheduleId)
                .status("Apply").build();
        apply = applyRepository.save(apply);
        return "{}";
    }

    public String decideApply(Long scheduleId, Long applyId, String status) {
        Apply apply = applyRepository.findById(applyId).orElseThrow();
        LoggerFactory.getLogger(getClass()).info(status + " " + apply.getStatus());
        apply.setStatus(status);
        applyRepository.save(apply);
        return "{}";
    }
}
