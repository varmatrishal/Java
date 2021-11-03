// ----------------------------------------------------------
//                    Student.java
// ----------------------------------------------------------

public class Student
{
	private Name fullName;
	private String id;
	boolean disposeNotCalled;
	public static final int LESS_THAN = -1;
	public static final int EQUAL = 0;
	public static final int GREATER_THAN = 1;

	public Student()
	{
		this ( new Name ( ), "" );
	}

	public Student(Name studentName, String studentId)
	{
		fullName = studentName;
		id = studentId;
	}

	public Student(Student obj) throws NullPointerException	{



		if ( obj == null ) throw new NullPointerException();

		this.fullName = new Name(obj.fullName);
		this.id = new String(obj.id);
		disposeNotCalled = true;
//		System.out.println ( "Person - copy constructor" );
	}

	public Object clone() {	return new Student ( this );}

	public void setStudent(Name studentName, String studentId)
	{
		fullName = studentName;
		id       = studentId;
	}

	public void   setName(Name studentName) {	fullName = studentName;	}
	public Name   getName()                 {   return fullName;        }
	public void   setId(String studentId)   {	id = studentId;         }
	public String getId()                   {	return id;              }


	public String toString()
	{
		return id + " " + fullName;
	}

	@Override
	public boolean equals ( Object obj ) {


		if ( this == obj ) return true;

		if ( ( obj != null ) && ( getClass( ) == obj.getClass( ) ) )
		{
		Student d = ( Student ) obj;

			if ( ( fullName.equals ( d.fullName ) ) &&
					( id.equals(d.id) ) )
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
		}  }

	public void finalize() {
		System.out.println("Student Finalize Method Called");
	}

	public void dispose() {
		System.out.println("Student Dispose Method Called");
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + fullName.toString().hashCode(); // StringBuffer has no hashCode method
		result = 37 * result + id.hashCode();
		result = 37 * result + ( disposeNotCalled ? 0 : 1 );
		return result; }


	public int compareTo (Object obj ) {
		int firstNames = 0, lastNames = 0, ids = 0;  //  Comparison Results


		if ( this == obj ) return 0;							// The same object is equal
		if ( obj == null ) throw new NullPointerException ( );	// Null argument
		if ( getClass( ) != obj.getClass( ) ) throw new ClassCastException ();

		Student d = ( Student ) obj;
		Name n = ( Name ) obj;
		String f1 = ((Name) obj).getFirst();
		String l1 = ((Name) obj).getLast();
		String f = n.getFirst();
		String l = n.getLast();


		//  --------------- Get instance variable relationships ---------------------
		firstNames = ( f1.compareTo (f) );
		lastNames  = ( l1. toString().compareTo (l) );
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

}  // end Student
