package com.duckrace;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/*
 * This is a lookup table of ids to student names.
 * When a duck wins for the first time, we need to find out who that is.
 * This lookup table could be hardcoded with the data, or we could read the data 
 * in from a file, so that no code changes would need to be made for each cohort.
 *
 * Map<Integer,String> studentIdMap;
 * 
 * Integer    String
 * =======    ======
 *    1       John
 *    2       Jane
 *    3       Danny
 *    4       Armando
 *    5       Sheila
 *    6       Tess
 * 
 *
 * We also need a data structure to hold the results of all winners.
 * This data structure should facilitate easy lookup, retrieval, and storage.
 *
 * Map<Integer,DuckRacer> racerMap;
 *
 * Integer    DuckRacer
 * =======    =========
 *            id    name     wins   rewards
 *            --    ----     ----   -------
 *    5        5    Sheila     2    PRIZES, PRIZES
 *    6        6    Tess       1    PRIZES
 *   13       13    Zed        3    PRIZES, DEBIT_CARD, DEBIT_CARD
 *   17       17    Dom        1    DEBIT_CARD
 */

public class Board implements Serializable {
    private static final String DATA_FILE_PATH = "data/board.dat";
    private static final String STUDENT_ID_FILE_PATH = "conf/student-ids.csv";

    /*
     * read from binary file data/board.dat or create a new Board
     */
    public static Board getInstance() {
        Board board = null;
        if (Files.exists(Path.of(DATA_FILE_PATH))) {
            // read it back
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(DATA_FILE_PATH))) {
                board = (Board) in.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // first time bc file doesn't exist
            board = new Board();
        }

        return board;
    }

    private final Map<Integer,String> studentIdMap = loadStudentIdMap();
    private final Map<Integer,DuckRacer> racerMap  = new TreeMap<>();

    // prevent instantiation from outside
    private Board() {
    }
    /*
     * Update the board (racerMap) by making a DuckRacer win
     * fetching an existing DuckRacer from racerMap
     * or create new DuckRacer and put into map
     */

    public void update(int id, Reward reward) {
        DuckRacer racer = null;
        if (racerMap.containsKey(id)) {
            // fetch existing DuckRacer
            racer = racerMap.get(id);
        } else {
            // create new
            racer = new DuckRacer(id, studentIdMap.get(id));
            racerMap.put(id, racer);

        }
        racer.win(reward);
        save();
    }

    /*
     * Writes this Board object to binary file data/board.dat
     * we are using java built in Object Serialization facility
     * to write the state of this object to the file
     */
    private void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(DATA_FILE_PATH))) {

            out.writeObject(this); // write "me" (I am a Board object) to the file (as dust)
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*
     * this shows data to human user
     */
    public void show() {

        if (racerMap.isEmpty()) {
            System.out.println("There are currently no results to show");
        } else {
            Collection<DuckRacer> racers = racerMap.values();

            System.out.println("id    name    wins    rewards");
            System.out.println("---    ---     ----   ---------");
            for (DuckRacer duckRacer: racers) {
                System.out.printf("%s    %s    %s    %s\n",
                        duckRacer.getId(), duckRacer.getName(), duckRacer.getWins(), duckRacer.getRewards());
            }
        }


    }

    void dumpStudentIdMap() {
        System.out.println(studentIdMap);
    }
    // csv to map
    private Map<Integer,String> loadStudentIdMap() {
        Map<Integer,String> studentIdMap = new HashMap<Integer,String>();

        try {
            List<String> lines = Files.readAllLines(Path.of(STUDENT_ID_FILE_PATH));

            for (String line: lines) {
                String[] tokens = line.split(",");
                Integer id = Integer.valueOf(tokens[0]);
                String name = tokens[1];
                studentIdMap.put(id, name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentIdMap;
    }

}