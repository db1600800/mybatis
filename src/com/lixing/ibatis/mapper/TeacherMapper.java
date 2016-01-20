package com.lixing.ibatis.mapper;

import com.lixing.ibatis.entity.Teacher;

public interface TeacherMapper {
	void insertTeacher(Teacher teacher);
	Teacher getTeacher(int teacherId);
}
