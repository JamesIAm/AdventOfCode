using System.Text.RegularExpressions;

class Program
{
    static Dictionary<String, char> forwardNumbers = new Dictionary<string, char>();
    static Dictionary<String, char> backwardNumbers = new Dictionary<string, char>();
    static void Main()
    {
        addDictEntries();
        // Console.WriteLine("asdasdasd" + Regex.Matches("atwo1nine", "^two.*").Count());
        List<String> lines = ReadFile.readDaysInput(1);
        int total = 0;
        foreach (String line in lines)
        {
            char first = findFirst(line, forwardNumbers);
            char last = findLast(line);
            String number = "" + first + last;
            int value = ConversionUtils.IntFromString(number);
            total += value;
            // Console.WriteLine(value);
        }
        Console.WriteLine(total);
    }

    static char findFirst(String line, Dictionary<String, char> numberMap)
    {
        String shortenedLine = line;
        for (int index = 0; index < line.Length; index++)
        {
            // Console.WriteLine("shortened line -> " + shortenedLine);
            foreach (String textNum in numberMap.Keys)
            {
                if (Regex.Matches(shortenedLine, textNum).Count() > 0)
                {
                    return numberMap[textNum];
                }
                else if (Char.IsNumber(shortenedLine.First()))
                {
                    return shortenedLine.First();
                }

            }
            shortenedLine = shortenedLine.Substring(1);
        }
        throw new Exception("Couldn't find first in " + line);
    }
    static char findLast(String line)
    {
        String reversedLine = ConversionUtils.Reverse(line);
        try
        {
            return findFirst(reversedLine, backwardNumbers);
        }
        catch (Exception e)
        {
            throw new Exception("Couldn't find last in " + reversedLine);
        }
    }

    static void addDictEntries()
    {
        forwardNumbers.Add("^one.*", '1');
        forwardNumbers.Add("^two.*", '2');
        forwardNumbers.Add("^three.*", '3');
        forwardNumbers.Add("^four.*", '4');
        forwardNumbers.Add("^five.*", '5');
        forwardNumbers.Add("^six.*", '6');
        forwardNumbers.Add("^seven.*", '7');
        forwardNumbers.Add("^eight.*", '8');
        forwardNumbers.Add("^nine.*", '9');
        backwardNumbers.Add("^eno.*", '1');
        backwardNumbers.Add("^owt.*", '2');
        backwardNumbers.Add("^eerht.*", '3');
        backwardNumbers.Add("^ruof.*", '4');
        backwardNumbers.Add("^evif.*", '5');
        backwardNumbers.Add("^xis.*", '6');
        backwardNumbers.Add("^neves.*", '7');
        backwardNumbers.Add("^thgie.*", '8');
        backwardNumbers.Add("^enin.*", '9');
    }

}