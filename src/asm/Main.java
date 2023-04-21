/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package asm;

//import com.sun.source.tree.BreakTree;
import java.awt.CardLayout;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lib.XFile;
import model.busModel;
import model.TicketModel;

/**
 *
 * @author Win10
 */
public class Main extends javax.swing.JFrame {

    CardLayout cardLayout;
    DefaultComboBoxModel cbModel = new DefaultComboBoxModel();
    DefaultComboBoxModel cbTripModel = new DefaultComboBoxModel();
    DefaultTableModel tbModel;
    DefaultTableModel tbModel2;
    String filePath = "";
    String filePath2 = "";
    int id = 1;
    ArrayList<busModel> BusList;
    ArrayList<TicketModel> TicList;
    int currentRow = -1;

//    Map<String,String> menu;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        initTableBus();//ham initable 
        loadCbTime();

        tbBus.setDefaultEditor(Object.class, null);
        tbTotal.setDefaultEditor(Object.class, null);
        cardLayout = (CardLayout) contentPanel.getLayout();
        BusList = new ArrayList<>();

        filePath = "./src/model/SaveFile.dat";
        boolean file = loadFile();
        if (file) {
            fillToTable();
        } else {
            showMess("No info");
        }

        loadCbTrip();
        initTableTic();
        TicList = new ArrayList<>();
        filePath2 = "./src/model/SaveFile2.dat";
        boolean file2 = loadFileTic();
        if (file2) {
            fillToTableTic();
        } else {
            showMess("No info");
        }

        updateTotalPrice();

