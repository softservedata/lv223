package com.softserve.edu.opencart.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils implements IExternalData {
	private static final int MAIN_BY_NUMBER_SHEET = 0;

	public List<List<String>> getAllCells(String connection) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		InputStream inputStream = null;
		DataFormatter formatter = new DataFormatter();
		// For *.xls files
		// HSSFWorkbook workBook;
		// For *.xlsx files
		// XSSFWorkbook workBook = null;
		XSSFWorkbook workBook = null;
		Sheet sheet = null;
		try {
			// System.out.println("filename=" + connection);
			inputStream = new FileInputStream(connection);
			// workBook = new HSSFWorkbook(inputStream);
			workBook = new XSSFWorkbook(inputStream);
			// sheet = (new XSSFWorkbook(inputStream)).getSheetAt(0);
			sheet = workBook.getSheetAt(MAIN_BY_NUMBER_SHEET);
		} catch (FileNotFoundException e) {
			throw new GeneralException(String.format(FILE_NOT_FOUND_EXCEPTION, connection));
		} catch (IOException e) {
			throw new GeneralException(String.format(FILE_NOT_READ_EXCEPTION, connection));
		}
		Iterator<Row> rowsIterator = sheet.iterator();
		while (rowsIterator.hasNext()) {
			Row row = rowsIterator.next();
			Iterator<Cell> cellsIterator = row.iterator();
			List<String> allRowCells = new ArrayList<String>();
			//System.out.println("\n ***allRowCells = ");
			while (cellsIterator.hasNext()) {
				// For Old Version of XSSFWorkbook
				// String cell = cellsIterator.next().getStringCellValue();
				// For New Version of  XSSFWorkbook
				String cell = formatter.formatCellValue(cellsIterator.next());
				// allCells.add(cellsIterator.next().getStringCellValue());
				allRowCells.add(cell);
				//System.out.print("  " + cell);
			}
			allCells.add(allRowCells);
			//System.out.println();
		}
		if (workBook != null) {
			try {
				workBook.close();
			} catch (IOException e) {
				throw new GeneralException(String.format(FILE_NOT_CLOSE_EXCEPTION, connection), e);
			}
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				throw new GeneralException(String.format(FILE_NOT_CLOSE_EXCEPTION, connection), e);
			}
		}
		return allCells;
	}

}
