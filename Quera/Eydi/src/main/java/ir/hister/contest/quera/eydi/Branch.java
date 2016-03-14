package ir.hister.contest.quera.eydi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by khbak on 3/14/2016.
 */
public class Branch {
    private List<Eydi> eydis;

    public Branch() {
        this(null);
    }

    public Branch(Branch parent) {
        eydis = new ArrayList<>();
        if (parent != null) {
            eydis.addAll(parent.getEydis());
        }
    }

    public void addEydi(Eydi eydi) {
        if (contains(eydi))
            throw new EndlessEydisFoundException();

        eydis.add(eydi);
    }

    public int getSize() {
        return eydis.size();
    }

    public List<Eydi> getEydis() {
        return eydis;
    }

    public boolean contains(Eydi eydi) {
        return eydis.contains(eydi);
    }
}
