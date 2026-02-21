public class IntermediateState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +15 EXP");
        character.addExperience(15);

        if (character.getExperience() >= 120) {
            System.out.println("Level Up! -> Expert");
            character.setState(new ExpertState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating... +20 HP");
        character.addHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Intermediate cannot fight yet.");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}