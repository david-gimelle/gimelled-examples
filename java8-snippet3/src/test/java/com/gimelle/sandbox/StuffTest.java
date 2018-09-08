package com.gimelle.sandbox;

import com.gimelle.sandbox.catalogue.domain.Catalogue;
import com.gimelle.sandbox.catalogue.domain.Document;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class StuffTest {

    @Test
    public void testString(){
        String toto1 = "toto";
        String toto2 = "toto";
        String toto3 = new String("toto");

        System.out.println("toto1 == toto2"+ (toto1 == toto2));
        System.out.println("toto2 == toto3"+ (toto2 == toto3));
    }


    @Test
    public void testStream(){
        Document doc1 = new Document("b1","John",1975);
        Document doc2 = new Document("b2","Jane",1970);
        Document doc3 = new Document("b3","Zoe",1975);
        Document doc4 = new Document("b4","Alphonse",1949);

        Catalogue c1 = new Catalogue();
        c1.addDocument(doc1);
        c1.addDocument(doc2);
        c1.addDocument(doc3);
        c1.addDocument(doc4);

        List<Document> documents = c1.getDocumentByYear();

        Assert.assertTrue(documents.get(0).getYear() == 1949);

        documents.sort( (d1,d2) -> d1.getTitle().compareTo(d2.getTitle()));

        Assert.assertTrue(documents.get(0).getTitle().equals("b1"));

        documents.stream().sorted((d1,d2) -> d1.getTitle().compareTo(d2.getTitle()));

        Assert.assertTrue(documents.get(0).getTitle().equals("b1"));

        Assert.assertTrue(
        documents.stream().filter(e -> e.getYear() == 1975).collect(Collectors.toList()).size() == 2);

        Assert.assertTrue(
        documents.stream().map(e -> e.getTitle()).collect(Collectors.toList()).get(0).equals("b1"));

        Assert.assertTrue(
                documents.stream().map(Document::getTitle).collect(Collectors.toList()).get(0).equals("b1"));

    }


}
