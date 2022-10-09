/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

package assignment03PartA;

import java.util.ArrayList;
import java.util.List;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    @Override
    public boolean add(T newEntry) {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;

         return true;

    }

    @Override
    public boolean removeAllOccurrences(T[][] entries) {
        boolean result=false;
        System.out.println("[+] Removing 2D test array items from the bag...");
        System.out.print(" [-] Converting 2D array to 1D...\n");
        List<T> convertedArray=new ArrayList<T>();
        for (int i=0;i<entries.length;i++){
            for (int j=0;j<entries.length;j++){
                convertedArray.add(entries[i][j]);
            }
        }
        System.out.println(" [-] Removing duplicates in 1D array...");
        ArrayList<T> arrayWithoutDuplicates=new ArrayList<T>();
        for (T element: convertedArray){
            if (!arrayWithoutDuplicates.contains(element)){
                arrayWithoutDuplicates.add(element);
                remove(element);
            }
        }
        //convertedArray=arrayWithoutDuplicates;
        System.out.print(" [>] The final 1D array now contains: ");
        for(T element: arrayWithoutDuplicates){
            System.out.print(element+" ");
        }
        System.out.println();
        System.out.print(" [-] Removing the final 1D array items from the bag...\n");
        for (int i=0;i<convertedArray.size();i++){
            remove(convertedArray.get(i));
        }


        return false;
    }

    @Override
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
         @SuppressWarnings("unchecked")
         T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

         int index = 0;
         Node currentNode = firstNode;
         while ((index < numberOfEntries) && (currentNode != null)) {
             result[index] = currentNode.data;
             index++;
             currentNode = currentNode.next;
             } // end while

         return result;
    }

    public int getFrequencyOf(T anEntry) {
         int frequency = 0;

         int counter = 0;
         Node currentNode = firstNode;
         while ((counter < numberOfEntries) && (currentNode != null)) {
             if (anEntry.equals(currentNode.data)) {
                 frequency++;
                 } // end if

             counter++;
             currentNode = currentNode.next;
             } // end while

         return frequency;
         } // end getFrequencyOf

    public boolean contains(T anEntry) {
         boolean found = false;
         Node currentNode = firstNode;

         while (!found && (currentNode != null)) {
             if (anEntry.equals(currentNode.data)) {
                 found = true;
                 } else {
                 currentNode = currentNode.next;
                 }
             } // end while

         return found;
         } // end contains
    private Node getReferenceTo(T anEntry) {
         boolean found = false;
         Node currentNode = firstNode;

         while (!found && (currentNode != null)) {
             if (anEntry.equals(currentNode.data)) {
                 found = true;
                 } else {
                 currentNode = currentNode.next;
                 }
             } // end while

         return currentNode;
         } // end getReferenceTo
    public boolean remove(T anEntry) {
         boolean result = false;
         Node nodeN = getReferenceTo(anEntry);

         if (nodeN != null) {
             nodeN.data = firstNode.data; // Replace located entry with entry in first

             firstNode = firstNode.next; // Remove first node
             numberOfEntries--;

             result = true;
             } // end if

         return result;
         } // end remove
    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }
}