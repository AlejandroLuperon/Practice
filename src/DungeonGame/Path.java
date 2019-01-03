package DungeonGame;

/**
 */

public class Path {
    private Integer totalDamage = 0;
    public Integer lowestEncounteredScore = 0;
    public Path() {

    }

    public Path(Integer totalDamage) {
        this.totalDamage = totalDamage;
    }

    public Path(Path path) {
        this.totalDamage = path.totalDamage;
        this.lowestEncounteredScore = path.lowestEncounteredScore;
    }

    public Integer getTotalDamage() {
        return totalDamage;
    }

    public void updateTotalDamage(int newDamage) {
        totalDamage = totalDamage + newDamage;
        if (lowestEncounteredScore > totalDamage) {
            lowestEncounteredScore = totalDamage;
        }
    }

    public Integer getLowestEncounteredScore() {
        return lowestEncounteredScore;
    }
}
