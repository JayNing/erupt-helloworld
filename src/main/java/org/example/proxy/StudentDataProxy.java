package org.example.proxy;

import org.example.entity.Student;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.core.exception.EruptApiErrorTip;

/**
 * ClassName: StudentDataProxy
 * Description:
 * date: 2021/3/29 14:06
 *
 * @author ningjianjian
 */
public class StudentDataProxy implements DataProxy<Student> {

    @Override
    public void beforeAdd(Student student) {
        //后台字段校验
        if ("王五".equals(student.getStudentName())) {
            throw new EruptApiErrorTip("名称禁止为王五！");
        }
    }

    @Override
    public void afterAdd(Student student) {
        System.out.println("添加新学生" + student.getStudentName());
    }

    @Override
    public void beforeUpdate(Student student) {

    }

    @Override
    public void afterUpdate(Student student) {

    }

    @Override
    public void beforeDelete(Student student) {

    }

    @Override
    public void afterDelete(Student student) {
        System.out.println("删除新学生" + student.getStudentName());
    }
}
