/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.catalog;

import java.util.Collection;

class InMemoryCatalogTestMain {

    /*
     * One by one, complete each test method below, and then "activate" it by
     * uncommenting the call to that method in main().
     *
     * Once you see that the test method verifies the corresponding business method
     * works correctly, you can comment out that call in main() and proceed to the next one.
     */
    public static void main(String[] args) {
        testFindById();
        testFindByKeyword();
        testFindByCategory();
        testSize();
        testGetAll();
    }

    private static void testFindById() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        MusicItem found = catalog.findById(6L); // primitive long autoboxed into Long object
        System.out.println(found);

        // not found case
        MusicItem notFound = catalog.findById(101L);
        System.out.println(notFound);

    }

    private static void testFindByKeyword() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> keywordMatches = catalog.findByKeyword("much");
        dump(keywordMatches);

        InMemoryCatalog catalog1 = new InMemoryCatalog();
        Collection<MusicItem> noKeywordMatches = catalog.findByKeyword("hellloo");
        dump(keywordMatches);
    }

    private static void testFindByCategory() {
        InMemoryCatalog catalog = new InMemoryCatalog();

        Collection<MusicItem> popItems = catalog.findByCategory(MusicCategory.POP);
        dump(popItems);

        // no jazz
        Collection<MusicItem> jazzItems = catalog.findByCategory(MusicCategory.JAZZ);
        dump(jazzItems);
    }

    private static void testSize() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        int size = catalog.size();
        System.out.println(size);
    }

    private static void testGetAll() {
        InMemoryCatalog catalog = new InMemoryCatalog();
        Collection<MusicItem> all = catalog.getAll();
        dump(all);
    }

    private static void dump(Collection<MusicItem> items) {
        for (MusicItem item: items) {
            System.out.println(item);

        }
    }

    // extra tests for those methods

}