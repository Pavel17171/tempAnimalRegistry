package org.example.Model.StructureZoo;

import java.util.ArrayList;
import java.util.List;

public class SubArrayAnimal {
    private String id;
    private String nickname;
    private String command;
    private String birthday;

    public SubArrayAnimal(String id, String nickname, String command, String birthday) {
        this.id = id;
        this.nickname = nickname;
        this.command = command;
        this.birthday = birthday;
    }

    public SubArrayAnimal() {}
    public String getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "id: " + id +
               ". Nickname: " + nickname +
               ". Birthday: " + birthday +
               ". Commands: " + command;
    }
}
