package com.epic.techtalk;

import com.epic.techtalk.dto.Invoice;
import com.epic.techtalk.dto.InvoiceItem;
import com.epic.techtalk.util.DBUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SmallerFunction {
    private Connection connection = null;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public void saveAndPrintInvoice(Invoice invoice) {
        try {
            connection = DBUtil.getConnectionInstance();
            connection.setAutoCommit(false);
            String invoiceSQL = "INSERT INTO INVOICE (INVOICENO, DATEOFINVOICED, TOTAL, DISCOUNT, NETTOTAL)"+
                    "VALUES(?, ?, ?, ?, ?)";

            Date dateInvoiced = invoice.getDateInvoiced();
            String formattedDateInvoiced = SIMPLE_DATE_FORMAT.format(dateInvoiced);

            PreparedStatement psInvoice = connection.prepareStatement(invoiceSQL);
            psInvoice.setString(1, invoice.getInvoiceNo());
            psInvoice.setString(2, formattedDateInvoiced);
            psInvoice.setDouble(3, invoice.getTotal());
            psInvoice.setDouble(4, invoice.getDiscount());
            psInvoice.setDouble(5, invoice.getNetTotal());

            boolean executePsInvoice = psInvoice.execute();
            if (executePsInvoice){
                List<InvoiceItem> invoiceItems = invoice.getInvoiceItems();
                for (int _index = 0; _index < invoiceItems.size(); _index++){
                    InvoiceItem invoiceItem = invoiceItems.get(_index);
                    try {
                                String invoiceItemSQL = "INSERT INTO INVOICEITEM (PRODUCTCODE, UNITPRICE, QUANTITY, DATEPURCHASED)" +
                                        "VALUES(?, ?, ?, ?, ?)";

                                Date datePurchased = invoiceItem.getDatePurchased();
                                String formattedDatePurchased = SIMPLE_DATE_FORMAT.format(datePurchased);

                                PreparedStatement psInvoiceItem = connection.prepareStatement(invoiceItemSQL);
                                psInvoiceItem.setString(1, invoiceItem.getProductCode());
                                psInvoiceItem.setDouble(2, invoiceItem.getUnitPrice());
                                psInvoiceItem.setInt(3, invoiceItem.getQuantity());
                                psInvoiceItem.setString(4, formattedDatePurchased);

                        boolean executePsInvoiceItem = psInvoiceItem.execute();


                            } catch (SQLException ex){
                                if (connection != null){
                                    try{
                                        connection.rollback();
                                        connection.setAutoCommit(true);
                                    }catch (SQLException e){
                                        e.printStackTrace();
                                    }
                                    break;
                                }
                            }
                        }

                try {
                    String path = "D:/epic/techtalk/session1/invoice.jrxml";
                    JasperReport jasperReport = JasperCompileManager.compileReport(path);

                    Map<String, Object> params = new HashMap<>();
                    params.put("invoiceNo",invoice.getInvoiceNo());
                    params.put("dateInvoiced",invoice.getDateInvoiced());
                    params.put("total",invoice.getTotal());
                    params.put("discount",invoice.getDiscount());
                    params.put("netTotal",invoice.getNetTotal());

                    JRBeanCollectionDataSource invoiceItemsDataSet = new JRBeanCollectionDataSource(invoiceItems);
                    params.put("invoiceItemsDataSet", invoiceItemsDataSet);

                    JREmptyDataSource dataSource = new JREmptyDataSource();

                    JasperPrint print = JasperFillManager.fillReport(jasperReport, params, dataSource);

                    File pdf = File.createTempFile(invoice.getInvoiceNo() + "_"
                            + SIMPLE_DATE_FORMAT.format(new Date()), ".pdf");
                    FileOutputStream pdfOutputStream = new FileOutputStream(pdf);
                    JasperExportManager.exportReportToPdfStream(print, pdfOutputStream);
                } catch (JRException | IOException ex){
                    ex.printStackTrace();
                }


            }

        }catch (SQLException | ClassNotFoundException ex) {
            if (connection != null){
                try{
                    connection.rollback();
                    connection.setAutoCommit(true);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

        }

    }
}
