package com.nyanband.university_organizer.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "num"}))
public class Course extends BaseEntity {
    @Column(name = "num")
    Integer number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(mappedBy = "course")
    List<Semester> semesters;

    public Course(Long id) {
        super(id);
    }
}
