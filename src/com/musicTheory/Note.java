package com.musicTheory;

public class Note {

    private String noteName;
    private int noteOctave;
    private double frequency;
    /**
     * Creates a Note
     * @param noteName String name
     * @param noteOctave int Octave subNumber
     * @param frequency int freq
     */
    public Note(String noteName, int noteOctave, double frequency) {
        this.noteName = noteName;
        this.noteOctave = noteOctave;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "note{" +
                " noteName =' " + getNoteName() + '\'' +
                " noteOctave = " + getNoteOctave() + '\'' +
                " frequency = " +    getFrequency() + '\'' +
                '}';
    }

    public String getNoteName() {
        return noteName;
    }

    public int getNoteOctave() {
        return noteOctave;
    }

    public double getFrequency() {
        return frequency;
    }
}
