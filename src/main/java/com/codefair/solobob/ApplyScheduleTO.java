package com.codefair.solobob;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ApplyScheduleTO {

    private Long userId;
    private Long scheduleId;
    private String status;
}
