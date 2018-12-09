package lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class handle_files
{
	
	public static void main(String arg[]) throws Exception
	{
		// Read the input file 'HW1-data'.
		BufferedReader reader;
		reader = new BufferedReader(new FileReader("C:\\Users\\HP G4\\Desktop\\New folder\\JAVA Lab\\HW1-data.txt"));
		// For writing to the output file.
		BufferedWriter writer;
		writer = new BufferedWriter(new FileWriter("C:\\Users\\HP G4\\Desktop\\New folder\\JAVA Lab\\HWOutput.txt"));
		// Providing heading for the output file.
		writer.write("Stdnt Id Ex -------- Assignments -------- Mi Fin CL Pts Pct Gr");
		writer.newLine();
		writer.newLine();
		writer.write("-------- -- ----------------------------- -- --- -- --- --- --");
		writer.newLine();
		writer.newLine();
		int total_sum = 0;
		int count1 = 0;
		int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
		int max = 0;
		String line = reader.readLine();
		while(line != null)
		{
			// Storing words in the array.
			String arr[] = line.split("\\s+");
			int sum = 0;
			for(int i = 1; i < arr.length; i++)
			{
				sum += Integer.parseInt(arr[i]);
			}
			// Performing operations and writing to the output file.
			writer.write(line);
			writer.write(" " + sum);
			total_sum += sum;
			count1++;			
			int percentage = ((sum * 100) / 420);
			writer.write("  " + percentage);			
			writer.write("  " + grade(percentage));
			if(grade(percentage) == 'A') countA++;
			else if(grade(percentage) == 'B') countB++;
			else if(grade(percentage) == 'C') countC++;
			else if(grade(percentage) == 'D') countD++;
			else countF++;
			if(sum > max) max = sum;
			writer.newLine();
			line = reader.readLine();
		}
		writer.newLine();
		// Writing the summary to the output file.
		writer.write("Average total point percent of all students : " + (((total_sum / count1) * 100) / 420));
		writer.newLine();
		writer.newLine();
		writer.write("Number of A's = " + countA);
		writer.newLine();
		writer.write("Number of B's = " + countB);
		writer.newLine();
		writer.write("Number of C's = " + countC);
		writer.newLine();
		writer.write("Number of D's = " + countD);
		writer.newLine();
		writer.write("Number of F's = " + countF);
		writer.newLine();
		writer.newLine();
		writer.write("Maximum points = " + max);
		writer.close(); // Refer to line no. 84.
		BufferedReader reader2;
		reader2 = new BufferedReader(new FileReader("C:\\Users\\HP G4\\Desktop\\New folder\\JAVA Lab\\HWOutput.txt"));
		String line2 = reader2.readLine();
		while(line2 != null)
		{
			System.out.println(line2);
			line2 = reader2.readLine();
		}
		// Closing all the input-output readers and writers.
		reader.close();
		// writer.close(); // Earlier, when I wrote 'writer.close();' here, then output was not showing on console because we cannot 'read' a file until its 'write' is closed.
		// We can even write 'writer.close();' at both lines 73 and 84 at the same time and output is fine.
		reader2.close();
	}
	
	// Function to calculate the grade according to marks.
	static char grade(int percentage)
	{
		if(percentage >= 90) return 'A';
		else if(percentage >= 78) return 'B';
		else if(percentage >= 62) return 'C';
		else if(percentage >= 46) return 'D';
		else return 'F';
	}	
	
}