import java.util.*;
import java.util.regex.*;

public class PasswordCheckerUtility extends java.lang.Object 
{
    public PasswordCheckerUtility()
    {
        
    }
    
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException
    {
        if(!(password.equals(passwordConfirm)))
        {
            throw new UnmatchedException();
        }
    }
    
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm)
    {
        return password.equals(passwordConfirm);
    }
    
    public static boolean isValidLength(String password) throws LengthException
    {
        if(password.length() >= 6)
        {
            return true;
        }
        else
        {
            throw new LengthException();
        }
    }
    
    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException
    {
        if(password.equals(password.toLowerCase()))
        {
            throw new NoUpperAlphaException();
        }
        else
        {
            return true;
        }
    }
    
    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException
    {
        if(password.equals(password.toUpperCase()))
        {
            throw new NoLowerAlphaException();
        }
        else
        {
            return true;
        }
    }
    
    public static boolean hasDigit(String password) throws NoDigitException
    {
        for(int i = 0; i < password.length(); i++)
        {
            if(Character.isDigit(password.charAt(i)))
            {
                return true;
            }
        }
        throw new NoDigitException();
    }
    
    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException
    {
    	Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches())
        {
        	throw new NoSpecialCharacterException();
        }
        return true;
    }
    
    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException
    {
    	boolean noSameChar = true;
        /*for(int i = 0; i < password.length(); i++)
        {
        	if(password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2))
        	{
        		noSameChar = false;
        		throw new InvalidSequenceException();
        	}
        }
        return noSameChar; */
    	
    	Pattern pattern = Pattern.compile("((.)\\2{2,})");
    	Matcher matcher = pattern.matcher(password);
    	if(matcher.find())
    	{
    		noSameChar = false;
    		throw new InvalidSequenceException();	
    	}
    	return noSameChar;
    }
    
    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException
    {
        boolean length = false, upper = false, lower = false, digit = false, special = false, sequence = false;
        try
        {
            length = isValidLength(password);
            upper = hasUpperAlpha(password);
            lower = hasLowerAlpha(password);
            digit = hasDigit(password);
            special = hasSpecialChar(password);
            sequence = NoSameCharInSequence(password);
        }
       /* catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
        {
            e.getMessage();
        }*/
        finally 
        {
            if(length && upper && lower && digit && special && sequence)
            {
                return true;
            }
        }
        return false;
    }
    
    public static boolean hasBetweenSixAndNineChars(String password)
    {
        if(password.length() <= 9 && password.length() >= 6)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isWeakPassword(String password) throws WeakPasswordException
    {
        boolean valid = true, size = false;
        try
        {
            valid = isValidPassword(password);
        }
        catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
        {
            e.getMessage();
        }
        finally
        {
            size = hasBetweenSixAndNineChars(password);
            if(valid && size)
            {
                throw new WeakPasswordException();
            }
        }
        return false;
    }
    
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords)
    {
        ArrayList<String> invalidPass = new ArrayList<String>();
        //String badPass = "";
        for (int i = 0; i < passwords.size(); i++)
        {
        	try
        	{
        		isValidPassword(passwords.get(i));
        	}
        	catch(LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException | NoSpecialCharacterException | InvalidSequenceException e)
        	{
        		invalidPass.add(passwords.get(i) + " " + e.getMessage()); 
        	}
        }
        return invalidPass;
    }
} 