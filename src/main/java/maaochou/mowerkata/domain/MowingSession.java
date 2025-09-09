package maaochou.mowerkata.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class MowingSession {
    private List<Mower> mowers;

    public MowingSession(List<Mower> mowers) {
        this.mowers = mowers != null ? new ArrayList<>(mowers) : new ArrayList<>();
    }

    public void executeMowersInstructions() {
        mowers.forEach(Mower::executeInstructions);
    }
}
