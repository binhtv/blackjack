package common;

public enum Action {
    HIT(1), STAND(2), CHECK(3);

    private int value;

    Action(int val) {
        this.value = val;
    }

    public static Action of(int val) {
        for (Action action : values()) {
            if(action.value == val) {
                return action;
            }
        }

        return null;
    }
}
