package com.gimelled.examples.java9.app.domain;

import java.util.ArrayList;
import java.util.List;

public class Catalogue {

    private List<Document> documents;

    public Catalogue() {
        this.documents = new ArrayList<Document>();
    }

    public boolean isEmpty() {
        return documents.isEmpty();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public List<Document> getDocumentsByAuthor() {
        List<Document> sortedDocuments = new ArrayList<>();

        for(Document d : documents) {
            sortedDocuments.add(d);
        }

        sortedDocuments.sort(
                (d1, d2) -> d1.getAuthor().compareTo(d2.getAuthor()));
        return sortedDocuments;
    }

    public List<Document> getDocumentByYear() {
        documents.sort(
                (d1, d2) -> d1.getYear() - d2.getYear());
        return documents;
    }

    public List<Document> getDocumentByYearAndAuthor() {
        documents.sort(
                (d1, d2) -> {
                        if (d1.getYear() - d2.getYear() != 0)
                            return d1.getYear() - d2.getYear();
                        else return d1.getAuthor().compareTo(d2.getAuthor());
        });
        return documents;
    }

}