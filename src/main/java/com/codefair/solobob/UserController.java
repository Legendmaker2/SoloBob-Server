package com.codefair.solobob;

import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final ScheduleService scheduleService;
    private final ApplyService applyService;

    @PostMapping
    public UserInfoTO registerUser(@RequestBody RegisterUserTO registerUserTO) {
        return userService.registerUser(registerUserTO);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<UserInfoTO> login(@RequestBody LoginTO loginTO) {
        UserInfoTO userInfoTO = userService.login(loginTO);
        ResponseEntity<UserInfoTO> responseEntity;
        if (userInfoTO != null) {
            responseEntity = new ResponseEntity<>(userInfoTO, HttpStatus.OK);
        } else {
            responseEntity = new ResponseEntity<>(new UserInfoTO(0L, ""), HttpStatus.UNAUTHORIZED);
        }
        return responseEntity;
    }

    @PostMapping(value = "/{id}/schedules")
    public ScheduleInfoTO makeSchedule(@PathVariable Long id, @RequestBody MakeScheduleTO makeScheduleTO) {
        return scheduleService.makeSchedule(id, makeScheduleTO);
    }

    @PostMapping(value = "/{id}/schedules/{scheduleId}")
    public String applySchedule(@PathVariable Long id, @PathVariable Long scheduleId) {
        return applyService.applySchedule(id, scheduleId);
    }

    @GetMapping
    public String test() {
        LoggerFactory.getLogger(getClass()).info("test!!!!!!");
        return "{}";
    }
}