        this.setLocationRelativeTo(null);
    }

    private void initTableBus() {
        String[] columnNames = {"Bus ID", "Bus Linsense Plate ", "Trip", "Time", "Price"};
        tbModel2 = new DefaultTableModel(columnNames, 0);
        tbBus.setModel(tbModel2);
    }

    private void initTableTic() {
        String[] columnNames = {"Tic ID", "Bus ID ", "Customer Phone", "Price"};
        tbModel = new DefaultTableModel(columnNames, 0);
        tbTotal.setModel(tbModel);
    }

    private void loadCbTime() {
        String[] majorLst = {"Choose your time", "1h", "2h", "3h", "4h", "5h", "6h", "7h", "8h", "9h", "10h", "11h", "12h",
            "13h", "14h", "15h", "16h", "17h", "18h", "19h", "20h", "21h", "22h", "23h", "24h"};
        for (String string : majorLst) {
            cbModel.addElement(string);
        }
        cbTime.setModel(cbModel);
    }

    private void loadCbTrip() {
        cbTripModel.addElement("Choose your trip");
        for (busModel c : BusList) {
            cbTripModel.addElement(c.getTrip());
        }
        cbTrip.setModel(cbTripModel);
    }

    private void fillToTable() {
        tbModel2.setRowCount(0);
        for (busModel c : BusList) {
            Object[] row = new Object[]{c.getBusID(), c.getBusLicense(), c.getTrip(), c.getTime(), c.getPrice()};
            tbModel2.addRow(row);
        }
    }

    private void fillToTableTic() {
        tbModel.setRowCount(0);
        for (TicketModel t : TicList) {
            Object[] row = new Object[]{t.getTicID(), t.getBusCode(), t.getCustomerPhone(), t.getTicPrice()};
            tbModel.addRow(row);
        }
    }

    private void showMess(String mess) {
        JOptionPane.showMessageDialog(this, mess);
    }

    private boolean loadFile() {
        if (XFile.readObject(filePath) == null) {
            return false;
        }
        BusList = (ArrayList<busModel>) XFile.readObject(filePath);
//        TicList = (ArrayList<T>) XFile.readObject(filePath);
        return true;
    }

    private boolean loadFileTic() {
        if (XFile.readObject(filePath2) == null) {
            return false;
        }
        TicList = (ArrayList<TicketModel>) XFile.readObject(filePath2);
        return true;
    }

    private void updateTotalPrice() {
        int total = 0;

        for (int i = 0; i < tbTotal.getRowCount(); i++) {
            total += Integer.parseInt(tbTotal.getValueAt(i, 3).toString());
        }
        lblTotal.setText("" + total);

    }

    private void showBusDetail(int r) {
        String BusId = (String) tbBus.getValueAt(r, 0);
        txtBusId.setText(BusId);
        String BusLise = (String) tbBus.getValueAt(r, 1);
        txtBusLisense.setText(BusLise);
        String Trip = (String) tbBus.getValueAt(r, 2);
        txtBusTrip.setText(Trip);
        String Time = (String) tbBus.getValueAt(r, 3);
        cbTime.setSelectedItem(Time);
        Integer price = (Integer) tbBus.getValueAt(r, 4);
        txtBusPrice.setText(price.toString());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrTrip = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbTicket = new javax.swing.JLabel();
        lbBus = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        lbRevenue = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        Ticket = new javax.swing.JPanel();
        cbTrip = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtBusCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        btnBuy = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnTicClear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBusNumber = new javax.swing.JTextField();
        txtTicPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdYes = new javax.swing.JRadioButton();
        rdNo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txtSeat = new javax.swing.JTextField();
        Bus = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbBus = new javax.swing.JTable();
        txtBusPrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddBus = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSortByPrice = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtBusLisense = new javax.swing.JTextField();
        txtBusId = new javax.swing.JTextField();
        txtBusTrip = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        cbTime = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        Revenue = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTotal = new javax.swing.JTable();
        btnCheckOut = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 51));

        jLabel1.setFont(new java.awt.Font("VNI-Korin", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome");

        lbTicket.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        lbTicket.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTicket.setText("TICKET");
        lbTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbTicketMousePressed(evt);
            }
        });

        lbBus.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        lbBus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBus.setText("BUS");
        lbBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbBusMousePressed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 14)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lbRevenue.setBackground(new java.awt.Color(66, 143, 163));
        lbRevenue.setFont(new java.awt.Font("Lucida Calligraphy", 1, 14)); // NOI18N
        lbRevenue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRevenue.setText("Revenue in Day");
        lbRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbRevenueMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                    .addComponent(lbBus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTicket, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbBus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lbRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        contentPanel.setLayout(new java.awt.CardLayout());

        Ticket.setBackground(new java.awt.Color(255, 102, 51));

        cbTrip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbTrip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTripActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel4.setText("to");

        txtBusCode.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Bus code ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Phone");

        btnBuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Trip");

        jTextField4.setEditable(false);
        jTextField4.setText("TRA VINH");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setText("PRICE :");

        btnTicClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTicClear.setText("Clear");
        btnTicClear.setToolTipText("");
        btnTicClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicClearActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Bus number plate");

        txtBusNumber.setEditable(false);

        txtTicPrice.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Half Trip");

        btnGrTrip.add(rdYes);
        rdYes.setText("Yes");
        rdYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdYesActionPerformed(evt);
            }
        });

        btnGrTrip.add(rdNo);
        rdNo.setSelected(true);
        rdNo.setText("No");
        rdNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdNoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Available Seats");

        txtSeat.setEditable(false);

        javax.swing.GroupLayout TicketLayout = new javax.swing.GroupLayout(Ticket);
        Ticket.setLayout(TicketLayout);
        TicketLayout.setHorizontalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TicketLayout.createSequentialGroup()
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTicClear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TicketLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TicketLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(TicketLayout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbTrip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE))
                            .addGroup(TicketLayout.createSequentialGroup()
                                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(TicketLayout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(TicketLayout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtTicPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(TicketLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(rdYes, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtBusNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                            .addComponent(txtBusCode)
                                            .addComponent(txtSeat))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(16, 16, 16))
        );
        TicketLayout.setVerticalGroup(
            TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TicketLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBusNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdYes)
                    .addComponent(rdNo)
                    .addComponent(jLabel3))
                .addGap(61, 61, 61)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTicPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(TicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTicClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        contentPanel.add(Ticket, "Ticket");

        Bus.setBackground(new java.awt.Color(0, 255, 204));

        tbBus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Bus ID", "Bus Lisense Palate", "Trip", "Price"
            }
        ));
        tbBus.setColumnSelectionAllowed(true);
        tbBus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbBusMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbBus);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Trip");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Bus ID ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Bus Lisense Plate");

        btnAddBus.setText("Add");
        btnAddBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBusActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSortByPrice.setText("Sort by Price");
        btnSortByPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortByPriceActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Price");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Time ");

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BusLayout = new javax.swing.GroupLayout(Bus);
        Bus.setLayout(BusLayout);
        BusLayout.setHorizontalGroup(
            BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BusLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(BusLayout.createSequentialGroup()
                        .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BusLayout.createSequentialGroup()
                                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBusId, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                                    .addComponent(txtBusLisense))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBusPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(txtBusTrip)))
                            .addComponent(cbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(BusLayout.createSequentialGroup()
                        .addComponent(btnClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddBus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSortByPrice)
                        .addGap(18, 18, 18))))
        );
        BusLayout.setVerticalGroup(
            BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BusLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addComponent(txtBusId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBusLisense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(BusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBus)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSortByPrice)
                    .addComponent(btnClear))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPanel.add(Bus, "Bus");

        tbTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbTotal);

        btnCheckOut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCheckOut.setText("Check out");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("TOTAL :");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setText("...");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("VND");

        javax.swing.GroupLayout RevenueLayout = new javax.swing.GroupLayout(Revenue);
        Revenue.setLayout(RevenueLayout);
        RevenueLayout.setHorizontalGroup(
            RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RevenueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(83, 83, 83)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        RevenueLayout.setVerticalGroup(
            RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenueLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        contentPanel.add(Revenue, "Revenue");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbTicketMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbTicketMousePressed
        // TODO add your handling code here:
        cardLayout.show(contentPanel, "Ticket");
    }//GEN-LAST:event_lbTicketMousePressed

    private void lbBusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBusMousePressed
        // TODO add your handling code here:
        cardLayout.show(contentPanel, "Bus");
    }//GEN-LAST:event_lbBusMousePressed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "Do you want to exit", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            showMess("work Hard try Hard");
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void cbTripActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTripActionPerformed
        // TODO add your handling code here: 
        String selectedTrip = cbTrip.getSelectedItem().toString();
        for (busModel bus : BusList) {
            if (bus.getTrip().equals(selectedTrip)) {
                txtBusCode.setText(bus.getBusID());
                txtBusNumber.setText(bus.getBusLicense());
                txtSeat.setText(Integer.toString(bus.getSeat()));
                txtTicPrice.setText(Integer.toString(bus.getPrice()));
                rdNo.setSelected(true);
                break;
            }

        }
    }//GEN-LAST:event_cbTripActionPerformed

    private void lbRevenueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRevenueMousePressed
        // TODO add your handling code here:
        cardLayout.show(contentPanel, "Revenue");
    }//GEN-LAST:event_lbRevenueMousePressed

    private void btnAddBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBusActionPerformed
        // TODO add your handling code here:
        checkAddAction();
