
package examproject;

import java.util.Scanner;

public class ExamProject {
    final static int ArraySize = 50;
    
    public static void main(String[] args) {
    
    int StudentRecords = 0;
    int[] StudentID = new int[ArraySize];
    int[] Exam1 = new int[ArraySize];
    int[] Exam2 = new int[ArraySize];
    int[] Exam3 = new int[ArraySize];
    int[] Exam4 = new int[ArraySize];
    int[] Exam5 = new int[ArraySize];
    int[] average = new int[ArraySize];
    int[] ClassAvg = new int[ArraySize];
    int[] Aaverage = new int[ArraySize];
    int[] Baverage = new int [ArraySize];
    String[] LetterGrade = new String[ArraySize];
    
    String ID = "Student ID";
    String E1 = "Exam 1";
    String E2 = "Exam 2";        
    String E3 = "Exam 3";
    String E4 = "Exam 4";
    String E5 = "Exam 5";
    String Avg = "Average";
    String letter = "Letter Grade";
    
    
    StudentRecords = GetData(StudentID,Exam1,Exam2,Exam3,Exam4,Exam5);
    average(StudentID,Exam1,Exam2,Exam3,Exam4,Exam5,StudentRecords,average);
    letterGrade(average,StudentRecords,LetterGrade);
    
    
    System.out.println("\f****************************Student Records Entered******************************");
    //Produce a report containing all the input records (to be centered on a page)
    System.out.printf("%10s %11s %12s %13s %14s %15s %16s %17s  \n", ID,E1,E2,E3,E4,E5,Avg,letter);
    System.out.printf("");
    for (int i = 0;i < StudentRecords;i++)
    {
        System.out.printf("%d %20d %20d %20d %20d %20d %20d %25s \n",StudentID[i],Exam1[i],Exam2[i],Exam3[i],Exam4[i],Exam5[i],average[i],LetterGrade[i]);
    }
    System.out.println("******************************************************************************");
    System.out.printf("Number of Students in the class: %d%n",StudentRecords);
    System.out.println("\f*****************************Students with A or B********************************");
    //Produce a report of students’ records with the letter grades of A or B.
    SortStudents(StudentID,Exam1,Exam2,Exam3,Exam4,Exam5,StudentRecords,LetterGrade,average);
    System.out.printf("%10s %8s %12s \n",ID,Avg,letter);
    ABStudent(Aaverage,Baverage,average,StudentRecords,StudentID,LetterGrade);

    System.out.println("******************************************************************************");
    System.out.printf("Number of Students in the class: %d%n",StudentRecords);
    System.out.println("\f****************************Students After Sort***************************");
    //Display a sorted report on ascending order according to students’ id number.
    System.out.printf("%10s %11s %12s %13s %14s %15s %16s %17s \n", ID,E1,E2,E3,E4,E5,Avg,letter);
    for (int i = 0;i < StudentRecords;i++)
    {
        System.out.printf("%d %20d %20d %20d %20d %20d %20d %25s \n",StudentID[i],Exam1[i],Exam2[i],Exam3[i],Exam4[i],Exam5[i],average[i],LetterGrade[i]);
    }
    System.out.println("******************************************************************************");
    System.out.printf("Number of Students in the class: %d%n",StudentRecords);
    System.out.println("\f***************Student Records Entered, sorted, and class averages******************");
    //Produce a report showing all the records followed by the class average for each of the five exams.
    System.out.printf("%10s %11s %12s %13s %14s %15s %16s %17s  \n", ID,E1,E2,E3,E4,E5,Avg,letter);
    for (int i = 0;i < StudentRecords;i++)
    {
        System.out.printf("%d %20d %20d %20d %20d %20d %20d %25s \n",StudentID[i],Exam1[i],Exam2[i],Exam3[i],Exam4[i],Exam5[i],average[i],LetterGrade[i]);
    }
    Class(Exam1,Exam2,Exam3,Exam4,Exam5,StudentRecords,ClassAvg);
    System.out.println("Class averages of each exam: ");
    System.out.printf("%28s %24s %22s %21s %19s \n",ClassAvg[0],ClassAvg[1],ClassAvg[2],ClassAvg[3],ClassAvg[4]);
    System.out.println("******************************************************************************");
    //Display the count of students in class.
    System.out.printf("Number of Students in the class: %d%n",StudentRecords);
    System.out.print("\f");
    
    }
    

    private static int GetData(int[] StudentID, int[] Exam1, int[] Exam2, int[] Exam3, int[] Exam4, int[] Exam5) {
    Scanner input = new Scanner(System.in);
    int numStudents;
    
    System.out.print("Please enter number of students "+"<no more than> "+ArraySize + ": \n");
    numStudents = input.nextInt();
    while (numStudents > 50 || numStudents < 0) 
    {
    System.out.println("Your input does not match the criteria, please enter a number between 0 and 50");

    while(!input.hasNextInt())
    {
       input.next() ;
    }
    numStudents = input.nextInt();
    }
    
    for (int i = 0; i < numStudents; i++)
    {
        System.out.println("Please enter student ID number followed by exam scores 1 - 5");
        StudentID[i] = input.nextInt();
        Exam1[i] = input.nextInt();
        Exam2[i] = input.nextInt();
        Exam3[i] = input.nextInt();
        Exam4[i] = input.nextInt();
        Exam5[i] = input.nextInt();
    }
    return numStudents;
    }

