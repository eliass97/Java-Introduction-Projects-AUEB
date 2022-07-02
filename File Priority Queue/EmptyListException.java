//ILIAS SETTAS 3150156
//ALEJANDROS JOVARAS 3150171

public class EmptyListException extends RuntimeException {
	
	public EmptyListException() {
		this( "List" );
	}
	
	public EmptyListException( String name ) {
		super( name + " is empty" );
	} 
} 