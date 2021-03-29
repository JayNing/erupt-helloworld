package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.proxy.StudentDataProxy;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.BoolType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.jpa.model.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 * ClassName: Student
 * Description:
 * date: 2021/3/29 11:27
 *
 * @author ningjianjian
 */
/*
 *  @Erupt注解修饰在类上，@EruptField注解修饰在字段上
 *  其他注解均为Jpa注解
 */
@Getter
@Setter
@Erupt(name = "学生表", dataProxy = {StudentDataProxy.class},
        power = @Power(importable = true, export = true)
)
@Entity
public class Student extends BaseModel {

    @EruptField(
            views = @View(title = "学生姓名"),
            edit = @Edit(title = "学生姓名", notNull = true, search = @Search(vague = true))
    )
    private String studentName;

    @EruptField(
            views = @View(title = "所属班级"),
            edit = @Edit(title = "所属班级", notNull = true)
    )
    private String studentClass;

    @EruptField(
            views = @View(title = "学生年龄"),
            edit = @Edit(title = "学生年龄", notNull = true)
    )
    private String studentAge;

    @Lob
    @EruptField(
            views = @View(title = "学生性别"),
            edit = @Edit(title = "学生性别", notNull = true)
    )
    private String studentSex;

    @EruptField(
            views = @View(title = "考核状态"),
            edit = @Edit(title = "考核状态", notNull = true, boolType = @BoolType(trueText = "通过", falseText = "挂科"), search = @Search)
    )
    private Boolean status;
}