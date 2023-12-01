using System.Reflection.Metadata;

class ConversionUtils
{
    public static int IntFromString(String input)
    {
        return Int32.Parse(input);
    }

    public static String Reverse(String input)
    {
        String output = "";
        foreach (char c in input)
        {
            output = c + output;
        }
        return output;
    }


}