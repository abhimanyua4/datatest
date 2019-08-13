import org.apache.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

class datatest
{
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main (String[] args) throws IOException
	{
		String filepath = "C:\\Users\\abhimanyua295\\Documents\\Test Project";
		String filename = "test1.xlsx";
		String password = "abhi1234";
		FileInputStream file = new FileInputStream(new File(filepath+"\\"+filename));
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		int maxlen = 15;
		int spacecnt = 0;
		while(rowIterator.hasNext())
		{
			Row row = rowIterator.next();
			
			Iterator<Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();
				switch(cell.getCellType())
				{
				case Cell.CELL_TYPE_NUMERIC:
					int i = (int)cell.getNumericCellValue();
					System.out.print(i+"\t");
					break;
				case Cell.CELL_TYPE_STRING:
					String s1 = cell.getStringCellValue();
					int len1 = s1.length();
					if(len1 <= maxlen)
					{
						spacecnt = maxlen - len1;
					}
					System.out.print(s1);
					for(int j = 1;j<=spacecnt;j++)
					{
						System.out.print(" ");
					}
					break;
				}
			}
			System.out.println("");
		}
		file.close();
		
	}
}