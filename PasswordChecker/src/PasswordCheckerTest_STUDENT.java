
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> passwords;
	String password1, password2;
	
	@Before
	public void setUp() throws Exception 
	{
		String[] p = {"AABBCC12!", "shawn5BBB#", "8Bil$", "bearam12", "august31", "gY3cf", 
				"GaithhherssburG#", "camelCase", "UsAAA@789"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(p));
	}

	@After
	public void tearDown() throws Exception 
	{
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aBcDe"));
			assertTrue("Did not throw Length Exception", false);
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a Length Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ilovecmsc12!"));
			assertTrue("Did not throw No Upper Alpha Exception", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a No Upper Alpha Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("ILOVEUPPERCASE12!"));
			assertTrue("Did not throw No Lower Alpha Exception", false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a No Lower Alpha Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("aaaBBC12!"));
			assertTrue("Did not throw Weak Password Exception", false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a Weak Password Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("CCCbba12!"));
			assertTrue("Did not throw an Invalid Sequence Exception", false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an Invalid Sequence Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("thSgP!"));
			assertTrue("Did not throw No Digit Exception", false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a No Digit Exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("goodPass12!"));
			assertTrue("Did not throw exception", true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some exception", false);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the invalidPass of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPass;
		invalidPass = PasswordCheckerUtility.getInvalidPasswords(passwords);
		
		Scanner scan = new Scanner(invalidPass.get(0)); 
		assertEquals(scan.next(), "AABBCC12!");
		String nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("lowercase"));
		
		scan = new Scanner(invalidPass.get(1));  
		assertEquals(scan.next(), "shawn5BBB#");
		nextinvalidPass = scan.nextLine().toLowerCase(); 
		assertTrue(nextinvalidPass.contains("sequence"));
		
		 
		scan = new Scanner(invalidPass.get(2));  
		assertEquals(scan.next(), "8Bil$");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("long"));
		
		scan = new Scanner(invalidPass.get(3));  
		assertEquals(scan.next(), "bearam12");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("uppercase"));
		
		scan = new Scanner(invalidPass.get(4));  
		assertEquals(scan.next(), "august31");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("uppercase") );
		
		scan = new Scanner(invalidPass.get(5));  
		assertEquals(scan.next(), "gY3cf");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("long") );
		
		scan = new Scanner(invalidPass.get(6));  
		assertEquals(scan.next(), "GaithhherssburG#");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("digit") );
		
		scan = new Scanner(invalidPass.get(7)); 
		assertEquals(scan.next(), "camelCase");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("digit") );
		
		scan = new Scanner(invalidPass.get(8));  
		assertEquals(scan.next(), "UsAAA@789");
		nextinvalidPass = scan.nextLine().toLowerCase();
		assertTrue(nextinvalidPass.contains("sequence") );
		
	}
	
}
