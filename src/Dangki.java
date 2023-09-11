import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Dangki extends JFrame {
    public Dangki()
    {
        this.setTitle("Thư viện số");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);
        //tieu de
        JLabel lbtieude= new JLabel("ĐĂNG KÍ");
        lbtieude.setBounds(200,20,120,35);
        lbtieude.setFont(new Font("Tahoma",Font.BOLD,20));
        lbtieude.setForeground(Color.PINK);
        panel.add(lbtieude);
        //ten
        JLabel lbten = new JLabel("Tên của bạn:");
        lbten.setBounds(120,65,80,25);
        JTextField txten = new JTextField();
        txten.setBounds(200,65,200,25);
        panel.add(lbten);
        panel.add(txten);
        //acc
        JLabel lbuser = new JLabel("Tài khoản:");
        lbuser.setBounds(120,100,80,25);
        JTextField txuser = new JTextField();
        txuser.setBounds(200,100,200,25);
        panel.add(lbuser);
        panel.add(txuser);
        //email
        JLabel lbemail = new JLabel("email:");
        lbemail.setBounds(120,135,80,25);
        JTextField  txemail = new JTextField();
        txemail.setBounds(200,135,200,25);
        panel.add(lbemail);
        panel.add(txemail);
        //pass
        JLabel lbpass = new JLabel("Mật khẩu:");
        lbpass.setBounds(120,170,80,25);
        JTextField  txpass = new JTextField();
        txpass.setBounds(200,170,200,25);
        panel.add(lbpass);
        panel.add(txpass);
        //xac nhan pass
        JLabel lbpass1 = new JLabel("Xác nhận lại:");
        lbpass1.setBounds(120,205,80,25);
        JTextField  txpass1 = new JTextField();
        txpass1.setBounds(200,205,200,25);
        panel.add(lbpass1);
        panel.add(txpass1);
        //hien thong báo
        JLabel lbloi = new JLabel();
        lbloi.setBounds(200,225,200,25);
        lbloi.setFont(new Font("Tahoma",Font.ITALIC,12));
        lbloi.setForeground(Color.RED);
        panel.add(lbloi);
        //button xác nhận
        JButton jbtxacnhan= new JButton("Xác nhận");
        jbtxacnhan.setFont(new Font("Tahoma",Font.BOLD,10));
        jbtxacnhan.setFocusable(false);//tat vien xung quanh button
        jbtxacnhan.setBounds(200,245,90,25);
        jbtxacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten=txten.getText();
                String tk=txuser.getText();
                String ema=txemail.getText();
                String mk=txpass.getText();
                String mk1=txpass1.getText();
                String fileName = "nguoidung.txt";
                String name,email,taikhon,matkha;
                int a=0;
                if(mk.equals(mk1))
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));
                        name = in.readLine();
                        taikhon = in.readLine();
                        email = in.readLine();
                        matkha = in.readLine();
                        while (name != null) {
                            if (tk.equals(taikhon))
                            {
                                a = 1;break;
                            }
                            else if(ema.equals(email))
                            {
                                a = 2;break;
                            }
                            else if(ten.equals(name))
                            {
                                a = 3;break;
                            }
                            else {
                                name = in.readLine();
                                taikhon = in.readLine();
                                email = in.readLine();
                                matkha = in.readLine();
                            }
                        }
                        in.close();
                        switch (a)
                        {
                            case 1:lbloi.setText("tài khoản bị trùng!!!");break;
                            case 2:lbloi.setText("email bị trùng!!!");break;
                            case 3:lbloi.setText("tên bị trùng!!!");break;
                            default:
                                FileWriter writer = new FileWriter(fileName, true);
                                writer.write(ten + "\n");
                                writer.write(tk + "\n");
                                writer.write(ema + "\n");
                                writer.write(mk + "\n");
                                writer.close();
                                lbloi.setText("Thành công!!!");
                        }
                    }
                    catch ( IOException iox )
                    {
                        System.out.println("Problem reading " + fileName );
                    }
                else lbloi.setText("mật khẩu không trùng!!!");
            }
        });
        panel.add(jbtxacnhan);
    }
}
class Quenmk extends JFrame {
    public Quenmk()
    {
        this.setTitle("Thư viện số");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);
        //tieu de
        JLabel lbtieude= new JLabel("ĐỔI MẬT KHẨU");
        lbtieude.setBounds(200,20,200,35);
        lbtieude.setFont(new Font("Tahoma",Font.BOLD,20));
        lbtieude.setForeground(Color.PINK);
        panel.add(lbtieude);
        //ten
        JLabel lbuser = new JLabel("Tài khoản:");
        lbuser.setBounds(120,65,80,25);
        JTextField txuser = new JTextField();
        txuser.setBounds(200,65,200,25);
        panel.add(lbuser);
        panel.add(txuser);
        //acc
        JLabel lbpass = new JLabel("mật khẩu mới:");
        lbpass.setBounds(120,100,80,25);
        JTextField txpass = new JTextField();
        txpass.setBounds(200,100,200,25);
        panel.add(lbpass);
        panel.add(txpass);
        //email
        JLabel lbpass1 = new JLabel("Xác nhận lại:");
        lbpass1.setBounds(120,135,80,25);
        JTextField  txpass1 = new JTextField();
        txpass1.setBounds(200,135,200,25);
        panel.add(lbpass1);
        panel.add(txpass1);
        //hien thong báo
        JLabel lbloi = new JLabel();
        lbloi.setBounds(200,155,200,25);
        lbloi.setFont(new Font("Tahoma",Font.ITALIC,12));
        lbloi.setForeground(Color.RED);
        panel.add(lbloi);
        //button xác nhận
        JButton jbtxacnhan= new JButton("Xác nhận");
        jbtxacnhan.setFont(new Font("Tahoma",Font.BOLD,10));
        jbtxacnhan.setFocusable(false);//tat vien xung quanh button
        jbtxacnhan.setBounds(200,180,90,25);
        jbtxacnhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tk=txuser.getText();
                String mk=txpass.getText();
                String mk1=txpass.getText();
                String fileName = "nguoidung.txt";
                String filemoi="tam.txt";
                File nfile = new File(filemoi);
                File ofile = new File(fileName);
                String ten,email,taikhon,matkha;
                int a=0;
                if(mk1.equals(mk))
                    try {
                        BufferedReader in = new BufferedReader(new FileReader(fileName));
                        FileWriter writer = new FileWriter(filemoi, true);
                        ten = in.readLine();
                        taikhon = in.readLine();
                        email = in.readLine();
                        matkha = in.readLine();
                        while (ten != null) {
                            if (tk.equals(taikhon))
                                    a=1;
                            ten = in.readLine();
                            taikhon = in.readLine();
                            email = in.readLine();
                            matkha = in.readLine();
                        }
                        in.close();
                        if(a==0) lbloi.setText("không có tài khoản này");
                        else {
                            BufferedReader in1 = new BufferedReader(new FileReader(fileName));
                            ten = in1.readLine();
                            taikhon = in1.readLine();
                            email = in1.readLine();
                            matkha = in1.readLine();
                            while (ten != null) {
                                if (tk.equals(taikhon)) {
                                    writer.write(ten + "\n");
                                    writer.write(taikhon + "\n");
                                    writer.write(email + "\n");
                                    writer.write(mk + "\n");
                                } else {
                                    writer.write(ten + "\n");
                                    writer.write(taikhon + "\n");
                                    writer.write(email + "\n");
                                    writer.write(matkha + "\n");
                                }

                                ten = in1.readLine();
                                taikhon = in1.readLine();
                                email = in1.readLine();
                                matkha = in1.readLine();

                            }
                            writer.close();
                            in1.close();
                            lbloi.setText("THành công!!!");
                            ofile.delete();
                            nfile.renameTo(new File(fileName));
                        }
                    } catch (IOException iox) {
                        System.out.println("Problem reading " + fileName);
                    }

                else lbloi.setText("mật khẩu không trùng!!!");
            }
        });
        panel.add(jbtxacnhan);

    }
}
