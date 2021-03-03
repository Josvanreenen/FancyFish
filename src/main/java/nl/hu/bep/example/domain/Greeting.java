package nl.hu.bep.example.domain;


import java.util.Objects;

public class Greeting {

    private String content;

    public Greeting(String c){
        content = c;
    }


    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Greeting greeting = (Greeting) o;
        return content.equals(greeting.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }

    public Greeting(){
        content="Hello World";
    }

}
