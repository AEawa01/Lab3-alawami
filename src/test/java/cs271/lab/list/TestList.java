package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestList {

    private List<Integer> list;

    @Before
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        //list = new LinkedList<Integer>();
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testSizeEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        try {
            list.get(0);
            fail("there should not be any items in the list");
        } catch (Exception ex) {
        }
    }

    @Test
    public void testSizeNonEmpty() {
        list.add(77);
        assertEquals(false, list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(77, list.get(0).intValue());
    }

    @Test
    public void testContains() {
        list.contains(77);
        if(list.size()!=0){
            assertEquals(true, list.contains(77));
        }
        else{
            assertEquals(true, list.isEmpty());
        }
    }

    @Test
    public void testAddMultiple() {
        list.add(77);
        list.add(77);
        list.add(77);
        assertEquals(3, list.size());
        assertEquals(0, list.indexOf(77));
        assertEquals(77, list.get(1).intValue());
        assertEquals(2, list.lastIndexOf(77));
    }

    @Test
    public void testAddMultiple2() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        assertEquals(7, list.size());
        assertEquals(1, list.indexOf(77));
        assertEquals(5, list.lastIndexOf(77));
        assertEquals(44, list.get(2).intValue());
        assertEquals(77, list.get(3).intValue());
        assertEquals(Arrays.asList(33, 77, 44, 77, 55, 77, 66), list);
    }

    @Test
    public void testRemoveObject() {
        list.add(3);
        list.add(77);
        list.add(4);
        list.add(77);
        list.add(5);
        list.add(77);
        list.add(6);
        list.remove(5); // what does this method do?
        //Answer: Removes the element at the specified position in this list. So, It removes 77 from the list
        assertEquals(6, list.size());
        assertEquals(1, list.indexOf(77));
        assertEquals(3, list.lastIndexOf(77));
        assertEquals(4, list.get(2).intValue());
        assertEquals(77, list.get(3).intValue());
        list.remove(Integer.valueOf(5)); // what does this one do?
        //Answer: Removes the element at the specified position in this list. So, It removes 6 from the list
        assertEquals(5, list.size());
        assertEquals(1, list.indexOf(77));
        assertEquals(3, list.lastIndexOf(77));
        assertEquals(4, list.get(2).intValue());
        assertEquals(77, list.get(3).intValue());
    }

    @Test
    public void testContainsAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        assertEquals(Arrays.asList(33, 77, 44, 77, 55, 77, 66), list);
        assertEquals(list.containsAll(Arrays.asList(11, 22, 33)), false);
    }

    @Test
    public void testAddAll() {
        list.addAll(Arrays.asList(33, 77, 44, 77, 55, 77, 66));
        assertEquals(7, list.size());
        assertEquals(33, list.get(0).intValue());
        assertEquals(77, list.get(1).intValue());
        assertEquals(44, list.get(2).intValue());
        assertEquals(77, list.get(3).intValue());
        assertEquals(55, list.get(4).intValue());
        assertEquals(77, list.get(5).intValue());
        assertEquals(66, list.get(6).intValue());
    }

    @Test
    public void testRemoveAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        list.removeAll(Arrays.asList(33,44,55,66));
        assertEquals(3, list.size());
        assertEquals(Arrays.asList(77, 77, 77), list);
    }

    @Test
    public void testRetainAll() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        list.retainAll(Arrays.asList(77,77,77));
        assertEquals(3, list.size());
        assertEquals(Arrays.asList(77, 77, 77), list);
    }

    @Test
    public void testSet() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        Collections.replaceAll(list, 77, 99);
        assertEquals(7, list.size());
        assertEquals(33, list.get(0).intValue());
        assertEquals(99, list.get(1).intValue());
        assertEquals(44, list.get(2).intValue());
        assertEquals(99, list.get(3).intValue());
        assertEquals(55, list.get(4).intValue());
        assertEquals(99, list.get(5).intValue());
        assertEquals(66, list.get(6).intValue());
    }

    @Test
    public void testSubList() {
        list.add(33);
        list.add(77);
        list.add(44);
        list.add(77);
        list.add(55);
        list.add(77);
        list.add(66);
        // TODO fix the arguments in the subList method so that the assertion
        // passes
        assertEquals(Arrays.asList(44, 77, 55), list.subList(2, 5));
    }
}
