public class ExpertState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        System.out.println("Training... +20 EXP");
        character.addExperience(20);

        if (character.getExperience() >= 200) {
            System.out.println("Level Up! -> Master");
            character.setState(new MasterState());
        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditating... +30 HP");
        character.addHealth(30);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting... -20 HP, +30 EXP");
        character.reduceHealth(20);
        character.addExperience(30);

        if (character.getExperience() >= 200) {
            System.out.println("Level Up! -> Master");
            character.setState(new MasterState());
        }
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}