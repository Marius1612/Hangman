package model;

import javax.xml.bind.annotation.XmlElement;

public class Player {
    private String name;
    private String password;

    public Player(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    private Player() {
        //needed for unmarshall
    }

    public String getPassword() {
        return password;
    }
}