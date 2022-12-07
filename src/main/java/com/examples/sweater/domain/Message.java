package com.examples.sweater.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Plese fill the message")
    @Length(max = 2048, message = "Message too long(more than 2kB)")
    private String text;
    @Length(max = 255, message = "Tag too long(more than 2kB)")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Message(String text, String tag, User user ){
        this.tag = tag;
        this.text = text;
        this.author = user;
    }
    public String getAuthorName(){
        return author != null ? author.getUsername() : "<none>";
    }
    public Message(){

    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }

    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }

    public void setTag(String tag){
        this.tag = tag;
    }
    public String getTag(){
        return tag;
    }
}
