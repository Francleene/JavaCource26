package ru.spbau.mit.francleene.HashMap;

import org.junit.Test;
import org.junit.Assert;

public class HashMapTest {
    @Test
    public void constructorSpecificCapacitySizeEmptyMap() {
        HashMap hashMap = new HashMap(10);

        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void constructorSpecificCapacitySizeNonEmptyMap() {
        HashMap hashMap = new HashMap(10);

        for (int i = 0; i < 34; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals(34, hashMap.size());
    }

    @Test
    public void constructorSpecificCapacityContainsFalse() {
        HashMap hashMap = new HashMap(10);

        Assert.assertFalse(hashMap.contains("Whoami"));
    }

    @Test
    public void constructorSpecificCapacityContainsTrue() {
        HashMap hashMap = new HashMap(10);

        hashMap.put("Whoami", "urkey");

        Assert.assertTrue(hashMap.contains("Whoami"));
    }

    @Test
    public void constructorSpecificCapacityGetNotExistedElement() {
        HashMap hashMap = new HashMap(10);

        Assert.assertNull(hashMap.get("Whoami"));
    }

    @Test
    public void constructorSpecificCapacityGetExistedElement() {
        HashMap hashMap = new HashMap(10);

        hashMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", hashMap.get("Whoami"));
    }

    @Test
    public void constructorSpecificCapacityPut() {
        HashMap hashMap = new HashMap(10);

        hashMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", hashMap.get("Whoami"));
    }

    @Test
    public void constructorSpecificCapacityRemove() {
        HashMap hashMap = new HashMap(10);

        for (int i = 0; i < 34; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.remove("Whoami15");

        Assert.assertFalse(hashMap.contains("Whoami15"));
    }

    @Test
    public void constructorSpecificCapacityClear() {
        HashMap hashMap = new HashMap(10);

        for (int i = 0; i < 34; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.clear();

        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void sizeEmptyHashMap() {
        HashMap hashMap = new HashMap();

        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void sizeAddOneElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "imvalue");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeAddFewDifferentElements() {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 15; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals(15, hashMap.size());
    }

    @Test
    public void sizeAddSameElements() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.put("Whoami", "urkey");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeAddNullElement() {
        HashMap hashMap = new HashMap();

        hashMap.put(null, "urnull");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeRemoveOneExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");
        hashMap.put("Whoami2", "urkey2");
        hashMap.remove("Whoami1");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeRemoveFewExistedElements() {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 34; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        for (int i = 0; i < 34; i += 2) {
            hashMap.remove("Whoami" + i);
        }

        Assert.assertEquals(17, hashMap.size());
    }

    @Test
    public void sizeRemoveOneNonExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");
        hashMap.put("Whoami2", "urkey2");
        hashMap.remove("Whoami3");

        Assert.assertEquals(2, hashMap.size());
    }

    @Test
    public void sizeRemoveFewNotExistedElements() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        for (int i = 0; i < 34; i += 2) {
            hashMap.remove("Whoami" + i);
        }

        Assert.assertEquals(17, hashMap.size());
    }

    @Test
    public void sizeClear() {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 34; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.clear();

        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void sizeContainsExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.contains("Whoami");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeContainsNotExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.contains("urkey");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeGetExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.get("Whoami");

        Assert.assertEquals(1, hashMap.size());
    }

    @Test
    public void sizeGetNotExistedElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.get("urkey");

        Assert.assertEquals(1, hashMap.size());
    }


    @Test
    public void containsEmptyList() {
        HashMap hashMap = new HashMap();

        Assert.assertFalse(hashMap.contains("Whoami"));
    }

    @Test
    public void containsOneElementContain() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");

        Assert.assertTrue(hashMap.contains("Whoami"));
    }

    @Test
    public void containsOneElementDoNotContain() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey");

        Assert.assertFalse(hashMap.contains("Whoami2"));
    }

    @Test
    public void containsFewElementsContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertTrue(hashMap.contains("Whoami17"));
    }

