package edu.upc.eetac.dsa.group.entity;

/**
 * Created by kenshin on 29/10/15.
 */
public class GroupError {
    private int status;
    private String reason;

    public GroupError() {
    }

    public GroupError(int status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
