package edu.upc.eetac.dsa.group.entity;

import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenshin on 29/10/15.
 */
public class TemaCollection {
    @InjectLinks({})
    private List<Link> links;
    private long newestTimestamp;
    private long oldestTimestamp;
    private List<Tema> temas = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Tema> gettemas() {
        return temas;
    }

    public void settemas(List<Tema> temas) {
        this.temas = temas;
    }
}


