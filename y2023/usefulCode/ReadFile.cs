using System.IO;

// See https://aka.ms/new-console-template for more information
class ReadFile
{
    public static List<String> readDaysInput(int day)
    {
        return Read(string.Format("A:\\AdventOfCode\\y2023\\Day{0}\\bin\\input.txt", day));
    }
    public static List<String> Read(String filePath)
    {
        List<String> lines = new List<string>();
        StreamReader sr;
        try
        {
            //Pass the file path and file name to the StreamReader constructor
            sr = new StreamReader(filePath);
            //Read the first line of text
            String line = sr.ReadLine();
            //Continue to read until you reach end of file
            while (line != null)
            {
                //write the line to console window
                lines.Add(line);
                //Read the next line
                line = sr.ReadLine();
            }
            //close the file
            sr.Close();
            return lines;

        }
        catch (Exception e)
        {
            Console.WriteLine("Exception: " + e.Message);
            throw e;
        }
    }
}