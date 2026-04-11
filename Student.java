/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.app;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String gender;
    private List<String> languages;

    public Student(String id, String name, String gender, List<String> languages) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.languages = languages;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public List<String> getLanguages() { return languages; }

    public void setName(String name) { this.name = name; }
    public void setGender(String gender) { this.gender = gender; }
    public void setLanguages(List<String> languages) { this.languages = languages; }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}