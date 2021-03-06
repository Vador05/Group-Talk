package edu.upc.eetac.dsa.group.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenshin on 29/10/15.
 */
public class GroupCollection {
    @InjectLinks({})
    private List<Link> links;
    private long newestTimestamp;
    private long oldestTimestamp;
    private List<Group> groups = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public long getNewestTimestamp() {
        return newestTimestamp;
    }

    public void setNewestTimestamp(long newestTimestamp) {
        this.newestTimestamp = newestTimestamp;
    }

    public long getOldestTimestamp() {
        return oldestTimestamp;
    }

    public void setOldestTimestamp(long oldestTimestamp) {
        this.oldestTimestamp = oldestTimestamp;
    }

    public List<Group> getgroups() {
        return groups;
    }

    public void setgroups(List<Group> groups) {
        this.groups = groups;
    }
}


