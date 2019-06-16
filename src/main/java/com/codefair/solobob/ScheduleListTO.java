package com.codefair.solobob;

import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleListTO {

    private ScheduleInfoTO scheduleInfoTO;
    private List<ApplyInfoTO> applyInfoTOList;

    public ScheduleListTO(ScheduleInfoTO scheduleInfoTO, List<ApplyInfoTO> applyInfoTOList) {
        this.scheduleInfoTO = scheduleInfoTO;
        this.applyInfoTOList = applyInfoTOList;
    }
}
