// -----------------------------------------------
//                    TestStudentName.java
// -----------------------------------------------

public class TestStudentName
{
	public static void main ( String [ ] args )
	{
		Name n1 = new Name ( "Ty",   "Cobb" );
		Name n2 = new Name ( "Babe", "Ruth" );

	// ---- Test the copy constructor --------
		System.out.println ( "Test the copy constructor ------------" );
		Student s1 = new Student ( n1, "123456" );
		Student s2 = new Student ( s1 );

		s2.setStudent ( n2, "234567" );
		if ( s1.equals ( s2 ) )
		{
			System.out.println ( "\t\tError - students should not be the same" );
			System.out.println ( "\t\ts1 = " + s1 );
			System.out.println ( "\t\ts1 = " + s2 );
		}
		else
		{
			System.out.println ( "\t\tSuccess - students are not the same" );
			System.out.println ( "\t\ts1 = " + s1 );
			System.out.println ( "\t\ts1 = " + s2 );
		}


	// ---- Test the clone method ------------
		System.out.println ( "\n\nTest the 'clone' method ------------" );
		Student s3 = (Student) s1.clone ( );
		if ( s1.equals ( s3 ) )
			System.out.println ( "\t\tSuccess - Students s1 and s3 are the same." );
		else
		{
			System.out.println ( "\t\tError - Students s1 and s3 are not the same" );
			System.out.println ( "\t\ts1 = " + s1 );
			System.out.println ( "\t\ts3 = " + s3 );
		}

		s3.setStudent ( n2, "234567" );
		if ( s1.equals ( s3 ) )
		{
			System.out.println ( "\t\tError - students should not be the same" );
			System.out.println ( "\t\ts1 = " + s1 );
			System.out.println ( "\t\ts1 = " + s3 );
		}
		else
			System.out.println ( "\t\tSuccess - students are not the same" );

	// ---- Test the finalize method ---------
		System.out.println ( "\n\nTest the 'finalize' method ------------" );
		s1 = null;
		System.gc();
		System.out.println ( "\t\tShould see the 'finalize' message ------------" );

	// ---- Test the dispose method ----------
		System.out.println ( "\n\nTest the 'dispose' method ------------" );
		s2.dispose();
		System.out.println ( "\t\tShould see the 'dispose' message ------------" );
		s2 = null;


	// ---- Test the hashCode method ---------
		s1 = new Student ( s3 );
		System.out.println ( "\n\nTest the 'hashCode' method ------------" );
		if ( s1.hashCode ( ) == s3.hashCode ( ) )
			System.out.println ( "\t\tSuccess - hashCode for s1 and s3 are the same." );
		else
		{
			System.out.println ( "\t\tError - hashCode for s1 and s3 are not the same." );
			System.out.println ( "\t\ts1.hashCode = " + s1.hashCode() );
			System.out.println ( "\t\ts3.hashCode = " + s3.hashCode() );
		}

		System.out.println (  );
	}
}
