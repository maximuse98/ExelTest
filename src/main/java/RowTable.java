import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RowTable {
    private SimpleIntegerProperty rowNumber;
    private SimpleStringProperty label1;
    private SimpleStringProperty label2;
    private SimpleStringProperty label3;
    private SimpleStringProperty label4;
    private SimpleStringProperty label5;
    private SimpleStringProperty label6;
    private SimpleStringProperty label7;
    private SimpleStringProperty label8;
    private SimpleStringProperty label9;
    private SimpleStringProperty label10;
    private SimpleStringProperty label11;
    private SimpleStringProperty label12;
    private SimpleStringProperty label13;
    private SimpleStringProperty label14;
    private SimpleStringProperty label15;
    private SimpleStringProperty label16;
    private SimpleStringProperty label17;

    public RowTable(int rowNumber, String label1, String label2, String label3, String label4, String label5, String label6, String label7, String label8, String label9, String label10, String label11, String label12, String label13, String label14, String label15, String label16, String label17) {
        this.rowNumber = new SimpleIntegerProperty(rowNumber);
        this.label1 = new SimpleStringProperty(label1);
        this.label2 = new SimpleStringProperty(label2);
        this.label3 = new SimpleStringProperty(label3);
        this.label4 = new SimpleStringProperty(label4);
        this.label5 = new SimpleStringProperty(label5);
        this.label6 = new SimpleStringProperty(label6);
        this.label7 = new SimpleStringProperty(label7);
        this.label8 = new SimpleStringProperty(label8);
        this.label9 = new SimpleStringProperty(label9);
        this.label10 = new SimpleStringProperty(label10);
        this.label11 = new SimpleStringProperty(label11);
        this.label12 = new SimpleStringProperty(label12);
        this.label13 = new SimpleStringProperty(label13);
        this.label14 = new SimpleStringProperty(label14);
        this.label15 = new SimpleStringProperty(label15);
        this.label16 = new SimpleStringProperty(label16);
        this.label17 = new SimpleStringProperty(label17);
    }

    public int getRowNumber() {
        return rowNumber.get();
    }

    public SimpleIntegerProperty rowNumberProperty() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber.set(rowNumber);
    }

    public String getLabel1() {
        return label1.get();
    }

    public SimpleStringProperty label1Property() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1.set(label1);
    }

    public String getLabel2() {
        return label2.get();
    }

    public SimpleStringProperty label2Property() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2.set(label2);
    }

    public String getLabel3() {
        return label3.get();
    }

    public SimpleStringProperty label3Property() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3.set(label3);
    }

    public String getLabel4() {
        return label4.get();
    }

    public SimpleStringProperty label4Property() {
        return label4;
    }

    public void setLabel4(String label4) {
        this.label4.set(label4);
    }

    public String getLabel5() {
        return label5.get();
    }

    public SimpleStringProperty label5Property() {
        return label5;
    }

    public void setLabel5(String label5) {
        this.label5.set(label5);
    }

    public String getLabel6() {
        return label6.get();
    }

    public SimpleStringProperty label6Property() {
        return label6;
    }

    public void setLabel6(String label6) {
        this.label6.set(label6);
    }

    public String getLabel7() {
        return label7.get();
    }

    public SimpleStringProperty label7Property() {
        return label7;
    }

    public void setLabel7(String label7) {
        this.label7.set(label7);
    }

    public String getLabel8() {
        return label8.get();
    }

    public SimpleStringProperty label8Property() {
        return label8;
    }

    public void setLabel8(String label8) {
        this.label8.set(label8);
    }

    public String getLabel9() {
        return label9.get();
    }

    public SimpleStringProperty label9Property() {
        return label9;
    }

    public void setLabel9(String label9) {
        this.label9.set(label9);
    }

    public String getLabel10() {
        return label10.get();
    }

    public SimpleStringProperty label10Property() {
        return label10;
    }

    public void setLabel10(String label10) {
        this.label10.set(label10);
    }

    public String getLabel11() {
        return label11.get();
    }

    public SimpleStringProperty label11Property() {
        return label11;
    }

    public void setLabel11(String label11) {
        this.label11.set(label11);
    }

    public String getLabel12() {
        return label12.get();
    }

    public SimpleStringProperty label12Property() {
        return label12;
    }

    public void setLabel12(String label12) {
        this.label12.set(label12);
    }

    public String getLabel13() {
        return label13.get();
    }

    public SimpleStringProperty label13Property() {
        return label13;
    }

    public void setLabel13(String label13) {
        this.label13.set(label13);
    }

    public String getLabel14() {
        return label14.get();
    }

    public SimpleStringProperty label14Property() {
        return label14;
    }

    public void setLabel14(String label14) {
        this.label14.set(label14);
    }

    public String getLabel15() {
        return label15.get();
    }

    public SimpleStringProperty label15Property() {
        return label15;
    }

    public void setLabel15(String label15) {
        this.label15.set(label15);
    }

    public String getLabel16() {
        return label16.get();
    }

    public SimpleStringProperty label16Property() {
        return label16;
    }

    public void setLabel16(String label16) {
        this.label16.set(label16);
    }

    public String getLabel17() {
        return label17.get();
    }

    public SimpleStringProperty label17Property() {
        return label17;
    }

    public void setLabel17(String label17) {
        this.label17.set(label17);
    }
}

