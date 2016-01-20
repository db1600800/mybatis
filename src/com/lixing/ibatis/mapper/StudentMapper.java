package com.lixing.ibatis.mapper;

import com.lixing.ibatis.entity.Student;

public interface StudentMapper {
	void insertStudent(Student student);
	Student getStudent(int studentId);
}
