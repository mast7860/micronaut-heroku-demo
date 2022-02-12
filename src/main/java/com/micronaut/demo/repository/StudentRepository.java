package com.micronaut.demo.repository;

import com.micronaut.demo.domain.StudentGrades;
import com.micronaut.demo.domain.Subject;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.jdbc.runtime.JdbcOperations;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.transaction.annotation.ReadOnly;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@JdbcRepository(dialect = Dialect.POSTGRES)
@Slf4j
public class StudentRepository {

    private final JdbcOperations jdbcOperations;

    public StudentRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Transactional
    @ReadOnly
    public StudentGrades getStudentGrades(int id) {

        var selectSql = """
                SELECT
                student.id AS id,
                student.name AS name,
                grade.grade AS grade,
                grade.total AS total

                FROM
                students student
                INNER JOIN grades AS grade ON student.id = grade.id

                WHERE
                student.id=?;
                """;

        return jdbcOperations.prepareStatement(selectSql, statement -> {
            statement.setInt(1, id);
            var resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return jdbcOperations.readEntity(resultSet, StudentGrades.class);
            } else {
                throw new RuntimeException("Not found");
            }
        });
    }

    @Transactional
    @ReadOnly
    public List<Subject> getSubjectScores(int id) {

        var selectSql = """
                SELECT
                student.id AS id,
                score.subject AS subject,
                score.score AS score

                FROM
                students student
                INNER JOIN scores AS score ON student.id = score.id
                                
                WHERE
                student.id=?;
                """;

        return jdbcOperations.prepareStatement(selectSql, statement -> {
            statement.setInt(1, id);
            var resultSet = statement.executeQuery();
            return jdbcOperations.entityStream(resultSet, Subject.class).collect(Collectors.toList());
        });
    }
}