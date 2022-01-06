package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	List<Course> list;
	
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(145, "java Core Course", "this is awesome "));
		list.add(new Course(143, "spring boot Course", "this is splendid "));
	}
	
	
	

	/*
	 * @Override public List<Course> getCourse(long courseId) { return list; }
	 */
	
	
	  @Override 
	  public List<Course> getCourses() {
		  return list;
	  
	 
	  }
	 




	@Override
	public Course getCourse(long courseId) {
		 Course c=null;
		  for(Course course:list) 
		  { 
			  if(course.getId()==courseId)
		  {
		  c=course; break;
		  }
		  } 
		  return c;
		
	}




	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}




	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public Course deleteCourse(long courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
