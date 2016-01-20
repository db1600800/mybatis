package com.lixing.ibatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lixing.ibatis.entity.Student;
import com.lixing.ibatis.entity.Teacher;
import com.lixing.ibatis.entity.TeacherStudent;
import com.lixing.ibatis.mapper.StudentMapper;
import com.lixing.ibatis.mapper.TeacherMapper;
import com.lixing.ibatis.mapper.TeacherStudentMapper;
import com.lixing.ibatis.util.MyBatisUtil;


public class AllTest {
	SqlSessionFactory sqlSessionFactory=null;
	SqlSession session=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AllTest allTest=new AllTest();
		allTest.before();
		allTest.testAddStudent();
		allTest.testAddTeacher();
		allTest.testAddTeacherAndStudent();
		allTest.testGetTeacherAndStudent();
		allTest.testGetStudentAndTeacher();
		
	}
	
	@Before
	public void before(){
		sqlSessionFactory=MyBatisUtil.getInstance();
		session=sqlSessionFactory.openSession();
	}
	
	Student student;
	Teacher teacher;
	@Test
	public void testAddStudent(){
		 student=new Student();
		student.setName("李翠姣");
		student.setAge(25);
		student.setSex("男");
		
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		studentMapper.insertStudent(student);
		session.commit();
		System.out.println(student.getId());
	}
	
	@Test
	public void testAddTeacher(){
		 teacher=new Teacher();
		teacher.setName("尼玛");
		teacher.setSex("女");
		teacher.setAge(30);
		TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
		teacherMapper.insertTeacher(teacher);
		session.commit();
		System.out.println(teacher.getId());
	}

	@Test
	public void testAddTeacherAndStudent(){
		TeacherStudent teacherStudent=new TeacherStudent();
		teacherStudent.setStudentId(student.getId());
		teacherStudent.setTeacherId(teacher.getId());
		
		TeacherStudentMapper teacherStudentMapper=session.getMapper(TeacherStudentMapper.class);
		teacherStudentMapper.insertTeacherStudent(teacherStudent);		
		
		session.commit();
	}
	
	@Test
	public void testGetTeacherAndStudent(){
		TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
		Teacher teacher=teacherMapper.getTeacher(13);
		List<Student> list=teacher.getStudentList();
		System.out.println(teacher.getId()+"\t"+teacher.getName()+"\t");
		for(Student student:list){
			System.out.println("\t \t --:"+student.getId()+"\t"+student.getName()+"\t"+student.getSex());
		}
		session.commit();
	}
	
	@Test
	public void testGetStudentAndTeacher(){
		StudentMapper studentMapper=session.getMapper(StudentMapper.class);
		Student student=studentMapper.getStudent(14);
		List<Teacher> list=student.getTeacherList();
		System.out.println(student.getId()+"\t"+student.getName()+"\t"+student.getSex());
		for(Teacher s:list){
			System.out.println("\t \t --:"+s.getId()+"\t"+s.getName()+"\t"+s.getSex()+"\t"+s.getAge());
		}
		session.commit();
	}
	
	@After
	public void after(){
		session.close();
	}
}
