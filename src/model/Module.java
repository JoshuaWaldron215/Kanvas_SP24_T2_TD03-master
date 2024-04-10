package model;

import model.modulecontent.IContent;

import java.util.ArrayList;
import java.util.List;

public class Module {
    boolean isPublished = false;
    List<IContent> contents = new ArrayList<>();
    private String title;

    public Module(String title) {
        this.title = title;
    }

    public void addContent(IContent content) {
        contents.add(content);
    }
}