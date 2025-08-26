package org.hostpital.persistence.components;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Problem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;
    private String statement;
    private String algorithm;
    @ElementCollection
    @CollectionTable(name="Problem_languages",joinColumns = @JoinColumn(name="statement_id"))
    private List<String> languages = new ArrayList<>();

    public Problem() {
    }

    public Problem(String statement, String algorithm, List<String> languages) {
        this.statement = statement;
        this.algorithm = algorithm;
        this.languages = languages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
