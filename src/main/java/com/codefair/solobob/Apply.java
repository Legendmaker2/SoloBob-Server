package com.codefair.solobob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(name = "schedule_id", columnDefinition = "bigint", nullable = false)
    private Long scheduleId;

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Builder
    public Apply(Long userId, Long scheduleId, String status) {
        this.userId = userId;
        this.scheduleId = scheduleId;
        this.status = status;
    }
}
