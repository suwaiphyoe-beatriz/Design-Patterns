public class NoviceState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +10 EXP");
        character.addExperience(10);

        if (character.getExperience() >= 50) {
            System.out.println("Level Up! -> Intermediate");
            character.setState(new IntermediateState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Novice cannot meditate.");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Novice cannot fight.");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
}