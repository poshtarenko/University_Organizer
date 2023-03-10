package com.nyanband.university_organizer.dto;

import com.nyanband.university_organizer.entity.enums.ELessonType;
import com.nyanband.university_organizer.entity.enums.EWeakType;
import com.nyanband.university_organizer.entity.enums.EWeekday;
import lombok.Value;

@Value
public class ScheduleItemDto {
    Long id;
    Integer lessonNum;
    Long scheduleId;
    Long disciplineId;
    ELessonType lessonType;
    EWeakType weakType;
    EWeekday weekday;

}
