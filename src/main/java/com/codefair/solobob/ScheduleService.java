package com.codefair.solobob;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ApplyRepository applyRepository;

    public ScheduleInfoTO makeSchedule(Long userId, MakeScheduleTO makeScheduleTO) {
        Schedule schedule = Schedule.builder()
                .userId(userId)
                .restaurant(makeScheduleTO.getRestaurant())
                .number(makeScheduleTO.getNumber())
                .explanation(makeScheduleTO.getExplanation()).build();
        schedule = scheduleRepository.save(schedule);
        return new ScheduleInfoTO(schedule);
    }

    @Transactional
    public List<ScheduleListTO> getScheduleList() {
        List<ScheduleListTO> scheduleListTOList = new ArrayList<>();
        List<Schedule> scheduleList = scheduleRepository.findAllByOrderByIdDesc();
        for (Schedule schedule : scheduleList) {
            ScheduleInfoTO scheduleInfoTO = new ScheduleInfoTO(schedule);
            List<Apply> applyList = applyRepository.findAllByScheduleIdOrderByIdDesc(schedule.getId());
            List<ApplyInfoTO> applyInfoTOList = applyList.stream().map(ApplyInfoTO::new).collect(Collectors.toList());
            scheduleListTOList.add(new ScheduleListTO(scheduleInfoTO, applyInfoTOList));
        }
        return scheduleListTOList;
    }
}
