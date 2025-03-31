import java.util.Scanner;
public class taskone
{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter the number of students:");
    int num=sc.nextInt();
    int[] grades=new int[num];
    for(int i=0;i<num;i++)
    {
     System.out.println("Enter the grades of Student"+(i+1));
     grades[i]=sc.nextInt();
    }
    double avg = calcAvg(grades);
    int highest = calcHigh(grades);
    int lowest = calcLow(grades);
    System.out.println("Average grade: "+avg);
    System.out.println("Highest grade: "+highest);
    System.out.println("Lowest grade: "+lowest);
    sc.close();
  } 
  public static double calcAvg(int[] grades)
  {
    int sum=0;
    for(int grade:grades)
    {
     sum+=grade;
    }
    return(double) sum/grades.length;
  }
  public static int calcHigh(int[] grades)
  {
    int highest = grades[0];
    for(int grade:grades)
    {
      if(grade>highest)
      {
      highest = grade;
      }
    }
    return highest;
  }
  public static int calcLow(int[] grades)
  {
    int lowest = grades[0];
    for(int grade:grades)
    {
      if(grade<lowest)
      {
      lowest = grade;
      }
    }
    return lowest;
  }
}
