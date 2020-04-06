package com.musicTheory;

import java.util.ArrayList;

public class Octave {
    private ArrayList<Note> myNotes = new ArrayList<>();

    public Octave(ArrayList<Note> notes) {
        this.myNotes = notes;
    }

    public ArrayList<Note> getMyNotes() {
        return myNotes;
    }
}
