package com.app.simon.annotationdemo.model;

/**
 * desc: AnTest
 * date: 2017/8/4
 *
 * @author xw
 */
public class AnTest {
    private int id;
    private String name;
    private String phone;

    public AnTest() {

    }

    private AnTest(int id) {
        this.id = id;
    }

    private AnTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    private String addString(String addString) {
        return "AnTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}' + addString;
    }

    private String addString2(String addString1, String addString2) {
        return "AnTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                '}' + addString1 + addString2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
