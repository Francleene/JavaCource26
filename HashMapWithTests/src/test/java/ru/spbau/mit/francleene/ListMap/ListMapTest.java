package ru.spbau.mit.francleene.ListMap;

import org.junit.Test;
import org.junit.Assert;

public class ListMapTest {
    @Test
    public void sizeEmptyListMap() {
        ListMap listMap = new ListMap();

        Assert.assertEquals(0, listMap.size());
    }

    @Test
    public void sizeAddOneElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "imvalue");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeAddFewDifferentElements() {
        ListMap listMap = new ListMap();

        for (int i = 0; i < 15; i++) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals(15, listMap.size());
    }

    @Test
    public void sizeAddSameElements() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.put("Whoami", "urkey");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeAddNullElement() {
        ListMap listMap = new ListMap();

        listMap.put(null, "urnull");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeRemoveOneExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");
        listMap.put("Whoami2", "urkey2");
        listMap.remove("Whoami1");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeRemoveFewExistedElements() {
        ListMap listMap = new ListMap();

        for (int i = 0; i < 34; i++) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        for (int i = 0; i < 34; i += 2) {
            listMap.remove("Whoami" + i);
        }

        Assert.assertEquals(17, listMap.size());
    }

    @Test
    public void sizeRemoveOneNonExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");
        listMap.put("Whoami2", "urkey2");
        listMap.remove("Whoami3");

        Assert.assertEquals(2, listMap.size());
    }

    @Test
    public void sizeRemoveFewNotExistedElements() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        for (int i = 0; i < 34; i += 2) {
            listMap.remove("Whoami" + i);
        }

        Assert.assertEquals(17, listMap.size());
    }

    @Test
    public void sizeClear() {
        ListMap listMap = new ListMap();

        for (int i = 0; i < 34; i++) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.clear();

        Assert.assertEquals(0, listMap.size());
    }

    @Test
    public void sizeContainsExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.contains("Whoami");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeContainsNotExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.contains("urkey");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeGetExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.get("Whoami");

        Assert.assertEquals(1, listMap.size());
    }

    @Test
    public void sizeGetNotExistedElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.get("urkey");

        Assert.assertEquals(1, listMap.size());
    }


    @Test
    public void containsEmptyList() {
        ListMap listMap = new ListMap();

        Assert.assertFalse(listMap.contains("Whoami"));
    }

    @Test
    public void containsOneElementContain() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");

        Assert.assertTrue(listMap.contains("Whoami"));
    }

    @Test
    public void containsOneElementDoNotContain() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey");

        Assert.assertFalse(listMap.contains("Whoami2"));
    }

    @Test
    public void containsFewElementsContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertTrue(listMap.contains("Whoami17"));
    }

    @Test
    public void containsFewElementsDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertFalse(listMap.contains("Whoami18"));
    }

    @Test
    public void containsNullElementContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 18; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put(null, "urnull");

        for (int i = 19; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertTrue(listMap.contains(null));
    }

    @Test
    public void containsNullElementDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertFalse(listMap.contains(null));
    }

    @Test
    public void containsDoublePut() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put("Whoami17", "urkey17");

        Assert.assertTrue(listMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterRemoveContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.remove("Whoami17");

        Assert.assertTrue(listMap.contains("Whoami15"));
    }

    @Test
    public void containsAfterRemoveDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.remove("Whoami17");

        Assert.assertFalse(listMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterClear() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.clear();

        Assert.assertFalse(listMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterGetExistedElement() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.get("Whoami17");

        Assert.assertTrue(listMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterGetNotExistedElement() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.get("Whoami18");

        Assert.assertFalse(listMap.contains("Whoami18"));
    }

    @Test
    public void getEmptyList() {
        ListMap listMap = new ListMap();

        Assert.assertEquals(null, listMap.get("Whoami"));
    }

    @Test
    public void getOneElementContain() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", listMap.get("Whoami"));
    }

    @Test
    public void getOneElementDoNotContain() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey");

        Assert.assertNull(listMap.get("Whoami2"));
    }

    @Test
    public void getFewElementsContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urkey17", listMap.get("Whoami17"));
    }

    @Test
    public void getFewElementsDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(listMap.get("Whoami18"));
    }

    @Test
    public void getNullKeyElementContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 18; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put(null, "urnull");

        for (int i = 19; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urnull", listMap.get(null));
    }

    @Test
    public void getNullKeyElementDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(listMap.get(null));
    }

    @Test
    public void getNullValueElement() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 18; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put("I'm the King 18", null);

        for (int i = 19; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(listMap.get("I'm the King 18"));
    }

    @Test
    public void getDoublePutSameValue() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put("Whoami17", "urkey17");

        Assert.assertEquals("urkey17", listMap.get("Whoami17"));
    }

    @Test
    public void getDoublePutDifferentValue() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.put("Whoami17", "U r the King 18");

        Assert.assertEquals("U r the King 18", listMap.get("Whoami17"));
    }

    @Test
    public void getAfterRemoveContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.remove("Whoami17");

        Assert.assertEquals("urkey15", listMap.get("Whoami15"));
    }

    @Test
    public void getAfterRemoveDoNotContain() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.remove("Whoami17");

        Assert.assertNull(listMap.get("Whoami17"));
    }

    @Test
    public void getAfterClear() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.clear();

        Assert.assertNull(listMap.get("Whoami17"));
    }

    @Test
    public void getAfterGetExistedElement() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.get("Whoami17");

        Assert.assertEquals("urkey17", listMap.get("Whoami17"));
    }

    @Test
    public void getAfterGetNotExistedElement() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 34; i += 2) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.get("Whoami18");

        Assert.assertNull(listMap.get("Whoami18"));
    }

    @Test
    public void putOneNotNullElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", listMap.get("Whoami"));
    }

    @Test
    public void putFewDifferentElements() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 17; i++) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urkey3", listMap.get("Whoami3"));
    }

    @Test
    public void putFewSameElements() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 17; i++) {
            listMap.put("Whoami", "urkey" + i);
        }

        Assert.assertEquals("urkey16", listMap.get("Whoami"));
    }

    @Test
    public void putElementNullKey() {
        ListMap listMap = new ListMap();

        listMap.put(null, "urnull");

        Assert.assertEquals("urnull", listMap.get(null));
    }

    @Test
    public void putFewElementsNullKey() {
        ListMap listMap = new ListMap();

        for (int i = 1; i < 17; i++) {
            listMap.put(null, "urnull" + i);
        }

        Assert.assertEquals("urnull16", listMap.get(null));
    }

    @Test
    public void putElementNullValue() {
        ListMap listMap = new ListMap();

        listMap.put("I'm the King", null);

        Assert.assertNull(null, listMap.get("I'm the King"));
    }

    @Test
    public void putReturnValueEmptyList() {
        ListMap listMap = new ListMap();

        Assert.assertNull(listMap.put("Whoami", "urkey"));
    }

    @Test
    public void putReturnValueDifferentKeys() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");

        Assert.assertNull(listMap.put("Whoami2", "urkey2"));
    }

    @Test
    public void putReturnValueSameKeys() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey1");

        Assert.assertEquals("urkey1", listMap.put("Whoami", "urkey2"));
    }

    @Test
    public void putReturnValueNullKey() {
        ListMap listMap = new ListMap();

        Assert.assertNull(listMap.put(null, "urnull"));
    }

    @Test
    public void putReturnValueNullValue() {
        ListMap listMap = new ListMap();

        Assert.assertNull(listMap.put("Whoami", null));
    }

    @Test
    public void putReturnValueDoubleNullKey() {
        ListMap listMap = new ListMap();

        listMap.put(null, "urnull1");

        Assert.assertEquals("urnull1", listMap.put(null, "urnull2"));
    }

    @Test
    public void putReturnValueDoubleNullValue() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", null);

        Assert.assertNull(listMap.put("Whoami", null));
    }

    @Test
    public void removeEmptyList() {
        ListMap listMap = new ListMap();

        listMap.remove("urkey");

        Assert.assertFalse(listMap.contains("Whoami"));
    }

    @Test
    public void removeOneElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.remove("Whoami");

        Assert.assertFalse(listMap.contains("Whoami"));
    }

    @Test
    public void removeAnotherElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");
        listMap.remove("Whoami2");

        Assert.assertTrue(listMap.contains("Whoami1"));
    }

    @Test
    public void removeNullKeyDoNotExist() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");
        listMap.remove(null);

        Assert.assertFalse(listMap.contains(null));
    }

    @Test
    public void removeNullKeyExist() {
        ListMap listMap = new ListMap();

        listMap.put(null, "urnull");
        listMap.remove(null);

        Assert.assertFalse(listMap.contains(null));
    }

    @Test
    public void removeReturnValueEmptyList() {
        ListMap listMap = new ListMap();

        Assert.assertNull(listMap.remove("Whoami"));
    }

    @Test
    public void removeReturnValueOneElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", listMap.remove("Whoami"));
    }

    @Test
    public void removeReturnValueAnotherElement() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");

        Assert.assertNull(listMap.remove("Whoami2"));
    }

    @Test
    public void removeReturnValueNullKeyDoNotExist() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami1", "urkey1");

        Assert.assertNull(listMap.remove(null));
    }

    @Test
    public void removeReturnValueNullKeyExist() {
        ListMap listMap = new ListMap();

        listMap.put(null, "urnull");

        Assert.assertEquals("urnull", listMap.remove(null));
    }

    @Test
    public void removeReturnValueNullValue() {
        ListMap listMap = new ListMap();

        listMap.put("Whoami", null);

        Assert.assertNull(listMap.remove("Whoami"));
    }

    @Test
    public void clearEmptyList() {
        ListMap listMap = new ListMap();

        listMap.clear();

        Assert.assertEquals(0, listMap.size());
    }

    @Test
    public void clearNonEmptyList() {
        ListMap listMap = new ListMap();

        for (int i = 0; i < 17; i++) {
            listMap.put("Whoami" + i, "urkey" + i);
        }

        listMap.clear();

        Assert.assertEquals(0, listMap.size());
    }
}