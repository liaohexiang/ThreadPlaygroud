package com.tony.roundrobin;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;



public class RoundRobin<E> {
	
    private final ConcurrentLinkedQueue<E> collection ;
    private Iterator<? extends E> iterator;

    private ReentrantLock resetLock = new ReentrantLock();
    
    public RoundRobin() {
       
        collection = new ConcurrentLinkedQueue<E>();
        reset();
    }
    public void add(E e){
    	collection.add(e);
    }
    /**
     * Returns the next object in the collection.
     * <p>
     * If at the end of the collection, return the first element.
     *
     * @return the next object
     * @throws NoSuchElementException if there are no elements
     *         at all.  Use {@link #hasNext} to avoid this error.
     */
    public E next() {
        if (collection.size() == 0) {
            throw new NoSuchElementException("There are no elements for this iterator to loop on");
        }
        if (iterator.hasNext() == false) {
            reset();
        }
        return iterator.next();
    }



    /**
     * Resets the iterator back to the start of the collection.
     */
    public void reset() {
    	try{
    		resetLock.lock();
    		if(iterator == null||!iterator.hasNext())
    			iterator = collection.iterator();
    	}finally{
    		resetLock.unlock();
    	}
    }

    /**
     * Gets the size of the collection underlying the iterator.
     *
     * @return the current collection size
     */
    public int size() {
        return collection.size();
    }
}
