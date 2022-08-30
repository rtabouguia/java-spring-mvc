/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.*;

/**
 *
 * @author RAISA
 */
public class StudentForm {
    
    @Min(value=0, message="Entrez un age valide")
    @Max(value=200, message="Entrez un age valide")
    @NotNull(message="the field age is mandatory")
    private Integer age;
    
      @NotBlank(message = "The field name is mandatory")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
