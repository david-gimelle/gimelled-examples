package com.gimelled.examples.java9.app;

import com.gimelled.examples.java9.app.domain.Catalogue;
import com.gimelled.examples.java9.app.domain.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CatalogueTest {


    private Catalogue catalogue;

    @Before
    public void setup() {
        this.catalogue = new Catalogue();
    }

    @Test
    public void testToRefactor() {
        Assert.assertTrue(true);
    }

    @Test
    public void testIfEmpty() {
        Assert.assertTrue(catalogue.isEmpty());
    }

    @Test
    public void testCatalogueNotEmptyWhenAddingDocument() {
        Document document = new Document();
        catalogue.addDocument(document);

        Assert.assertTrue(!catalogue.isEmpty());
    }

    @Test
    public void testCatalogueReturnsListOrderByAuthor() {
        Document doc1 = new Document();
        doc1.setAuthor("aaaaa");

        Document doc2 = new Document();
        doc2.setAuthor("bbbbb");

        Document doc3 = new Document();
        doc3.setAuthor("cccccc");

        catalogue.addDocument(doc1);
        catalogue.addDocument(doc3);
        catalogue.addDocument(doc2);

        List<Document> sortedDocuments = catalogue.getDocumentsByAuthor();

        Assert.assertEquals("aaaaa", sortedDocuments.get(0).getAuthor());
        Assert.assertEquals("bbbbb", sortedDocuments.get(1).getAuthor());
        Assert.assertEquals("cccccc", sortedDocuments.get(2).getAuthor());

    }

    @Test
    public void testCatalogueReturnsListOrderByYear() {
        Document doc1 = new Document();
        doc1.setYear(2010);

        Document doc2 = new Document();
        doc2.setYear(2008);

        Document doc3 = new Document();
        doc3.setYear(2015);

        catalogue.addDocument(doc1);
        catalogue.addDocument(doc3);
        catalogue.addDocument(doc2);

        List<Document> sortedDocuments = catalogue.getDocumentByYear();

        Assert.assertEquals(2008, sortedDocuments.get(0).getYear());
        Assert.assertEquals(2010, sortedDocuments.get(1).getYear());
        Assert.assertEquals(2015, sortedDocuments.get(2).getYear());

    }

    @Test
    public void testCatalogueReturnsListOrderByYearAndAuthor() {
        Document doc1 = new Document();
        doc1.setYear(2010);
        doc1.setAuthor("aaaa");


        Document doc2 = new Document();
        doc2.setYear(2010);
        doc2.setAuthor("bbbbb");

        Document doc3 = new Document();
        doc3.setYear(2011);
        doc3.setAuthor("b");

        Document doc4 = new Document();
        doc4.setYear(2011);
        doc4.setAuthor("a");



        catalogue.addDocument(doc2);
        catalogue.addDocument(doc1);
        catalogue.addDocument(doc3);
        catalogue.addDocument(doc4);

        List<Document> sortedDocuments = catalogue.getDocumentByYearAndAuthor();

        Assert.assertEquals(2010, sortedDocuments.get(0).getYear());
        Assert.assertEquals("aaaa", sortedDocuments.get(0).getAuthor());

        Assert.assertEquals(2010, sortedDocuments.get(1).getYear());
        Assert.assertEquals("bbbbb", sortedDocuments.get(1).getAuthor());

        Assert.assertEquals(2011, sortedDocuments.get(2).getYear());
        Assert.assertEquals("a", sortedDocuments.get(2).getAuthor());

        Assert.assertEquals(2011, sortedDocuments.get(3).getYear());
        Assert.assertEquals("b", sortedDocuments.get(3).getAuthor());

    }


}
