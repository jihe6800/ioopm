package symbolic;

public abstract class Binary extends SymExpr {
    private SymExpr left;
    private SymExpr right;
	
    public Binary(SymExpr left, SymExpr right) {
	this.left = left;
	this.right = right;
    }
    
    public String toString() {
	return "(" + left + getName() + right + ")"; 
    }

}