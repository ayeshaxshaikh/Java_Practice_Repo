import java.io.BufferedReader;

class TooYoungException extends RuntimeException
{
    TooYoungException(String s)
    {
        super(s);
    }
}

class TooOldException extends RuntimeException
{
    TooOldException(String s)
    {
        super(s);
    }
}
class CustException extends RuntimeException
{
    public static void main(String[] args) {
        int age = Integer.parseInt(args[0]);

        if (age > 60)
        {
            throw new TooYoungException("plz wait sometime, you will get good match");
        }
        else if (age < 18)
        {
            throw new TooOldException("You are already too old to get married");
        }
        else
        {
            System.out.println("You will get match details soon in mail");
        }
    }
}

