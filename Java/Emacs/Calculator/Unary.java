package symbolic;

public abstract class Unary extends SymExpr {
    private SymExpr argument;

    public Unary(SymExpr a) {
	argument = a;
    }

    public String toString() {
	return getName() + "(" + argument.toString() + ")";
    }

}