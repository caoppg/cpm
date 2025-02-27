package ca.pfv.spmf.algorithms.sequentialpatterns.clasp_AGP.dataStructures;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an itemset from a sequence.
 * The itemset consists of a list of items and an timestamp that denotes when the itemset occurs. An itemset with timestamp is also called "transaction"
 * 
 * Copyright Antonio Gomariz Peñalver 2013
 * 
 * This file is part of the SPMF DATA MINING SOFTWARE
 * (http://www.philippe-fournier-viger.com/spmf).
 *
 * SPMF is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SPMF is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SPMF.  If not, see  {@link http://www.gnu.org/licenses/}.
 * 
 * @author agomariz
 */
public class Itemset{

    /**
     * List of items that compose the itemset.
     */
    private List<Item> items = new ArrayList<Item>();
    /**
     * Timestamp of the itemset.
     */
    private long timestamp = 0;

    /**
     * Standard Itemset constructor
     */
    public Itemset() {
    }
    
    public Itemset(Itemset itemset) {
    	items = itemset.items;
    	timestamp = itemset.timestamp;
    }

    /**
     * It adds an item to the itemset. The item is inserted in the last position.
     * @param value The item to add
     */
    public void addItem(Item value) {
        items.add(value);
    }

    /**
     * It removes the item which appears in the specified index.
     * @param i the index
     * @return the removed item
     */
    public Item removeItem(int i) {
        return items.remove(i);
    }

    /**
     * It returns the list of items that compose the itemset.
     * @return the list of items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * It returns the item from the specified position.
     * @param index The index where is the item in which we are interested.
     * @return the item
     */
    public Item get(int index) {
        return items.get(index);
    }

    /**
     * Get the string representation of this itemset.
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        for (Item attribute : items) {
            r.append(attribute.toString());
            r.append(' ');
        }
        return r.toString();
    }
    
    /**
     * It clones the itemset.
     * @return The clone itemset.
     */
    public Itemset cloneItemSet() {
        Itemset itemset = new Itemset();
        itemset.timestamp = timestamp;
        itemset.getItems().addAll(items);
        return itemset;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * It returns the number of items that compose the itemset.
     * @return the number of items
     */
    public int size() {
        return items.size();
    }

    /**
     * Returns whether this itemset and the other one are equal based on size and the items contained.
     * @return Whether this itemset and the other one are equal.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itemset other = (Itemset) o;
        return (other.size() == size()) && items.containsAll(other.items);
    }

    /**
     * Returns a hashcode associated with this itemset.
     * @return A hashcode associated with this itemset.
     */
    @Override
    public int hashCode() {
        int sum = 0;
        for (Item i : items) {
            sum += i.hashCode();
        }
        return sum;
    }
}
