package edu.eci.cvds.tdd.library.user;

import edu.eci.cvds.tdd.library.book.Book;

public class User {
    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return id.equals(((User)obj).id);
    }
}