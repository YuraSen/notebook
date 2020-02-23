package ua.kpi.notebook.models;

import ua.kpi.notebook.models.exception.DataUncorrectedRuntimeException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringJoiner;

public class Group {

    private final String DEFAULT_LANGUAGE = "en";
    private final Map<String, List<String>> translatedGroupNames;

    private GroupName name;

    enum GroupName {
        FRIENDS,
        RELATIVES,
        ACQUAINTANCES,
        COLLEAGUES
    }

    Group() {
        translatedGroupNames = new HashMap<>();
        translatedGroupNames.put("uk", createGroupsUK());
        translatedGroupNames.put("en", createGroupsEN());
    }

    private List<String> createGroupsUK() {
        List<String> groups = new ArrayList<>();
        groups.add("ДРУЗІ");
        groups.add("РОДИЧІ");
        groups.add("ЗНАЙОМІ");
        groups.add("КОЛЕГИ");
        return groups;
    }

    private List<String> createGroupsEN() {
        List<String> groups = new ArrayList<>();
        groups.add("FRIENDS");
        groups.add("RELATIVES");
        groups.add("ACQUAINTANCES");
        groups.add("COLLEAGUES");
        return groups;
    }

    public void setName(String name) {
        this.name = GroupName.valueOf(getTranslatedName(name));
    }

    private String getTranslatedName(String name) {
        int index = getIndexOfGroup(name);
        return translatedGroupNames.get(DEFAULT_LANGUAGE).get(index);
    }

    private int getIndexOfGroup(String name) {
        checkName(name);
        String language = Locale.getDefault().getLanguage();
        return translatedGroupNames.get(language).indexOf(name.toUpperCase());
    }

    private void checkName(String name) {
        if(name == null){
            throw new DataUncorrectedRuntimeException("Name can`t be null");
        }
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t\t";
        return new StringJoiner(delimiter, delimiter + Group.class.getSimpleName() + delimiter + "[", "]")
                .add("name=" + name)
                .toString();
    }
}
