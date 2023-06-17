package edu.projectp.repositories.grade;

import edu.projectp.models.entities.Grade;
import edu.projectp.models.entities.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
    @Query("SELECT g FROM Grade g WHERE g.student.id = :studentId AND g.course.id = :courseId")
    Optional<Grade> findByStudentIdAndCourseId(Integer studentId, Integer courseId);

    @Modifying
    @Query("UPDATE Grade g SET g.total = :total WHERE g.student.id = :studentId AND g.course.id = :courseId")
    void updateTotalByStudentIdAndCourseId(Integer studentId, Integer courseId, Integer total);

    @Modifying
    @Query("DELETE Grade g WHERE g.student.id = :studentId AND g.course.id = :courseId")
    void deleteByStudentIdAndCourseId(Integer studentId, Integer courseId);
}
