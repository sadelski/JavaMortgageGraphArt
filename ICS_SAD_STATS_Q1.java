//Step 1
//Is the purpose of the program to read the file called Mortgages.txt and to add all the quarterly mortgage values for each column that states Mortgages in Canada outstanding, Residential mortgages, uninsured,
//for each intyear from 1982 to 2018 and to store them with the corresponding and output them with there corresponding intyear and then use them to find/output and store the percentage diffrence for each intyear after
//1982. Should we also output the percentage diffrences for each intyear to an outputfile. Should we add a search into our program
//that lets us search for a mortgage or percentage change value for a particuar value through a scanner. Should we graph the intyearly 
//mortgage value from 1982 to 2018 on a jframe using java swing. Should we output the number of records their are for each mortgage value of the 
//category Mortgages in Canada outstanding, Residential mortgages, uninsured; also should we output the mortgage and date for that
//particular record. Will it be a bar or lin graph on the jframe and how will it be scaled.
//
//
//  Step 2:
//Input                  //Output                   //Proccesing                  //storage
//line                     jframe                     addition                     intnum
//                       intypoints                 subtraction                 recstats.douintyearmort 
//                       doupercent                   multiplication             doupercent
//           recstatsarray.doumortval/intdate          division                 recstatsarray.intmortval
//                       year                                                       Retval
//                      value                                                       intcnt
//                                                                                   line
//                                                                                 strvalue
//                                                                                  stryear
//                                                                                 intypoints
//                                                                                  intdiv
//                                                                                 intYptarr
//                                                                                    one
//                                                                                    two
//                                                                                   xspace
//                                                                                   yspace
//                                                                                    gWin
//                                                                                    year
//                                                                                    value
//Assumptions and Limitation:                                                       
//we will have to read the file called Mortgages.txt and to add all the quarterly mortgage values for each column that states Mortgages in Canada outstanding, Residential mortgages, uninsured,
//for each intyear from 1982 to 2018 and to store them with the corresponding with there corresponding intyear and then use them to find/output and store the percentage diffrence for each intyear after
//1982.we will not output the percentage diffrences for each intyear to an outputfile. we will not add a search into our program
//that lets us search for a mortgage or percentage change value for a particuar value through a scanner. we will graph the intyearly 
//mortgage value from 1982 to 2018 by making a graph on the jframe using java swing which will be a bar graph and a line graph at the same time. we will not output the number of records their are for each mortgage value of the 
//category Mortgages in Canada outstanding, Residential mortgages, uninsured; also we will not output the mortgage and date for that
//particular record. We will not draw the percantage differences of each year on jframe between every two points on the bar/line graph.

//setup imports
import java.io.*;
import javax.swing.*;  
 
  public class ICS_SAD_STATS_Q1
  {
    private static class recstats
    {
 
//setup public variables of the recstats class
 public Double doumortval;
 public int intdate;

 public recstats(Double doumortval, int strdate)
   {
   //use this function on all variable declared recstats class
   this.doumortval = doumortval;
   this.intdate = intdate;
   }
 
    }
    
    private static int[] intYpoints = new int[37];//create private static array which will store yearly mortgage values and can be accesed by other classes
     
    public static void main(String[] args)throws IOException
{

     //create an array of recstats class 
     recstats[] recstatsarray = new recstats[37];
    
    
     for(int intcnt = 0; intcnt < 37; intcnt++)//use for loop to go through every array slot
     {
      recstatsarray[intcnt] = new recstats(0.0, 0);//intialize every array slot to double and int for variable from recstats class
     }
   
  BufferedReader InputFile = new BufferedReader(new FileReader("Mortgages.txt"));//use this to read the Input file
  
  //setup and initialize variables
  Double doupercent;//used to store percentage change
  int intnum = 0;//used to keep track of all 60 mortgage values in each year
  String line = " ";//used to temporaly store each read line from input file
  int intcnt = 0;//used to determine which column we are on in the file
  int intyear = 0;//used to determine current date and used as an index for an array
  
  
  while((line = InputFile.readLine()) != null && !line.isEmpty())//keep looping until all lines from the file have been  and aslong file is not empty
  {
    for(String Retval: line.split(","))//spilt each line read by coma to seperate every column
    {
   
    Retval = Retval.trim().replace(" " , "");//replace quatation marks and spaces infront and behind Retval
    
    switch(intcnt) //use switch case for intcnt
      {
     
      case 0: if(intnum == 60)//if intnum equals 60 which is how many values in one year there are of Mortgages in Canada outstanding, Residential mortgages, uninsured.
                {
                intyear++;//increment intyear
                intnum = 0;//set intnum to 0
               }
             intcnt++;//increment intcnt
      break;//break switchcase
      
      case 6: if (Retval.equals("uninsured"))//if Retval from the file is equal to uninsured
                 {
                 intcnt++;//increment intcnt
                 }  
      break;//break switchcase
      
      case 13: recstatsarray[intyear].doumortval += Double.parseDouble(Retval);//put yearly mortgage value to recstas.doumortval array
               intYpoints[intyear] += Integer.parseInt(Retval);
               recstatsarray[intyear].intdate = 1982 + intyear;//set date for the yearly mortgage vale
               intnum++;//increment intnum
               intcnt++;//increment intcnt
      break;//break switchcase
      
      case 17: intcnt = 0;//set intcnt to zero
      break;//break switchcase
      
      default: intcnt++;//increment intcnt
        break;//break switchcase
    
          }
       }
     }
 
  InputFile.close();//close input file
   
   for (intcnt = 1; intcnt <  recstatsarray.length; intcnt++) //use for loop to go through every array slot
   {
     
    //determine the percentage change for each year by using the perentage change formula
    doupercent =  (((recstatsarray[intcnt].doumortval - recstatsarray[intcnt-1].doumortval) / recstatsarray[intcnt-1].doumortval)) * 100;
    
   //output the percenatge change between years and the yearly mortgage value for each year
    System.out.println("the percentage change for mortgage from " + recstatsarray[intcnt -1].intdate  + "(" + recstatsarray[intcnt-1].doumortval + " million" + ")"+ " to " + recstatsarray[intcnt].intdate+ "(" + recstatsarray[intcnt].doumortval + " million"+ ")" + " is: %" + Math. round(doupercent * 100.0) / 100.0);
   
   }
   
   //setup jrame class and window
    JFrame MyWindow = new JFrame("MORTGAGE VALUES VS YEARS");// create and add title which will be displayed on jframe 
    MyWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add a exit condition
    Graphic1 A = new Graphic1();//add conection to Graphic1 class
    MyWindow.add(A);//create window which will be displayed on screen
    MyWindow.setSize(600,600);//set size of Window is 600x600
    MyWindow.setVisible(true);//make window visible
    
    }
     
     public static int[] returnArray()//create a method to return intYpoints array
     {
       return(intYpoints);//return intYpoints to Graphic1 class
     }
     
   }