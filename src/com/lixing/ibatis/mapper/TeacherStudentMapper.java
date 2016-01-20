package com.lixing.ibatis.mapper;

import java.util.List;

import com.lixing.ibatis.entity.Student;
import com.lixing.ibatis.entity.Teacher;
import com.lixing.ibatis.entity.TeacherStudent;

public interface TeacherStudentMapper {
	void insertTeacherStudent(TeacherStudent teacherStudent);
	List<Student> getStudentForTeacherId(int id);
	List<Teacher> getTeacherForStudentId(int id);
}
