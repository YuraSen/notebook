package ua.kpi.notebook.models;

import java.util.StringJoiner;

public class Identity {

    private Name name;
    private String nickname;
    private String comment;
    private Group group;

    public Identity() {
        name = new Name();
        group = new Group();
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(String group) {
        this.group.setName(group);
    }

    public void setIdentityData(
            String firstName,
            String lastName,
            String patronymic,
            String nickname,
            String comment,
            String group
    ) {
        setNickname(nickname);
        setComment(comment);
        setGroup(group);
        name.setNameData(
                firstName,
                lastName,
                patronymic
        );
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t";
        return new StringJoiner(delimiter, delimiter + Identity.class.getSimpleName() + delimiter + "[", "]")
                .add("name=" + name)
                .add("nickname='" + nickname + "'")
                .add("comment='" + comment + "'")
                .add("group='" + group + "'")
                .toString();
    }
}
