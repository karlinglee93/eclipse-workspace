package com.karlinglee93.jdbc_tst.test;

import com.karlinglee93.jdbc_tst.dao.StudentDao;
import com.karlinglee93.jdbc_tst.po.Student;

public class StudentTest {
	public static void main(String args[]) {
//	    StudentDao.getAll();
//	    StudentDao.insert(new Student("Achilles", "Male", 14));
	    StudentDao.getAll();
	    StudentDao.update(new Student("Bean", "", 7));
	    StudentDao.getAll();
//	    StudentDao.delete("Achilles");
//	    StudentDao.getAll();
	}
}