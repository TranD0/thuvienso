  import javax.swing.*;
  import javax.swing.table.DefaultTableModel;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.io.*;
  import java.util.LinkedList;
  import java.util.List;
  import java.util.Vector;

  public class Giaodien extends JFrame {

          public Giaodien() {
              this.setTitle("Thư viện số");
              this.setSize(1500, 750);
              this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              this.setLocationRelativeTo(null);

              JPanel panel = new JPanel();
              panel.setLayout(null);


              //tieu de
              JLabel lbtieude= new JLabel("Thư viện số");
              lbtieude.setBounds(650,20,250,45);
              lbtieude.setFont(new Font("Tahoma",Font.BOLD,40));
              lbtieude.setForeground(Color.PINK);
              panel.add(lbtieude);
              //
              JLabel lbID= new JLabel("Mã sách:");
              lbID.setBounds(120,425,80,25);
              JTextField txID = new JTextField();
              txID.setBounds(200,425,200,25);
              panel.add(lbID);
              panel.add(txID);
              //
              JLabel lbtens= new JLabel("Tên sách:");
              lbtens.setBounds(120,450,80,25);
              JTextField txtens = new JTextField();
              txtens.setBounds(200,450,200,25);
              panel.add(lbtens);
              panel.add(txtens);
              //
              JLabel lbtype= new JLabel("Thể loại:");
              lbtype.setBounds(120,475,80,25);
              JTextField txtype = new JTextField();
              txtype.setBounds(200,475,200,25);
              panel.add(lbtype);
              panel.add(txtype);
              //
              JLabel lbtacgia= new JLabel("Tác giả:");
              lbtacgia.setBounds(120,500,80,25);
              JTextField txttaciga = new JTextField();
              txttaciga.setBounds(200,500,200,25);
              panel.add(lbtacgia);
              panel.add(txttaciga);
              //noi dung
              JLabel lbnoidung= new JLabel("Nội dung:");
              lbnoidung.setBounds(900,100,80,25);
               JTextArea txtnoidung = new JTextArea();
              //txtnoidung.setBounds(900,130,500,500);
              JScrollPane nd= new JScrollPane(txtnoidung,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
              panel.add(lbnoidung);
              nd.setBounds(900,130,500,500);
              panel.add(nd);
              //panel.add(txtnoidung);

              //bao loi
              JLabel lbloi= new JLabel();
              lbloi.setBounds(120,550,80,25);
              lbloi.setForeground(Color.RED);
              panel.add(lbloi);

//              // Column Names
              String[] columnNames = { "Mã sách", "tên sách", "thể loại","tác giả"};
            String[] row =new String[4];
              // Initializing the JTable data, columnNames
              JTable jTable = new JTable();
              DefaultTableModel model =new DefaultTableModel();
              model.setColumnIdentifiers(columnNames);
              jTable.setModel(model);
              //jcrollpanel
              JScrollPane sp = new JScrollPane();
              sp.setBounds(100,100,400,300);
              sp.add(jTable);
              sp.setViewportView(jTable);
              panel.add(sp);

              //button
              JButton jbtLod = new JButton("Load");
              jbtLod.setFont(new Font("Tahoma",Font.BOLD,10));
              jbtLod.setFocusable(false);//tat vien xung quanh button
              jbtLod.setBounds(650,150,90,25);
              jbtLod.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      DefaultTableModel model = (DefaultTableModel) jTable.getModel();
                        txtnoidung.setText(null);
                      model.setRowCount(0);
                      String fileName = "sach.txt";

                      try {
                          BufferedReader in = new BufferedReader( new FileReader( fileName  ) );

                          row[0] = in.readLine();
                          row[1]  = in.readLine();
                          row[2]  = in.readLine();
                          row[3]  = in.readLine();
                          while(row[3]!=null) {
                              model.addRow(row);
                              row[0] = in.readLine();
                              row[1]  = in.readLine();
                              row[2]  = in.readLine();
                              row[3]  = in.readLine();
                          }
                          in.close();
                      } catch ( IOException iox )
                      {
                          System.out.println("Problem reading " + fileName );
                      }

                     }

              });
              JButton jbtthem = new JButton("Thêm");
              jbtthem.setFont(new Font("Tahoma",Font.BOLD,10));
              jbtthem.setFocusable(false);//tat vien xung quanh button
              jbtthem.setBounds(650,180,90,25);
              jbtthem.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                    row[0]=txID.getText();
                    row[1]=txtens.getText();
                    row[2]=txtype.getText();
                    row[3]=txttaciga.getText();
                      String fileName = "sach.txt";
                      String ma,ten,loai,tacg;
                      int a=0;
                      try {
                          BufferedReader in = new BufferedReader(new FileReader(fileName));
                          FileWriter writer = new FileWriter(fileName, true);
                          ma=in.readLine();
                          ten=in.readLine();
                          loai=in.readLine();
                          tacg=in.readLine();
                          while (ma!=null)
                          {
                              if(ma.equals(row[0])) {a=1;System.out.println("huhu");break;}
                              else{
                                  ma=in.readLine();
                                  ten=in.readLine();
                                  loai=in.readLine();
                                  tacg=in.readLine();
                              }
                          }
                          in.close();
                          if(a==1) lbloi.setText("trùng mã sách");
                          else {
                              writer.write(row[0] + "\n");
                              writer.write(row[1] + "\n");
                              writer.write(row[2] + "\n");
                              writer.write(row[3] + "\n");
                              writer.close();
                              model.addRow(row);
                              String fileNd = row[0]+".txt" ;
                              try
                              {
                                  // append characters to the file
                                  FileWriter writernd = new FileWriter( fileNd, true );

                                  writernd.write(txtnoidung.getText().toString());

                                  writernd.close();
                              }
                              catch ( IOException iox )
                              {
                                  System.out.println("Problem writing " + fileName );
                              }
                          }
                      } catch (IOException ex) {
                          System.out.println("Problem reading " + fileName );
                      }
                  }
              });
              panel.add(jbtthem);
              JButton jbtxoa = new JButton("Xóa");
              jbtxoa.setFont(new Font("Tahoma",Font.BOLD,10));
              jbtxoa.setFocusable(false);//tat vien xung quanh button
              jbtxoa.setBounds(650,210,90,25);
              jbtxoa.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      String fileName = "sach.txt";
                      String filemoi="sachtam.txt";
                      String ma,ten,loai,tacg;
                      File nfile = new File(filemoi);
                      File ofile = new File(fileName);
                      try {
                          FileWriter writer = new FileWriter(filemoi, true);
                          BufferedReader in = new BufferedReader(new FileReader(ofile));
                          int n = jTable.getSelectedRow();
                          String filend=model.getValueAt(n,0).toString()+".txt";
                          File nd= new File(filend);
                          nd.delete();
                          ma = in.readLine();
                          ten = in.readLine();
                          loai = in.readLine();
                          tacg = in.readLine();

                          while (ma != null) {
                              if (!ma.equals(model.getValueAt(n,0).toString()))
                              {
                                  writer.write(ma + "\n");
                                  writer.write(ten + "\n");
                                  writer.write(loai + "\n");
                                  writer.write(tacg + "\n");
                              }
                              ma = in.readLine();
                              ten = in.readLine();
                              loai = in.readLine();
                              tacg = in.readLine();
                              }
                          writer.close();
                          in.close();
                          ofile.delete();
                          nfile.renameTo(new File(fileName));
                          if (n >= 0)
                              model.removeRow(n);
                          else lbloi.setText("Lỗi rồi huhu");

                      }catch (IOException iox) {
                          System.out.println("Problem reading " + fileName);
                      }
                  }
              });
              //
              JButton jbtdoc = new JButton("Đọc");
              jbtdoc.setFont(new Font("Tahoma",Font.BOLD,10));
              jbtdoc.setFocusable(false);//tat vien xung quanh button
              jbtdoc.setBounds(650,240,90,25);
              jbtdoc.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                      txtnoidung.setText(null);
                      int n = jTable.getSelectedRow();
                      String fileName = model.getValueAt(n,0).toString()+".txt";
                      String line;
                      try
                      {
                          BufferedReader in = new BufferedReader( new FileReader( fileName  ) );
                          line=in.readLine();
                          int i=0;
                          while (line!=null)
                          {     txtnoidung.append(line+"\n");
                              line=in.readLine();

                          }
                          in.close();
                      }
                      catch ( IOException iox )
                      {
                          System.out.println("Problem reading " + fileName );
                      }

                  }
              });
              panel.add(jbtdoc);
              panel.add(jbtxoa);
              panel.add(jbtLod);
              this.add(panel);
          }
       }