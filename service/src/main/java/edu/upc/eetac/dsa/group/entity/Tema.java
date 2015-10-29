package edu.upc.eetac.dsa.group.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.List;

/**
 * Created by kenshin on 29/10/15.
 */
public class Tema {
    @InjectLinks({})
    private List<Link> links;
    private String id;
    private String Groupid;
    private String creator;
    private String subject;
    private String content;


    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGroupid() {
        return Groupid;
    }

    public void setGroupid(String groupid) {
        Groupid = groupid;
    }
}

