package com.codefair.solobob;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", columnDefinition = "bigint", nullable = false)
    private Long userId;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String restaurant;

    @Column(columnDefinition = "int", nullable = false)
    private Integer number;

    @Column(columnDefinition = "varchar(200)", nullable = false)
    private String explanation;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private User user;

    @Builder
    public Schedule(Long userId, String restaurant, Integer number, String explanation) {
        this.userId = userId;
        this.restaurant = restaurant;
        this.number = number;
        this.explanation = explanation;
    }
}