//        validatePrice();
//        AddBus();
        fillToTable();
        saveFileBus();
//        clearInput();   
    }//GEN-LAST:event_btnAddBusActionPerformed

    private void tbBusMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBusMousePressed
        // TODO add your handling code here:
        currentRow = tbBus.getSelectedRow();
        showBusDetail(currentRow);
    }//GEN-LAST:event_tbBusMousePressed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        checkUpdateAction();
//        updateBus();
        fillToTable();
        saveFileBus();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        DeleteBus();
        fillToTable();
        saveFileBus();
        clearInput();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSortByPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortByPriceActionPerformed
        // TODO add your handling code here:
        sortPrice();
        fillToTable();
        saveFileBus();
    }//GEN-LAST:event_btnSortByPriceActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        checkClear();
        clearInput();
    }//GEN-LAST:event_btnClearActionPerformed

    private void rdYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdYesActionPerformed
        // TODO add your handling code here:
        String selectedTrip = cbTrip.getSelectedItem().toString();
        for (busModel bus : BusList) {
            if (bus.getTrip().equals(selectedTrip)) {
                txtTicPrice.setText(Integer.toString(bus.getPrice() / 2));
            }
        }
    }//GEN-LAST:event_rdYesActionPerformed

    private void rdNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdNoActionPerformed
        // TODO add your handling code here:
        String selectedTrip = cbTrip.getSelectedItem().toString();
        for (busModel bus : BusList) {
            if (bus.getTrip().equals(selectedTrip)) {
                txtTicPrice.setText(Integer.toString(bus.getPrice()));
            }
        }
    }//GEN-LAST:event_rdNoActionPerformed

    private void btnTicClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicClearActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnTicClearActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        // TODO add your handling code here:
        checkPhone(); 
        BuyTicInfor();
