package com.codefair.solobob;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApplyInfoTO {

    private Long id;
    private Long userId;
    private String userName;
    private Long scheduleId;
    private String status;

    public ApplyInfoTO(Apply apply) {
        this.id = apply.getId();
        this.userId = apply.getUserId();
        this.userName = apply.getUser().getName();
        this.scheduleId = apply.getScheduleId();
        this.status = apply.getStatus();
    }
}
