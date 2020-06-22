public enum Operation {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String name;
    Operation(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