//        AddTic();      
        fillToTableTic();
        updateTotalPrice();
        saveFileTic();

//        clearFields();
    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        // TODO add your handling code here:
        clearTotalTable();
//        printTotalToFile();
        updateTotalPrice();
    }//GEN-LAST:event_btnCheckOutActionPerformed
    private void clearTotalTable() {
        int choice = JOptionPane.showConfirmDialog(this, "You want to print the bill?");
        if (choice == JOptionPane.YES_OPTION) {
            printTotalToFile();
            TicList.clear();
            saveFileTic();
            fillToTableTic();
        }
    }

    private void printTotalToFile() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HHmmss");
        Date date = new Date();
        String fileName = "src/Total/Total_in_" + dateFormat.format(date) + ".txt";
        int total = 0;
        for (int i = 0; i < tbTotal.getRowCount(); i++) {
            total += Integer.parseInt(tbTotal.getValueAt(i, 3).toString());
        }
      
        try {
            PrintWriter writer = new PrintWriter(fileName, "UTF-8");
            writer.println("Total in day: " + total);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
private void checkPhone() {
    String phone = txtPhone.getText().trim();
    if (phone.length() != 10 || !phone.matches("\\d+")) {
        JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter a 10-digit number.");
        txtPhone.requestFocus();
    }
}
    private void BuyTicInfor() {
        String busCode = txtBusCode.getText();
        String busNumber = txtBusNumber.getText();
        String phone = txtPhone.getText();
        String trip = cbTrip.getSelectedItem().toString();
        String price = txtTicPrice.getText();
        String discount = rdYes.isSelected() ? "50%" : "No";

        if (busCode.isEmpty() || busNumber.isEmpty() || phone.isEmpty() || trip.equals("Choose your trip") || price.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all required information", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        AddTic();  
        clearFields();
        String message = "Bus Code: " + busCode + "\n"
                + "Bus License Plates: " + busNumber + "\n"
                + "Phone: " + phone + "\n"
                + "Trip: " + trip + "\n"
                + "Price: " + price + "\n"
                + "Discount: " + discount;
        JOptionPane.showMessageDialog(null, message, "Ticket Information", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        txtBusCode.setText("");
        txtBusNumber.setText("");
        txtPhone.setText("");
        cbTrip.setSelectedIndex(0);
        txtTicPrice.setText("");
        txtSeat.setText("");
        rdNo.setSelected(true);
    }

    private void clearInput() {

        txtBusId.setText("");
        txtBusLisense.setText("");
        txtBusTrip.setText("");
        cbTime.setSelectedIndex(0);
        txtBusPrice.setText("");

    }
    private boolean checkUpdateAction(){
        if (txtBusId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusLisense.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus License", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusTrip.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus Trip", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (cbTime.getSelectedItem().toString().equals("Choose your time")) {
            JOptionPane.showMessageDialog(null, "Please select the Bus Time", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus Price", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String price = txtBusPrice.getText().trim();
        try {
            double dPrice = Double.parseDouble(price);
            if (dPrice < 0) {
                JOptionPane.showMessageDialog(null, "Price cannot be negative", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        updateBus();
        return false;
    }
    private boolean checkAddAction() {
        if (txtBusId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus ID", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusLisense.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus License", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusTrip.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus Trip", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (cbTime.getSelectedItem().toString().equals("Choose your time")) {
            JOptionPane.showMessageDialog(null, "Please select the Bus Time", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        if (txtBusPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the Bus Price", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String price = txtBusPrice.getText().trim();
        try {
            double dPrice = Double.parseDouble(price);
            if (dPrice < 0) {
                JOptionPane.showMessageDialog(null, "Price cannot be negative", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price must be a number", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        AddBus();
        return true;
        
    }
//    private boolean validatePrice() {
//    String price = txtBusPrice.getText().trim();
//    try {
//        double dPrice = Double.parseDouble(price);
//        if (dPrice < 0) {
//            JOptionPane.showMessageDialog(null, "Price cannot be negative", "Error", JOptionPane.ERROR_MESSAGE);
//            return false;
//        }
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(null, "Price must be a number", "Error", JOptionPane.ERROR_MESSAGE);
//        return false;
//    }
//    return true;
//}

    private void checkClear() {
        if (txtBusId.getText().trim().isEmpty() && txtBusLisense.getText().trim().isEmpty() && txtBusTrip.getText().trim().isEmpty()
                && cbTime.getSelectedItem().toString().equals("Choose your time") && txtBusPrice.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "There is no information to clear.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

    }

    private void sortPrice() {
        Collections.sort(BusList, new Comparator<busModel>() {
            @Override
            public int compare(busModel o1, busModel o2) {
                return o1.getPrice() > o2.getPrice() ? -1 : 1;
            }
        });
//                Collections.sort(BusList, new Comparator<busModel>() {
//            @Override
//            public int compare(cadidae o1, cadidae o2) {
//                return o1.getAverage()>o2.getAverage()?-1:1;
//            }
//        });
    }

    private void DeleteBus() {
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure?");
        if (choice == JOptionPane.YES_OPTION) {
            int selectedIndex = tbBus.getSelectedRow();
            BusList.remove(selectedIndex);
//        resetForm();
//        cbMajor.setSelectedItem("Choose your major");
        }
    }

    private void updateBus() {
        busModel b = BusList.get(currentRow);
        b.setBusID(txtBusId.getText());
        b.setBusLicense(txtBusLisense.getText());
        b.setTrip(txtBusTrip.getText());
        b.setTime(cbTime.getSelectedItem().toString());
//        b.setPrice(txt);
        b.setPrice(Integer.parseInt(txtBusPrice.getText()));
    }

    private void AddBus() {

        String BusId = txtBusId.getText();
        String busLicense = txtBusLisense.getText();
        String trip = txtBusTrip.getText();
        String time = cbTime.getSelectedItem().toString();
        int price = Integer.parseInt(txtBusPrice.getText());

        busModel c = new busModel(BusId, busLicense, 30, time, trip, price);
        BusList.add(c);
        clearInput(); 
    }

    private void AddTic() {

        for (TicketModel t : TicList) {
            if (t.getTicID() >= id) {
                id = t.getTicID() + 1;
            }
        }

        String busID = txtBusCode.getText();
        int price = Integer.parseInt(txtTicPrice.getText());
        int customerPhone = Integer.parseInt(txtPhone.getText());

        TicketModel t = new TicketModel(id, customerPhone, price, busID);
        TicList.add(t);
    }

    private void saveFileBus() {
//        System.out.println(BusList.size());
        XFile.writeObject(filePath, BusList);
//        XFile.writeObject(filePath, TicList);
    }

    private void saveFileTic() {
        XFile.writeObject(filePath2, TicList);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Bus;
    private javax.swing.JPanel Revenue;
    private javax.swing.JPanel Ticket;
    private javax.swing.JButton btnAddBus;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.ButtonGroup btnGrTrip;
    private javax.swing.JButton btnSortByPrice;
    private javax.swing.JButton btnTicClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbTime;
    private javax.swing.JComboBox<String> cbTrip;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lbBus;
    private javax.swing.JLabel lbRevenue;
    private javax.swing.JLabel lbTicket;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton rdNo;
    private javax.swing.JRadioButton rdYes;
    private javax.swing.JTable tbBus;
    private javax.swing.JTable tbTotal;
    private javax.swing.JTextField txtBusCode;
    private javax.swing.JTextField txtBusId;
    private javax.swing.JTextField txtBusLisense;
    private javax.swing.JTextField txtBusNumber;
    private javax.swing.JTextField txtBusPrice;
    private javax.swing.JTextField txtBusTrip;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSeat;
    private javax.swing.JTextField txtTicPrice;
    // End of variables declaration//GEN-END:variables
}
