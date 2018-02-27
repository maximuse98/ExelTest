
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainController implements Initializable {
    @FXML
    public Button change;
    @FXML
    public Button delete;
    @FXML
    public Button buttonDirectory;
    @FXML
    public Button okButton;
    @FXML
    public Button findButton;
    @FXML
    public Button addButton;
    @FXML
    public TextField labelDirectory;
    @FXML
    public TextField mainRowField;
    @FXML
    public TableView tableMain;
    @FXML
    public ImageView imageStatus;
    @FXML
    public Label Label1;
    @FXML
    public Label Label2;
    @FXML
    public Label Label3;
    @FXML
    public Label Label4;
    @FXML
    public Label Label5;
    @FXML
    public Label Label6;
    @FXML
    public Label Label7;
    @FXML
    public Label Label8;
    @FXML
    public Label Label9;
    @FXML
    public Label Label10;
    @FXML
    public Label Label11;
    @FXML
    public Label Label12;
    @FXML
    public Label Label13;
    @FXML
    public Label Label14;
    @FXML
    public Label Label15;
    @FXML
    public Label Label16;
    @FXML
    public Label Label17;
    @FXML
    public Label Label18;
    @FXML
    public Label Label19;
    @FXML
    public Label Label20;
    @FXML
    public TextField Field1;
    @FXML
    public TextField Field2;
    @FXML
    public TextField Field3;
    @FXML
    public TextField Field4;
    @FXML
    public TextField Field5;
    @FXML
    public TextField Field6;
    @FXML
    public TextField Field7;
    @FXML
    public TextField Field8;
    @FXML
    public TextField Field9;
    @FXML
    public TextField Field10;
    @FXML
    public TextField Field11;
    @FXML
    public TextField Field12;
    @FXML
    public TextField Field13;
    @FXML
    public TextField Field14;
    @FXML
    public TextField Field15;
    @FXML
    public TextField Field16;
    @FXML
    public TextField Field17;
    @FXML
    public TextField Field18;
    @FXML
    public TextField Field19;
    @FXML
    public TextField Field20;

    private Map<Integer, TextField> fields = new TreeMap();
    private Map<Integer, Label> labels = new TreeMap();
    private Map<Integer, TableColumn> columns = new TreeMap();
    private int mainRow;
    private RowTable chosenRow;
    private List<String> l = new ArrayList();
    private ObservableList<RowTable> data = FXCollections.observableArrayList();
    private File selectedDirectory;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buttonDirectory.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser directoryChooser = new FileChooser();
                selectedDirectory =
                        directoryChooser.showOpenDialog(null);

                if(selectedDirectory == null){
                    labelDirectory.setText("No Directory selected");
                }else{
                    labelDirectory.setText(selectedDirectory.getAbsolutePath());
                }
            }
        });
        fields.put(1,Field1);
        fields.put(2,Field2);
        fields.put(3,Field3);
        fields.put(4,Field4);
        fields.put(5,Field5);
        fields.put(6,Field6);
        fields.put(7,Field7);
        fields.put(8,Field8);
        fields.put(9,Field9);
        fields.put(10,Field10);
        fields.put(11,Field11);
        fields.put(12,Field12);
        fields.put(13,Field13);
        fields.put(14,Field14);
        fields.put(15,Field15);
        fields.put(16,Field16);
        fields.put(17,Field17);
        labels.put(1,Label1);
        labels.put(2,Label2);
        labels.put(3,Label3);
        labels.put(4,Label4);
        labels.put(5,Label5);
        labels.put(6,Label6);
        labels.put(7,Label7);
        labels.put(8,Label8);
        labels.put(9,Label9);
        labels.put(10,Label10);
        labels.put(11,Label11);
        labels.put(12,Label12);
        labels.put(13,Label13);
        labels.put(14,Label14);
        labels.put(15,Label15);
        labels.put(16,Label16);
        labels.put(17,Label17);
    }

    public void onDirectory(){
        new DirectoryChooserFX();
    }

    public void onOk() throws IOException {
        tableMain.getColumns().clear();
        try {
            mainRow = Integer.parseInt(mainRowField.getText())-1;
            FileInputStream ExcelFileToRead = new FileInputStream(selectedDirectory);
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row = sheet.getRow(mainRow);
            XSSFCell cell;
            Iterator cells = row.cellIterator();
            int i=1;
            TableColumn column = new TableColumn("Строка");
            columns.put(0, column);
            tableMain.getColumns().add(column);
            //tableMain.getColumns().add(column);
            while (cells.hasNext() && i!=18) {
                    cell=(XSSFCell) cells.next();
                    TextField textField = fields.get(i);
                    Label label = labels.get(i);
                    TableColumn tableColumn = new TableColumn(cell.getStringCellValue());
                    tableColumn.setMinWidth(140);
                    columns.put(i,tableColumn);
                    i++;
                    label.setVisible(true); //t.setVisible(true); t.setText("");
                    label.setText(cell.getStringCellValue());
                    textField.setText("");
                    String text = label.getText();
                    if(!label.getText().isEmpty()) textField.setVisible(true);
                    //tableMain.getColumns().add(tableColumn);
                    tableMain.getColumns().add(tableColumn);
            }
            ExcelFileToRead.close();
            addButton.setVisible(true);
            findButton.setVisible(true);
            this.setNullField();
            imageStatus.setImage(new Image(getClass().getResource("/images/ok.png").toString(), 512, 512, true, true));
        }
        catch(Exception e){
            imageStatus.setImage(new Image(getClass().getResource("/images/wrong.png").toString(), 512, 512, true, true));
            e.printStackTrace();
        }
    }

    public void add() throws IOException {
        FileInputStream file  =  new FileInputStream(selectedDirectory );
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);

        //This data needs to be written (Object[])
        int nullRow = this.getNullRow();
        Row row = sheet.getRow(nullRow);
        Iterator cells = row.cellIterator();
        String[] objArr = new String[fields.size()];
        for(int i=0;i<labels.size();i++){
            objArr[i]=fields.get(i+1).getText();
        }
        //RowTable rowTable = new RowTable(row.getRowNum(),Integer.parseInt(Field1.getText()), Field2.getText(), Field3.getText(), Field4.getText(), Field5.getText(), Field6.getText(), Field7.getText(), Field8.getText(), Field9.getText(), Field10.getText(), Field11.getText(), Field12.getText(), Field13.getText(), Field14.getText(), Field15.getText(), Field16.getText(), Field17.getText());
        //data.add(rowTable);
        //this.setToTable(data);
        for (String obj : objArr) {
            XSSFCell cell = (XSSFCell) cells.next();
                cell.setCellValue(obj);
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(selectedDirectory);
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
            //this.onOk();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        this.setNullField();
    }

    public int getNullRow() throws IOException {
        XSSFRow row;
        XSSFCell cell;
        XSSFWorkbook workbook = new XSSFWorkbook(selectedDirectory.getAbsolutePath());
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        for(int i=0;i<=mainRow;i++){
            rows.next();
        }
        while (rows.hasNext()) {
            row=(XSSFRow) rows.next();
            //if(row == null) return row.getRowNum();
            Iterator cells = row.cellIterator();
            int i=0;
            while (cells.hasNext()) {
                try{
                    cell=(XSSFCell) cells.next();
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING ) {
                        if(cell.getStringCellValue().equals("")) {i++;}
                    }
                    else if(cell.getCellType()== XSSFCell.CELL_TYPE_BLANK) {i++;}
                    else {break;}
                    //else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){break;}
                    //else if (!cell.getStringCellValue().equals("")) { break; }
                    //else { i++; }
                    //System.out.print(cell.getCellType()+" ");
                }
                catch (Exception e){ break;}
            }
            System.out.println();
            if(i>=labels.size() && row.getRowNum()>mainRow) return row.getRowNum();
        }
        return 0;
    }

    public void setToTable(ObservableList data){
        columns.get(0).setCellValueFactory(new PropertyValueFactory<RowTable, Integer>("rowNumber"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label1"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label2"));
        columns.get(3).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label3"));
        columns.get(4).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label4"));
        columns.get(5).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label5"));
        columns.get(6).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label6"));
        columns.get(7).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label7"));
        columns.get(8).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label8"));
        columns.get(9).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label9"));
        columns.get(10).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label10"));
        columns.get(11).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label11"));
        columns.get(12).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label12"));
        columns.get(13).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label13"));
        columns.get(14).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label14"));
        columns.get(15).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label15"));
        columns.get(16).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label16"));
        columns.get(17).setCellValueFactory(new PropertyValueFactory<RowTable, String>("label17"));
        tableMain.setItems(data);
    }

    public void onFound() throws IOException {
        data = FXCollections.observableArrayList();
        l.add(fields.get(1).getText());
        l.add(fields.get(2).getText());
        l.add(fields.get(3).getText());
        l.add(fields.get(4).getText());
        l.add(fields.get(5).getText());
        l.add(fields.get(6).getText());
        l.add(fields.get(7).getText());
        l.add(fields.get(8).getText());
        l.add(fields.get(9).getText());
        l.add(fields.get(10).getText());
        l.add(fields.get(11).getText());
        l.add(fields.get(12).getText());
        l.add(fields.get(13).getText());
        l.add(fields.get(14).getText());
        l.add(fields.get(15).getText());
        l.add(fields.get(16).getText());
        l.add(fields.get(17).getText());
        FileInputStream ExcelFileToRead = new FileInputStream(selectedDirectory);
        try {
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            XSSFRow row;
            XSSFCell cell;
            for(int i=0;i<=mainRow;i++){
                rows.next();
            }
            while (rows.hasNext()) {
                row=(XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                int i=1;
                boolean eq = true;
                List<String> cls = new ArrayList<>();
                while (cells.hasNext()&& i!=18) {
                    cell=(XSSFCell) cells.next();
                    //cls.add(cell.getStringCellValue());
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
                    {
                        cls.add(cell.getStringCellValue());
                        if(cell.getStringCellValue().contains(fields.get(i).getText())) { i++; continue;}
                        else {eq=false; break;}
                    }
                    else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
                    {
                        if (DateUtil.isCellDateFormatted(cell)){
                            Date dateCellValue = cell.getDateCellValue();
                            String newstring = new SimpleDateFormat("dd-MM-yyyy").format(dateCellValue);
                            System.out.println(newstring);
                            String s = newstring.replaceAll("-", ".");
                            cls.add(s);
                            if(s.contains(fields.get(i).getText())) { i++; continue;}
                            else {eq=false; break;}
                        }
                        cls.add(Double.toString(cell.getNumericCellValue()).replaceAll(".0",""));
                        if(Double.toString(cell.getNumericCellValue()).contains(fields.get(i).getText())) { i++; continue;}
                        else {eq=false; break;}
                    }
                    else if(!fields.get(i).getText().isEmpty()) {eq=false; break;}
                    else {cls.add(""); i++;}
                }
                if(eq && !cls.isEmpty()) data.add(new RowTable(row.getRowNum()+1,cls.get(0),cls.get(1),cls.get(2),cls.get(3),cls.get(4),cls.get(5),cls.get(6),cls.get(7),cls.get(8),cls.get(9),cls.get(10),cls.get(11),cls.get(12),cls.get(13),cls.get(14),cls.get(15),cls.get(16)));
            }
            this.setToTable(data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        this.setNullField();
    }

    public void onListClick(){
        if(tableMain.getSelectionModel().getSelectedItem()==null) return;
        try {
            chosenRow = (RowTable) tableMain.getSelectionModel().getSelectedItem();
            delete.setVisible(true);
            change.setVisible(true);
            Field1.setText(chosenRow.getLabel1());
            Field2.setText(chosenRow.getLabel2());
            Field3.setText(chosenRow.getLabel3());
            Field4.setText(chosenRow.getLabel4());
            Field5.setText(chosenRow.getLabel5());
            Field6.setText(chosenRow.getLabel6());
            Field7.setText(chosenRow.getLabel7());
            Field8.setText(chosenRow.getLabel8());
            Field9.setText(chosenRow.getLabel9());
            Field10.setText(chosenRow.getLabel10());
            Field11.setText(chosenRow.getLabel11());
            Field12.setText(chosenRow.getLabel12());
            Field13.setText(chosenRow.getLabel13());
            Field14.setText(chosenRow.getLabel14());
            Field15.setText(chosenRow.getLabel15());
            Field16.setText(chosenRow.getLabel16());
            Field17.setText(chosenRow.getLabel17());
        }
        catch (Exception e){ }
    }

    public void onDelete() throws IOException {
        int rowIndex = chosenRow.getRowNumber()-1;
        FileInputStream file  =  new FileInputStream(selectedDirectory );
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        XSSFRow row;
        XSSFCell cell;
        for(int i=0; i<rowIndex;i++){
            rows.next();
        }
        row = (XSSFRow) rows.next();
        Iterator cells = row.cellIterator();
        int i=1;
        while (cells.hasNext()&& i!=18) {
            cell=(XSSFCell) cells.next();
            cell.setCellValue("");
            i++;
        }

        this.setToTable(data);
        OutputStream out = new FileOutputStream(selectedDirectory);
        wb.write(out);
        out.flush();
        out.close();
        file.close();

        data.remove(chosenRow);
        chosenRow=null;
        //this.setToTable(data);
        delete.setVisible(false);
        change.setVisible(false);
        //tableMain.refresh();
        this.refreshTable();
        this.setNullField();
    }

    public void onChange() throws IOException {
        int rowIndex = chosenRow.getRowNumber()-1;
        FileInputStream file  =  new FileInputStream(selectedDirectory );
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        Iterator rows = sheet.rowIterator();
        XSSFRow row;
        XSSFCell cell;
        for(int i=0; i<rowIndex;i++){
            rows.next();
        }
        row = (XSSFRow) rows.next();
        Iterator cells = row.cellIterator();
            int i=1;
            while (cells.hasNext()&& i!=18) {
                cell=(XSSFCell) cells.next();
                cell.setCellValue(fields.get(i).getText());
                i++;
            }

        this.setToTable(data);
        OutputStream out = new FileOutputStream(selectedDirectory);
        wb.write(out);
        out.flush();
        out.close();
        file.close();

        delete.setVisible(false);
        change.setVisible(false);
        this.refreshTable();
        this.setNullField();
    }

    public void refreshTable() throws FileNotFoundException {
        data = FXCollections.observableArrayList();
        FileInputStream ExcelFileToRead = new FileInputStream(selectedDirectory);
        try {
            XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFSheet sheet = wb.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            XSSFRow row;
            XSSFCell cell;
            for(int i=0;i<=mainRow;i++){
                rows.next();
            }
            while (rows.hasNext()) {
                row = (XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                int i = 0;
                boolean eq = true;
                List<String> cls = new ArrayList<>();
                while (cells.hasNext() && i != 17) {
                    cell = (XSSFCell) cells.next();
                    //cls.add(cell.getStringCellValue());
                    if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        cls.add(cell.getStringCellValue());
                        if (cell.getStringCellValue().contains(l.get(i))) {
                            i++;
                            continue;
                        } else {
                            eq = false;
                            break;
                        }
                    } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                        if (DateUtil.isCellDateFormatted(cell)) {
                            Date dateCellValue = cell.getDateCellValue();
                            String newstring = new SimpleDateFormat("dd-MM-yyyy").format(dateCellValue);
                            System.out.println(newstring);
                            cls.add(newstring.replaceAll("-", "."));
                            if (newstring.contains(l.get(i))) { i++;continue; }
                            else { eq = false; break; }
                        }
                        cls.add(Double.toString(cell.getNumericCellValue()).replaceAll(".0", ""));
                        if (Double.toString(cell.getNumericCellValue()).contains(l.get(i))) { i++;continue; }
                        else { eq = false;break; }
                    } else if (!l.get(i).isEmpty()) { eq = false;break;
                    } else { cls.add("");i++;}
                }
                if (eq && !cls.isEmpty()) data.add(new RowTable(row.getRowNum() + 1, cls.get(0), cls.get(1), cls.get(2), cls.get(3), cls.get(4), cls.get(5), cls.get(6), cls.get(7), cls.get(8), cls.get(9), cls.get(10), cls.get(11), cls.get(12), cls.get(13), cls.get(14), cls.get(15), cls.get(16)));
            }
            this.setToTable(data);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void setNullField(){
        Field1.setText("");
        Field2.setText("");
        Field3.setText("");
        Field4.setText("");
        Field5.setText("");
        Field6.setText("");
        Field7.setText("");
        Field8.setText("");
        Field9.setText("");
        Field10.setText("");
        Field11.setText("");
        Field12.setText("");
        Field13.setText("");
        Field14.setText("");
        Field15.setText("");
        Field16.setText("");
        Field17.setText("");
        Field18.setText("");
        Field19.setText("");
        Field20.setText("");
    }
}
