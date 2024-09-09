import java.util.Scanner;
public class Main
{
    public static int timeOutput(String time) throws Exception
    {
        String[] stringHolder = time.split(":", 3);
        if(stringHolder.length != 3)
        {
            throw new InvalidTimeException("Enter a valid time");
        }

        int hours = Integer.parseInt(stringHolder[0]);
        int minutes = Integer.parseInt(stringHolder[1]);
        int seconds = Integer.parseInt(stringHolder[2]);

        if(hours < 0)
        {
            throw new InvalidTimeException("Hour must be above -1");
        }
        if(hours > 23)
        {
            throw new InvalidTimeException("Hour must be below 24");
        }
        if(minutes < 0)
        {
            throw new InvalidTimeException("Minutes must be greater than -1");
        }
        if(minutes > 59)
        {
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        if(seconds < 0)
        {
            throw new InvalidTimeException("Seconds must be greater than -1");
        }
        if(seconds > 59)
        {
            throw new InvalidTimeException("Seconds must be less than 60");
        }
        else
        {
            return ((hours * 60 * 60) + (minutes * 60) + seconds);
        }

    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            String timeOne = input.nextLine();
            if(timeOne.equals("\n") || timeOne == " ")
            {
                throw new InvalidTimeException("Enter a valid time");
            }
            int timeOneSeconds = timeOutput(timeOne);

            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            String timeTwo = input.nextLine();
            if(timeOne.equals("\n") || timeOne == " ")
            {
                throw new InvalidTimeException("Enter a valid time");
            }
            int timeTwoSeconds = timeOutput(timeTwo);
            System.out.println("Difference in seconds: " + Math.abs(timeTwoSeconds - timeOneSeconds));
        }
        catch(InvalidTimeException e)
        {
            System.out.println(e.getMessage());
        }



    }
}