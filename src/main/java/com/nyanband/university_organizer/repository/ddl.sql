CREATE TABLE Users
(
    id       BIGSERIAL PRIMARY KEY,
    email    varchar(128),
    password varchar(128)
);

CREATE TABLE Course
(
    id      BIGSERIAL PRIMARY KEY,
    num     int,
    user_id INTEGER REFERENCES Users ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Semester
(
    id        BIGSERIAL PRIMARY KEY,
    num       int,
    course_id INTEGER REFERENCES Course ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Discipline
(
    id              BIGSERIAL PRIMARY KEY,
    discipline_name varchar(128),
    semester_id     INTEGER REFERENCES Semester ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Folder
(
    id            BIGSERIAL PRIMARY KEY,
    folder_name   varchar(128),
    discipline_id INTEGER REFERENCES Discipline ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE File
(
    id          BIGSERIAL PRIMARY KEY,
    file_name   varchar(128),
    file_path   varchar(128),
    upload_time timestamp,
    folder_id   INTEGER REFERENCES Folder ON DELETE CASCADE ON UPDATE CASCADE
);
