CREATE TABLE t_student(
  id int(3) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20),
  sex varchar(2),
  age int(3)
)DEFAULT CHARSET=utf8;

CREATE TABLE t_teacher(
  id int(3) PRIMARY KEY AUTO_INCREMENT,
  name varchar(20),
  sex varchar(2),
  age int(3)  
)DEFAULT CHARSET=utf8;

CREATE TABLE t_teacher_student(
  student_id int(3),
  teacher_id int(3),
  PRIMARY KEY(student_id ,teacher_id),
  CONSTRAINT student_fk FOREIGN KEY (student_id) REFERENCES t_student(id),
  CONSTRAINT teacher_fk FOREIGN KEY (teacher_id) REFERENCES t_teacher(id)
)DEFAULT CHARSET=utf8;