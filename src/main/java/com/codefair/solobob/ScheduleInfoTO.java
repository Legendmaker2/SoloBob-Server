package com.codefair.solobob;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ScheduleInfoTO {

    private Long id;
    private Long userId;
    private String restaurant;
    private Integer number;
    private String explanation;

    public ScheduleInfoTO(Schedule schedule) {
        this.id = schedule.getId();
        this.userId = schedule.getUserId();
        this.restaurant = schedule.getRestaurant();
        this.number = schedule.getNumber();
        this.explanation = schedule.getExplanation();
    }
}
