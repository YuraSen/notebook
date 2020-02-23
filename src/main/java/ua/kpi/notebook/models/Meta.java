package ua.kpi.notebook.models;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Meta {

    private LocalDateTime createTimeStamp;
    private LocalDateTime updateTimeStamp;

    public void setUpdateTimeStamp() {
        updateTimeStamp = LocalDateTime.now();
        setCreateTimeStamp();
    }

    private void setCreateTimeStamp() {
        boolean isNowCreated = null == createTimeStamp;
        if (isNowCreated) createTimeStamp = updateTimeStamp;
    }

    @Override
    public String toString() {
        String delimiter = "\n\t\t";
        return new StringJoiner(delimiter, delimiter + Meta.class.getSimpleName() + delimiter + "[", "]")
                .add("createTimeStamp=" + createTimeStamp)
                .add("updateTimeStamp=" + updateTimeStamp)
                .toString();
    }
}
