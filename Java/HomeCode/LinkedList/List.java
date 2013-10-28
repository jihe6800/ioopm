public class List {
    private Link first = null;
    private Link last  = null;
    
    public void prepend(Object element) {
	
	if(this.first == null){
	    last = first = new Link(first, element);
	} else {
	    first = new Link(first, element);
	}
	    
    }
    
    public Link getFirst(){
	return first;
    }
    
    public boolean contains(Object element) {
	if(this.first == null) return false;
	return first.contains(element);
    }
    
    public String toString() {
      	//return "[" + ((this.first == null) ? "" : this.first.stringify()) + "]";
	
	if(this.first == null) {
	    return "[]";
	} else {
	    return "[" + this.first.stringify() + "]";
	}
    }
    
    
    
    private class Link {
	public Link() {
	    this(null, null);
	}
	
	public Link(Link next, Object element){
	    this.next = next;
	    this.element = element;
	}
	
	private Link next;
	private Object element;
	
	public Object getElement(){
	    return this.element;
	}
	
	public Link getNext(){
	    return this.next;
	}
	
	public boolean contains(Object element){
	    if(element == this.element) return true;
	    if(this.next == null) return false;
	    
	    return next.contains(element);
	}
	
	public String toString() {
	    //return element.toString() + ((this.next == null) ? "" : ", ");
	    
	    if(this.next == null) {
		return element.toString() + "";
	    } else {
		return element.toString() + ", ";
	    }
	}
	
	public String stringify() {
	    //return toString() + ((this.next == null) ? "" : this.next.stringify());	
	    
	    if(this.next == null) {
		return toString() + "";
	    } else {
		return toString() + this.next.stringify();
	    }
	}
    }
}


	