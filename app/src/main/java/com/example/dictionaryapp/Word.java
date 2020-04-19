package com.example.dictionaryapp;

import java.util.ArrayList;

public class Word {

    public Word() {
        this.word=null;
        this.definitions=null;
        this.synonyms=null;
        this.antonyms=null;
    }

    public Word(String word, ArrayList<String> definitions, ArrayList<String> synonyms, ArrayList<String> antonyms) {
        this.word = word;
        this.definitions = definitions;
        this.antonyms = antonyms;
    }

    private String word;
    private ArrayList<String> definitions;
    private ArrayList<String> synonyms;
    private ArrayList<String> antonyms;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(ArrayList<String> definitions) {
        this.definitions = definitions;
    }

    public ArrayList<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<String> synonyms) {
        this.synonyms = synonyms;
    }

    public ArrayList<String> getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(ArrayList<String> antonyms) {
        this.antonyms = antonyms;
    }
}
