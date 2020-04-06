package com.musicTheory;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    generateNotes();
	    userInterface();
    }

    private static void userInterface() {
        generateMeasure();
    }

    private static void generateMeasure() {

        System.out.println("E | __________________________________________________ |");//50 -
        System.out.println("A | __________________________________________________ |");//50 -
        System.out.println("D | __________________________________________________ |");//50 -
        System.out.println("G | __________________________________________________ |");//50 -
        System.out.println("B | __________________________________________________ |");//50 -
        System.out.println("E | __________________________________________________ |");//50 -
//        System.out.println("E | __________________________________________________| ");//50 -
        System.out.println();
    }

    /**
     * calculates correct beta for a note, based on its location in Scientific Pitch Notation
     * @param beta constant multiplied by the note's relative location from origin A4, freq = 440.0
     * @param pow location of note to be calculated
     * @return
     */
    private static double betaRaised(double beta ,int pow) {

        return Math.pow(beta,pow);
    }

    /**
     * gets correct note name based on relative location
     * @param relLocation relative location of the note
     * @param noteName noteName param to be returned
     * @return
     */
    private static String getNoteName(int relLocation, String noteName) {
        switch (Math.abs(relLocation%12))
        {
            case 0:
                noteName = "C";
                break;
            case 1:
                noteName = "C#";
                break;
            case 2:
                noteName = "D";
                break;
            case 3:
                noteName = "D#";
                break;
            case 4:
                noteName = "E";
                break;
            case 5:
                noteName = "F";
                break;
            case 6:
                noteName = "F#";
                break;
            case 7:
                noteName = "G";
                break;
            case 8:
                noteName = "G#";
                break;
            case 9:
                noteName = "A";
                break;
            case 10:
                noteName = "A#";
                break;
            case 11:
                noteName = "B";
                break;
        }
        return noteName;
    }

    /**
     * calculates correct frequency for a note, based on its location in Scientific Pitch Notation, using betaRaised(beta,relLocation);
     * @param relLocation relative location of the note
     * @param beta constant multiplied by the note's relative location from origin A4, freq = 440.0
     * @param middleA4 frequency of origin point 440.0
     * @return
     */
    private static double getFreq(int relLocation, double beta, double middleA4){
        return middleA4 * betaRaised(beta,relLocation);
    }

    /**
     * calculates all of the notes in the Scientific Pitch Notation, orders by octave and returns a list of the octaves.
     * @return
     */
    private static ArrayList<Octave> generateNotes() {
        ArrayList<Octave> completeNoteList = new ArrayList<>();
        ArrayList<Note> tempOctaveNotes = new ArrayList<>();
        double beta = Math.pow(2,(1.0/12.0));
        double middleA4 = 440.0;
        int fundamentalFreqStart = 69;
        int fundamentalFreqEnd = 132;//62
        int noteOctave = -1;
//        System.out.println(middleA4 * betaRaised(beta,-1));

        generateOctave(tempOctaveNotes, beta, middleA4, fundamentalFreqStart, fundamentalFreqEnd, noteOctave);
        return completeNoteList;
    }

    /**
     * generates the correct octave based on all params *helper function*
     * @param tempOctaveNotes notes of the octave
     * @param beta constant multiplied by the note's relative location from origin A4, freq = 440.0
     * @param middleA4 frequency of origin point 440.0
     * @param fundamentalFreqStart 69
     * @param fundamentalFreqEnd 132
     * @param noteOctave octave number
     */
    private static void generateOctave(ArrayList<Note> tempOctaveNotes, double beta, double middleA4, int fundamentalFreqStart, int fundamentalFreqEnd, int noteOctave) {
        for (int i = 0; i < fundamentalFreqEnd; i++) {
            String noteName = "";
            noteName = getNoteName(i, noteName);
            //get relative note name
            Note tempNote = new Note(noteName, noteOctave, getFreq(i-fundamentalFreqStart, beta, middleA4));
            tempOctaveNotes.add(tempNote);
            //make relative note starting at C0 going to G9

            if ((i%12 == 11)|| (i-fundamentalFreqStart == 2)) {
                System.out.println("OCTAVE " + tempOctaveNotes.get(0).getNoteOctave());
                tempOctaveNotes.forEach(Note -> System.out.println(Note.toString()));
                tempOctaveNotes = new ArrayList<>();
                noteOctave++;
                System.out.println("***********************");
            }//for each octave, put notes into an octave, and add to completeNoteList
        }
    }
}
/* Notes on this project
https://en.wikipedia.org/wiki/Scientific_pitch_notation
https://ptolemy.berkeley.edu/eecs20/week8/scale.html
 */