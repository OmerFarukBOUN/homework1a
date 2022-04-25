package needed;

import  java.io.*;

import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;

import selectionSort.SelectionSortMain;
import quickSort.QuickSortMain;
import insertationSort.InsertationSortMain;


import  org.apache.poi.hssf.usermodel.HSSFRow;

public class filetest{
    public static void main(String[]args) {
        try {
        	
            String filename = "C:\\Users\\izmir\\Desktop\\NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
            int howMany = 100;
            InsertationSortMain newSortMain = new InsertationSortMain();
            long[][] array = newSortMain.sort(howMany);
            HSSFRow rowhead = sheet.createRow(0);
            rowhead.createCell(0).setCellValue("mean");
            rowhead.createCell(1).setCellValue("standart deviation");
            rowhead.createCell(2).setCellValue("size");
            for (int i=0;i<8;i++ ) {
            	int[] arraysizes= {10,20,30,40,50,100,500,1000};
            	HSSFRow row = sheet.createRow(1+i);
            	long total = 0;
            	long total2 =0;
            	for(int j=0; j<howMany; j++) {
            		total += array[j][i];
            	}
            	long mean = total/howMany;
            	for (int j=0; j<howMany;j++) {
            		total2+=Math.pow((array[j][i]-mean), 2);
            	}
            	double error = Math.pow((long) (total2/(howMany-1)), (long) 0.5);
            	row.createCell(0).setCellValue(mean);
            	row.createCell(1).setCellValue(error);
            	row.createCell(2).setCellValue(arraysizes[i]);            	
            }
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
    }
}