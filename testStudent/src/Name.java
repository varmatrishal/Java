// ------------------------------------------------------------
//                Name.java
// ------------------------------------------------------------

public class Name
{
	private String first;  // first name
	private String last;   // last name
	public static final int LESS_THAN = -1;
	public static final int EQUAL = 0;
	public static final int GREATER_THAN = 1;
	boolean disposeNotCalled;

	public Name()
	{
		this ( "", "" );
	}

	public Name(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public void setName(String firstName, String lastName)
	{
		first = firstName;
		last  = lastName;
	}

	public Name(Name obj) throws NullPointerException {

		if ( obj == null ) throw new NullPointerException();

		first = new String ( obj.first );
		last  = new String ( obj.last);
		disposeNotCalled = true;
//		System.out.println ( "Person - copy constructor" );
	}  // Copy Constructor

	public void   setFirst(String firstName) { first = firstName;  }
	public void   setLast (String lastName ) { last = lastName;    }
	public String getFirst()                 { return first;	   }
	public String getLast ()	             { return last;   	   }
	public String getName ()                 { return toString();  }
	public void   giveLastNameTo ( Name aName )
	{
		aName.setLast ( last );
	}

	public boolean equals ( Object obj ) {	if ( this == obj ) return true;

		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
			Name d = ( Name ) obj;

			if ( ( first.equals ( d.first ) ) &&
					( last.equals ( d.last ) ) )
					//&& ( age == d.age ) )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}}			   // Equals method

	public String toString( )
	{
		return first + " " + last;
	}

	public void finalize ( ) {
		System.out.println("Finalize method called");

	}

	public void dispose ( )  {
		System.out.println("Dispose Method called");

	}

	public int hashCode ( )  {
		// Using Joshua Bloch's recipe for hashCode

		int result = 17;

		result = 37 * result + first.hashCode(); // StringBuffer has no hashCode method
		result = 37 * result + last.hashCode();
		result = 37 * result + ( disposeNotCalled ? 0 : 1 );
		return result;
	}

	public int compareTo(Object obj) {
		int firstNames = 0, lastNames = 0, ages = 0;  //  Comparison Results

		if ( this == obj ) return 0;							// The same object is equal
		if ( obj == null ) throw new NullPointerException ( );	// Null argument
		if ( getClass( ) != obj.getClass( ) ) throw new ClassCastException ();

		Name d = ( Name ) obj;

		//  --------------- Get instance variable relationships ---------------------
		firstNames = ( first.compareTo ( d.first) );
		lastNames  = ( last.compareTo ( d.last) );
		if ( firstNames > 0 ) firstNames =  1;
		if ( firstNames < 0 ) firstNames = -1;
		if ( lastNames  > 0 ) lastNames  =  1;
		if ( lastNames  < 0 ) lastNames  = -1;
		System.out.println ( "fn = " + firstNames + ", ln = " + lastNames );

		if ( ( firstNames == lastNames ) )
			return firstNames;

		switch ( lastNames ) {
			case LESS_THAN:
				return LESS_THAN;
			case EQUAL:
				switch ( firstNames ) {
					case LESS_THAN:
						return LESS_THAN;
					case EQUAL:
						return EQUAL;
					case GREATER_THAN:
						return GREATER_THAN;
				}
			case GREATER_THAN:
				return GREATER_THAN;
			default:
//				System.out.println ( "Shouldn't get here!" );
				return 0;
		}
		}


} // end Name