    private static int[] average(int[] StudentID, int[] Exam1, int[] Exam2, int[] Exam3, int[] Exam4, int[] Exam5, int StudentRecords,int[] average) 
    {
    
    for (int i = 0;i < StudentRecords;i++)
    {
        int[] minimum = new int[ArraySize];
        minimum[i] = Exam1[i];
        
        if (Exam2[i] < minimum[i])
            minimum[i] = Exam2[i];
        if (Exam3[i] < minimum[i])
            minimum[i] = Exam3[i];
        if (Exam4[i] < minimum[i])
            minimum[i] = Exam4[i]; 
        if (Exam5[i] < minimum[i])
            minimum[i] = Exam5[i];
        
        
    average[i]= ((Exam1[i]+Exam2[i]+Exam3[i]+Exam4[i]+Exam5[i])-minimum[i])/4;        

    }

    return average;
    }

    private static void letterGrade(int[] average,int StudentRecords,String[] LetterGrade) {
        
        for (int i = 0;i < StudentRecords;i++)
        {
            if(average[i] == 100 | average[i] >= 90)
                LetterGrade[i] = "A";
            else if(average[i] <= 89 & average[i]>= 80)
                LetterGrade[i] = "B";
            else if(average[i] <= 79 & average[i]>= 70)
                LetterGrade[i] = "C";
            else if(average[i] <= 69 & average[i]>= 60)
                LetterGrade[i] = "D";
            else
                LetterGrade[i] = "F";
        }
        
    }

    private static void SortStudents(int[] StudentID, int[] Exam1, int[] Exam2, int[] Exam3, int[] Exam4, int[] Exam5,
            int StudentRecords,String[] LetterGrade,int[] average) {
        int tempStudentID;
        int tempExam1;
        int tempExam2;
        int tempExam3;
        int tempExam4;
        int tempExam5;
        int tempAverage;
        String tempLetterGrade;
        
        for (int p = 1; p <= StudentRecords - 1;p++)
            for (int i = 0; i <= StudentRecords - 2;i++)
                if(StudentID[i] > StudentID [i +1])
                {
                    tempStudentID = StudentID[i];
                    StudentID[i] = StudentID[i + 1];
                    StudentID[i + 1] = tempStudentID;
                    
                    tempExam1 = Exam1[i];
                    Exam1[i] = Exam1[i + 1];
                    Exam1[i +1] = tempExam1;
                    
                    tempExam2 = Exam2[i];
                    Exam2[i] = Exam2[i + 1];
                    Exam2[i +1] = tempExam2;
                    
                    tempExam3 = Exam3[i];
                    Exam3[i] = Exam3[i + 1];
                    Exam3[i +1] = tempExam3;
                    
                    tempExam4 = Exam4[i];
                    Exam4[i] = Exam4[i + 1];
                    Exam4[i +1] = tempExam4;
                    
                    tempExam5 = Exam5[i];
                    Exam5[i] = Exam5[i + 1];
                    Exam5[i +1] = tempExam5;
                    
                    tempLetterGrade = LetterGrade[i];
                    LetterGrade[i] = LetterGrade[i + 1];
                    LetterGrade[i +1] = tempLetterGrade;
                    
                    tempAverage = average[i];
                    average[i] = average[i + 1];
                    average[i +1] = tempAverage;
                }
          
    }

    private static void Class(int[] Exam1, int[] Exam2, int[] Exam3, int[] Exam4, int[] Exam5,int StudentRecords,int[] ClassAvg) 
    {
    int sum1 = 0;
    int sum2 = 0;
    int sum3 = 0;
    int sum4 = 0;
    int sum5 = 0;
    int average1 = 0;
    int average2 = 0;
    int average3 = 0;
    int average4 = 0;
    int average5 = 0;
    
    for(int i = 0;i < StudentRecords;i++)
    {
    sum1 += Exam1[i];
    }
    average1 = sum1/StudentRecords;
    ClassAvg[0] = average1;
    
    for(int i = 0;i < StudentRecords;i++)
    {
    sum2 += Exam2[i];
    }
    average2 = sum2/StudentRecords;
    ClassAvg[1] = average2;
    
    for(int i = 0;i < StudentRecords;i++)
    {
    sum3 += Exam3[i];
    }
    average3 = sum3/StudentRecords;
    ClassAvg[2] = average3;
    
     for(int i = 0;i < StudentRecords;i++)
    {
    sum4 += Exam4[i];
    }
    average4 = sum4/StudentRecords;
    ClassAvg[3] = average4;
    
    for(int i = 0;i < StudentRecords;i++)
    {
    sum5 += Exam5[i];
    }
    average5 = sum5/StudentRecords;
    ClassAvg[4] = average5;
    }  

    private static void ABStudent(int[] Aaverage, int[] Baverage, int[] average,int StudentRecords,int[] StudentID,String[] LetterGrade) {
        
        for (int i = 0;i < StudentRecords;i++){
            if(LetterGrade[i] == "A" | LetterGrade[i] == "B")
                System.out.printf("%d %10d %10s \n",StudentID[i],average[i],LetterGrade[i]);
        }
    }
}//end of Program