    @Test
    public void containsFewElementsDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertFalse(hashMap.contains("Whoami18"));
    }

    @Test
    public void containsNullElementContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 18; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put(null, "urnull");

        for (int i = 19; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertTrue(hashMap.contains(null));
    }

    @Test
    public void containsNullElementDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertFalse(hashMap.contains(null));
    }

    @Test
    public void containsDoublePut() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put("Whoami17", "urkey17");

        Assert.assertTrue(hashMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterRemoveContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.remove("Whoami17");

        Assert.assertTrue(hashMap.contains("Whoami15"));
    }

    @Test
    public void containsAfterRemoveDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.remove("Whoami17");

        Assert.assertFalse(hashMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterClear() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.clear();

        Assert.assertFalse(hashMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterGetExistedElement() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.get("Whoami17");

        Assert.assertTrue(hashMap.contains("Whoami17"));
    }

    @Test
    public void containsAfterGetNotExistedElement() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.get("Whoami18");

        Assert.assertFalse(hashMap.contains("Whoami18"));
    }

    @Test
    public void getEmptyList() {
        HashMap hashMap = new HashMap();

        Assert.assertEquals(null, hashMap.get("Whoami"));
    }

    @Test
    public void getOneElementContain() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", hashMap.get("Whoami"));
    }

    @Test
    public void getOneElementDoNotContain() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey");

        Assert.assertNull(hashMap.get("Whoami2"));
    }

    @Test
    public void getFewElementsContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urkey17", hashMap.get("Whoami17"));
    }

    @Test
    public void getFewElementsDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(hashMap.get("Whoami18"));
    }

    @Test
    public void getNullKeyElementContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 18; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put(null, "urnull");

        for (int i = 19; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urnull", hashMap.get(null));
    }

    @Test
    public void getNullKeyElementDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(hashMap.get(null));
    }

    @Test
    public void getNullValueElement() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 18; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put("I'm the King 18", null);

        for (int i = 19; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertNull(hashMap.get("I'm the King 18"));
    }

    @Test
    public void getDoublePutSameValue() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put("Whoami17", "urkey17");

        Assert.assertEquals("urkey17", hashMap.get("Whoami17"));
    }

    @Test
    public void getDoublePutDifferentValue() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.put("Whoami17", "U r the King 18");

        Assert.assertEquals("U r the King 18", hashMap.get("Whoami17"));
    }

    @Test
    public void getAfterRemoveContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.remove("Whoami17");

        Assert.assertEquals("urkey15", hashMap.get("Whoami15"));
    }

    @Test
    public void getAfterRemoveDoNotContain() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.remove("Whoami17");

        Assert.assertNull(hashMap.get("Whoami17"));
    }

    @Test
    public void getAfterClear() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.clear();

        Assert.assertNull(hashMap.get("Whoami17"));
    }

    @Test
    public void getAfterGetExistedElement() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.get("Whoami17");

        Assert.assertEquals("urkey17", hashMap.get("Whoami17"));
    }

    @Test
    public void getAfterGetNotExistedElement() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 34; i += 2) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.get("Whoami18");

        Assert.assertNull(hashMap.get("Whoami18"));
    }

    @Test
    public void putOneNotNullElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", hashMap.get("Whoami"));
    }

    @Test
    public void putFewDifferentElements() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 17; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        Assert.assertEquals("urkey3", hashMap.get("Whoami3"));
    }

    @Test
    public void putFewSameElements() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 17; i++) {
            hashMap.put("Whoami", "urkey" + i);
        }

        Assert.assertEquals("urkey16", hashMap.get("Whoami"));
    }

    @Test
    public void putElementNullKey() {
        HashMap hashMap = new HashMap();

        hashMap.put(null, "urnull");

        Assert.assertEquals("urnull", hashMap.get(null));
    }

    @Test
    public void putFewElementsNullKey() {
        HashMap hashMap = new HashMap();

        for (int i = 1; i < 17; i++) {
            hashMap.put(null, "urnull" + i);
        }

        Assert.assertEquals("urnull16", hashMap.get(null));
    }

    @Test
    public void putElementNullValue() {
        HashMap hashMap = new HashMap();

        hashMap.put("I'm the King", null);

        Assert.assertNull(null, hashMap.get("I'm the King"));
    }

    @Test
    public void putReturnValueEmptyList() {
        HashMap hashMap = new HashMap();

        Assert.assertNull(hashMap.put("Whoami", "urkey"));
    }

    @Test
    public void putReturnValueDifferentKeys() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");

        Assert.assertNull(hashMap.put("Whoami2", "urkey2"));
    }

    @Test
    public void putReturnValueSameKeys() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey1");

        Assert.assertEquals("urkey1", hashMap.put("Whoami", "urkey2"));
    }

    @Test
    public void putReturnValueNullKey() {
        HashMap hashMap = new HashMap();

        Assert.assertNull(hashMap.put(null, "urnull"));
    }

    @Test
    public void putReturnValueNullValue() {
        HashMap hashMap = new HashMap();

        Assert.assertNull(hashMap.put("Whoami", null));
    }

    @Test
    public void putReturnValueDoubleNullKey() {
        HashMap hashMap = new HashMap();

        hashMap.put(null, "urnull1");

        Assert.assertEquals("urnull1", hashMap.put(null, "urnull2"));
    }

    @Test
    public void putReturnValueDoubleNullValue() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", null);

        Assert.assertNull(hashMap.put("Whoami", null));
    }

    @Test
    public void removeEmptyList() {
        HashMap hashMap = new HashMap();

        hashMap.remove("urkey");

        Assert.assertFalse(hashMap.contains("Whoami"));
    }

    @Test
    public void removeOneElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.remove("Whoami");

        Assert.assertFalse(hashMap.contains("Whoami"));
    }

    @Test
    public void removeAnotherElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");
        hashMap.remove("Whoami2");

        Assert.assertTrue(hashMap.contains("Whoami1"));
    }

    @Test
    public void removeNullKeyDoNotExist() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");
        hashMap.remove(null);

        Assert.assertFalse(hashMap.contains(null));
    }

    @Test
    public void removeNullKeyExist() {
        HashMap hashMap = new HashMap();

        hashMap.put(null, "urnull");
        hashMap.remove(null);

        Assert.assertFalse(hashMap.contains(null));
    }

    @Test
    public void removeReturnValueEmptyList() {
        HashMap hashMap = new HashMap();

        Assert.assertNull(hashMap.remove("Whoami"));
    }

    @Test
    public void removeReturnValueOneElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", "urkey");

        Assert.assertEquals("urkey", hashMap.remove("Whoami"));
    }

    @Test
    public void removeReturnValueAnotherElement() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");

        Assert.assertNull(hashMap.remove("Whoami2"));
    }

    @Test
    public void removeReturnValueNullKeyDoNotExist() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami1", "urkey1");

        Assert.assertNull(hashMap.remove(null));
    }

    @Test
    public void removeReturnValueNullKeyExist() {
        HashMap hashMap = new HashMap();

        hashMap.put(null, "urnull");

        Assert.assertEquals("urnull", hashMap.remove(null));
    }

    @Test
    public void removeReturnValueNullValue() {
        HashMap hashMap = new HashMap();

        hashMap.put("Whoami", null);

        Assert.assertNull(hashMap.remove("Whoami"));
    }

    @Test
    public void clearEmptyList() {
        HashMap hashMap = new HashMap();

        hashMap.clear();

        Assert.assertEquals(0, hashMap.size());
    }

    @Test
    public void clearNonEmptyList() {
        HashMap hashMap = new HashMap();

        for (int i = 0; i < 17; i++) {
            hashMap.put("Whoami" + i, "urkey" + i);
        }

        hashMap.clear();

        Assert.assertEquals(0, hashMap.size());
    }
}