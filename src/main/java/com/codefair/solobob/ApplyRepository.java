package com.codefair.solobob;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyRepository extends JpaRepository<Apply, Long> {

    List<Apply> findAllByScheduleIdOrderByIdDesc(Long id);
}
