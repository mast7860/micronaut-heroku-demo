CREATE TABLE students (
    id   SERIAL PRIMARY KEY,
   name  VARCHAR(255) NOT NULL
);

CREATE TABLE scores(
    id INT NOT NULL,
    subject VARCHAR(10) NOT NULL,
    score INT NOT NULL,
    CONSTRAINT fk_student_id
            FOREIGN KEY (id)
                REFERENCES students (id)
);

CREATE TABLE grades(
    id INT NOT NULL,
    grade VARCHAR(1) NOT NULL,
    total INT NOT NULL,
    CONSTRAINT fk_student_id
            FOREIGN KEY (id)
                REFERENCES students (id)
);
