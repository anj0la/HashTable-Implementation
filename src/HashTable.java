import java.util.LinkedList;

/**
 * Name: Anjola Aina
 * ID: 1673923
 * Date: Thursday, March 24th, 2022
 *
 * Information about the code:
 *
 * Creates a hash table object that supports the following methods that hash tables must support: add, delete, search
 * and check.
 *
 * This class also includes the following methods:
 *
 * createLinkedLists() -> void
 * hashFunction(String) -> long
 * add(String) -> void
 * delete(String) -> void
 * findString(String) -> void
 * checkIndex(String) -> void
 * isStringInTable(LinkedList<String>, String) -> boolean
 */
public class HashTable {

    // an array of linked lists, wherein each element in the array is a linked list
    private LinkedList<String>[] hashTable;

    /**
     * The size of the hash table.
     */
    private final int hashTableSize;

    /**
     * A constant prime number.
     */
    private final int X = 263;

    /**
     * A constant prime number.
     */
    private final int P = 1000000007;

    /**
     * Creates a hash table and initializes the table so that each element has an empty linked list of strings.
     * @param size
     */
    public HashTable(int size) {
        hashTable = new LinkedList[size];
        hashTableSize = size;
        createLinkedLists();
    } // Constructor

    /**
     * Fills the hash table with an empty linked list of string at each slot in the table.
     */
    public void createLinkedLists() {
        for (int i = 0; i < hashTableSize; i++) {
            hashTable[i] = new LinkedList<>();
        }
    } // createLinkedLists

    /**
     * The polynomial hash function for the hash table.
     * @param aString  the string to be calculated by the hash function
     */
    public long hashFunction(String aString) {
        long summation = 0;
        long hashValue = 0;
        int currentCharASCII = 0;
        for (int i = 0; i < aString.length(); i++) {
            currentCharASCII = (int) aString.charAt(i);
            summation = (long) (summation + (currentCharASCII * Math.pow(X, i)));
        }
        hashValue = (summation % P) % hashTableSize;
        return hashValue;
    } // hashFunction

    /**
     * Adds a string into the hash table.
     * @param aString the string that the user inputted
     */
    public void add(String aString) {
        int index = (int) hashFunction(aString);
        LinkedList<String> stringLinkedList = hashTable[index];
        if (isStringInTable(stringLinkedList, aString)) {
            return; // does not add that same element again to the linked list
        }
        stringLinkedList.addFirst(aString);
    } // add

    /**
     * Deletes a string from the hash table.
     * @param aString the string that the user inputted
     */
    public void delete(String aString) {
        int index = (int) hashFunction(aString);
        LinkedList<String> stringLinkedList = hashTable[index];
        if (!isStringInTable(stringLinkedList, aString)) {
            return; // element is not in the table, so there is nothing to be deleted
        }
        stringLinkedList.remove(aString);
    } // delete

    /**
     * Finds if the string inputted by the user exists in the hash table, and prints out a response depending on
     * whether the string is in the hash table or not.
     * @param aString the string that the user inputted
     */
    public void find(String aString) {
        int index = (int) hashFunction(aString);
        LinkedList<String> stringLinkedList = hashTable[index];
        if (isStringInTable(stringLinkedList, aString)) {
            System.out.println("Yes"); // the string is in the table
        } else {
            System.out.println("No"); // the string is not in the table
        }
    } // find

    /**
     * Prints out the elements in the current linked list in the hash table.
     * @param index the current index (a linked list)
     */
    public void checkIndex(int index) {
        LinkedList<String> stringLinkedList = hashTable[index];
        if (stringLinkedList.size() == 0) {
            System.out.println();
        } else {
            for (int i = 0; i < stringLinkedList.size(); i++) {
                System.out.print(stringLinkedList.get(i) + " ");
            }
            System.out.println();
        }
    } // checkIndex

    /**
     * Checks if a string is currently in the hash table.
     * @param stringLinkedList the current linked list of the hash table
     * @param aString the string that the user inputted
     * @return - true if the string is in the table, false otherwise
     */
    private boolean isStringInTable(LinkedList<String> stringLinkedList, String aString) {
        for (int i = 0; i < stringLinkedList.size(); i++) {
            if (stringLinkedList.get(i).equals(aString)) {
                return true;
            }
        }
        return false;
    } // checkIfStringInTable

} // class
