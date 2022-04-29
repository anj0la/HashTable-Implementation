import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name: Anjola Aina
 * ID: 1673923
 * Date: Thursday, March 24th, 2022
 *
 * Information about the code:
 *
 * Handles all user input, allowing the user to enter a finite amount of queries, and correctly executing the operations
 * that are supported on a hash table (add, del, find and check).
 *
 * This class also includes the following methods:
 *
 * generateHashTableSize() -> int
 * generateNumberOfQueries() -> int
 * generateNumberOfLines(int, HashTable) -> void
 * handleQuery(String, HashTable) -> void
 * addQuery(String, HashTable) -> void
 * deleteQuery(String, HashTable) -> void
 * findQuery(String, HashTable) -> void
 * checkQuery(String, HashTable) -> void
 */
public class Main {

    public static void main(String[] args) {
        int numOfBuckets = generateHashTableSize();
        HashTable aHashTable = new HashTable(numOfBuckets);
        int numOfQueries = generateNumberOfQueries();
        generateNumberOfLines(numOfQueries, aHashTable);
    } // main

    /**
     * Generates the hash table size.
     * @return - the size of the hash table
     */
    public static int generateHashTableSize() {
        Scanner input = new Scanner(System.in);
        int hashTableSize = 0;
        System.out.println("Enter the number of slots that the hash table will have: ");
        try {
            hashTableSize = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You have not entered in a valid number. Try again.");
            generateHashTableSize();
        }
        return hashTableSize;
    } // generateHashTableSize

    /**
     * Generates the number of table size.
     * @return - the size of the hash table
     */
    public static int generateNumberOfQueries() {
        Scanner input = new Scanner(System.in);
        int numberOfQueries = 0;
        System.out.println("Enter the number of queries: ");
        try {
            numberOfQueries = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You have not entered in a valid number. Try again.");
            generateNumberOfQueries();
        }
        return numberOfQueries;
    } // generateNumberOfQueries

    /**
     * Generates the number of times that the user can enter a query.
     * @param numOfQueries the number of queries that the user is allowed to input
     * @param hashTable the current hashtable
     */
    public static void generateNumberOfLines(int numOfQueries, HashTable hashTable) {
        Scanner input = new Scanner(System.in);
        String currentQuery = "";
        for (int i = 0; i < numOfQueries; i++) {
            System.out.println("Enter some query: ");
            currentQuery = input.nextLine();
            handleQuery(currentQuery, hashTable);
        }
    } // generateNumberOfLines

    /**
     * Handles all queries that the user inputs, by checking what the current query starts with, and executing the
     * correct function on the hash table.
     * @param aQuery the current query
     * @param hashTable the current hashtable
     */
    public static void handleQuery(String aQuery, HashTable hashTable) {
        if (aQuery.startsWith("add")) {
            addQuery(aQuery, hashTable);
        } else if (aQuery.startsWith("del")) {
            deleteQuery(aQuery, hashTable);
        } else if (aQuery.startsWith("find")) {
            findQuery(aQuery, hashTable);
        } else if (aQuery.startsWith("check")) {
            checkQuery(aQuery, hashTable);
        } else {
            System.out.println("This is not one of the valid operations.");
        }
    } // handleQuery

    /**
     * Inserts a string into the hash table.
     * @param addQuery the query inputted by the user
     * @param hashTable the current hash table
     */
    public static void addQuery(String addQuery, HashTable hashTable) {
        String word = "";
        for (int i = 4; i < addQuery.length(); i++) {
            word = word + addQuery.charAt(i);
        }
        hashTable.add(word);
    } // addQuery

    /**
     * Removes a string from the hash table.
     * @param delQuery the query inputted by the user
     * @param hashTable the current hash table
     */
    public static void deleteQuery(String delQuery, HashTable hashTable) {
        String word = "";
        for (int i = 4; i < delQuery.length(); i++) {
            word = word + delQuery.charAt(i);
        }
        hashTable.delete(word);
    } // deleteQuery

    /**
     * Checks if the string is in the hash table.
     * @param findQuery the query inputted by the user
     * @param hashTable the current hash table
     */
    public static void findQuery(String findQuery, HashTable hashTable) {
        String word = "";
        for (int i = 5; i < findQuery.length(); i++) {
            word = word + findQuery.charAt(i);
        }
        hashTable.find(word);
    } // findQuery

    /**
     * Prints the content of the i-th list in the hash table.
     * @param checkQuery the query inputted by the user
     * @param hashTable the current hash table
     */
    public static void checkQuery(String checkQuery, HashTable hashTable) {
        String word = "";
        for (int i = 6; i < checkQuery.length(); i++) {
            word = word + checkQuery.charAt(i);
        }
        hashTable.checkIndex(Integer.parseInt(word));
    } // checkQuery

} // class
