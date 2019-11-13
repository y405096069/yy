package com.nfdw.entity;/**
 * @author caisheng
 * @create 2019-11-13 11:12
 */

import javax.persistence.Table;
import java.util.List;

/**
 * @author caisheng
 * @create 2019-11-13 11:12
 */
@Table(name = "studentManage")
public class StudentUser {

    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentUser{" +
                "students=" + students +
                '}';
    }
}
